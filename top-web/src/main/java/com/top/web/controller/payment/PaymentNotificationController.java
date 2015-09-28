package com.top.web.controller.payment;

import com.alibaba.fastjson.JSON;
import com.alipay.config.AlipayConfig;
import com.alipay.util.AlipayNotify;
import com.mycila.xmltool.XMLDoc;
import com.tencent.common.XMLParser;
import com.top.core.controller.AbstractController;
import com.top.core.utils.DateUtils;
import com.top.core.utils.ResultValues;
import org.apache.commons.lang3.StringUtils;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


/**
 * Created with IntelliJ IDEA.
 * User: Wang Lei
 * Date: January 31, 2015
 * Time: 14:53
 * 支付通知*
 */
@Controller
@RequestMapping("notify")
public class PaymentNotificationController extends AbstractController {

    /**
     * 处理支付宝发来的异步通知
     *
     * @param request
     * @throws java.io.UnsupportedEncodingException
     */
    @RequestMapping("alipay/mobile")
    @ResponseBody
    public String alipay(HttpServletRequest request) throws Exception {

        //获取支付宝POST过来反馈信息
        Map<String, String> params = new HashMap<String, String>();
        Map requestParams = request.getParameterMap();
        for (Iterator iter = requestParams.keySet().iterator(); iter.hasNext(); ) {
            String name = (String) iter.next();
            String[] values = (String[]) requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i]
                        : valueStr + values[i] + ",";
            }
            //乱码解决，这段代码在出现乱码时使用。如果mysign和sign不相等也可以使用这段代码转化
            //valueStr = new String(valueStr.getBytes("ISO-8859-1"), "gbk");
            params.put(name, valueStr);
        }

        //获取支付宝的通知返回参数，可参考技术文档中页面跳转同步通知参数列表(以下仅供参考)//

        //RSA签名解密
        if (AlipayConfig.sign_type.equals("0001")) {
            params = AlipayNotify.decrypt(params);
        }
        //XML解析notify_data数据
        Document doc_notify_data = DocumentHelper.parseText(params.get("notify_data"));

        //商户订单号
        String out_trade_no = doc_notify_data.selectSingleNode("//notify/out_trade_no").getText();

        //支付宝交易号
        String trade_no = doc_notify_data.selectSingleNode("//notify/trade_no").getText();

        //交易状态
        String trade_status = doc_notify_data.selectSingleNode("//notify/trade_status").getText();

        String total_fee = doc_notify_data.selectSingleNode("//notify/total_fee").getText();

        String notifyTime = doc_notify_data.selectSingleNode("//notify/notify_time").getText();

        String buyer_id = doc_notify_data.selectSingleNode("//notify/buyer_id").getText();

        String subject = doc_notify_data.selectSingleNode("//notify/subject").getText();

        //获取支付宝的通知返回参数，可参考技术文档中页面跳转同步通知参数列表(以上仅供参考)//

        if (AlipayNotify.verifyNotify(params)) {
            //验证成功
            log.info("Alipay verification success");
            log.info("Handling trade status: " + trade_status);
            //////////////////////////////////////////////////////////////////////////////////////////
            //请在这里加上商户的业务逻辑程序代码
            //——请根据您的业务逻辑来编写程序（以下代码仅作参考）——
            if (trade_status.equals("TRADE_FINISHED")) {
                //判断该笔订单是否在商户网站中已经做过处理
                //如果没有做过处理，根据订单号（out_trade_no）在商户网站的订单系统中查到该笔订单的详细，并执行商户的业务程序
                //如果有做过处理，不执行商户的业务程序
                //注意：
                //该种交易状态只在两种情况下出现
                //1、开通了普通即时到账，买家付款成功后。
                //2、开通了高级即时到账，从该笔交易成功时间算起，过了签约时的可退款时限（如：三个月以内可退款、一年以内可退款等）后。
                return "success";//请不要修改或删除
            } else if (trade_status.equals("TRADE_SUCCESS")) {
                //判断该笔订单是否在商户网站中已经做过处理
                //如果没有做过处理，根据订单号（out_trade_no）在商户网站的订单系统中查到该笔订单的详细，并执行商户的业务程序
                //如果有做过处理，不执行商户的业务程序
                //注意：
                //该种交易状态只在一种情况下出现——开通了高级即时到账，买家付款成功后。
                tradeRecordService.add(trade_no, out_trade_no, DateUtils.str2Timestamp(notifyTime), total_fee, trade_status, buyer_id, subject);
                boolean success = orderService.onConfirmPayment(out_trade_no, new BigDecimal(total_fee));
                if (success) {
                    return "success";
                } else {
                    return "fail";
                }
            }

            //——请根据您的业务逻辑来编写程序（以上代码仅作参考）——
            //////////////////////////////////////////////////////////////////////////////////////////
        } else {//验证失败
            log.info("Alipay verification fail");
            return "fail";//请不要修改或删除
//            out.println("fail");
        }
        return "fail";

    }


    /**
     * 处理微信发来的异步通知
     *
     * @param request
     * @throws java.io.UnsupportedEncodingException
     */
    @RequestMapping("wxpay")
    @ResponseBody
    public String wxPay(HttpServletRequest request) throws Exception {

        Map<String, String> params = XMLParser.parseXml(request);

        log.info("notify/wxpay:" + JSON.toJSONString(params));

        String return_code = params.get("return_code").toString();
        if (!return_code.equals(ResultValues.SUCCESS)) {
            String return_msg = params.get("return_msg").toString();
        }
        String result_code = params.get("result_code").toString();
        String out_trade_no = params.get("out_trade_no").toString();
        String total_fee = params.get("total_fee").toString();
        String transaction_id = params.get("transaction_id").toString();
        String time_end = params.get("time_end").toString();

        String openid = params.get("openid").toString();
        String attach = params.get("attach").toString();

        if (StringUtils.equals(return_code, "SUCCESS") && StringUtils.equals(result_code, "SUCCESS")) {
            total_fee = (Double.valueOf(total_fee) / 100) + "";
            Calendar calendar = DateUtils.convToCalender(time_end, DateUtils.dtLong2);
            Timestamp notifyTime = DateUtils.str2Timestamp(DateUtils.date2Str(calendar.getTime(), DateUtils.DEFAULT_FORMAT1));

            tradeRecordService.add(transaction_id, out_trade_no, notifyTime, total_fee, result_code, openid, attach);
            boolean success = orderService.onConfirmPayment(out_trade_no, new BigDecimal(total_fee));
            if (success) {
                return XMLDoc.newDocument().addRoot("xml").addTag("return_code").addCDATA(ResultValues.SUCCESS).toString();
            } else {
                return XMLDoc.newDocument().addRoot("xml").addTag("return_code").addCDATA(ResultValues.FAIL).toString();

            }
        }
        return XMLDoc.newDocument().addRoot("xml").addTag("return_code").addCDATA(ResultValues.FAIL).toString();


    }


    /**
     * 支付宝同步通知
     *
     * @return
     */
    @RequestMapping("notify/alipay/mobile/return")
    public String returnUrl() {
        return "alipay/call_back_url_mobile";

    }
}
