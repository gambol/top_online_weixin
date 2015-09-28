package com.top.web.controller;

import com.alibaba.fastjson.JSON;
import com.alipay.config.AlipayConfig;
import com.alipay.util.AlipaySubmit;
import com.alipay.util.UtilDate;
import com.github.sd4324530.fastweixin.api.JsAPI;
import com.github.sd4324530.fastweixin.api.response.GetSignatureResponse;
import com.google.common.base.Optional;
import com.tencent.WXPay;
import com.tencent.common.Configure;
import com.tencent.common.MD5;
import com.tencent.common.Sign;
import com.tencent.common.XMLParser;
import com.tencent.protocol.pay_protocol.JSPayReqData;
import com.top.core.controller.AbstractController;
import com.top.core.domain.UserInfoEntity;
import com.top.core.utils.ResultValues;
import com.top.core.utils.ServletUtils;
import com.top.core.viewmodel.OrderViewModel;
import com.top.core.viewmodel.ResultModel;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.triiskelion.tinyspring.security.SecurityCheck;
import org.triiskelion.tinyspring.viewmodel.Page;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Created by Wang Lei.
 * Date on 2015/1/29
 * Time 10:56
 * TODO 微信创建订单接口
 */
@Controller
@RequestMapping("order")
@SecurityCheck
public class OrderController extends AbstractController {

    /**
     * 手机网页支付创建订单test页面
     *
     * @return
     */
    @RequestMapping("test")
    public String test() {

        return "alipay/index";

    }

    /**
     * 创建订单
     *
     * @param session
     * @param projectId   购买的项目id
     * @param fullPayment 是否付全款
     * @param discount    积分抵现
     * @param finalFee    最终价格
     * @return
     */
    @RequestMapping("create")
    @ResponseBody
    public ResultModel create(HttpSession session, @RequestParam Integer projectId,
                              @RequestParam boolean fullPayment,
                              @RequestParam double discount,
                              @RequestParam double finalFee) {

        ResultModel resultModel = new ResultModel();
        Integer userId = ServletUtils.resolveUserId(session);

        String res
                = orderService.create(userId, projectId, fullPayment, discount, finalFee);

        if (Objects.equals(res, ResultValues.USER_NOT_FOUND)
                || Objects.equals(res, ResultValues.CATEGORY_NOT_FOUND)
                || Objects.equals(res, ResultValues.FAILURE)) {
            resultModel.setCode(ResultModel.CODE_FAILURE);
            resultModel.setMsg(res);
        } else {
            resultModel.setMsg(ResultValues.SUCCESS);
            resultModel.setData(res);
        }
        return resultModel;
    }


    /**
     * 查询订单详情
     *
     * @param session
     * @param orderNo 订单号
     * @return
     */
    @RequestMapping("orderInfo")
    @ResponseBody
    public ResultModel getOrderInfo(HttpSession session, @RequestParam String orderNo) {

        ResultModel resultModel = new ResultModel();
        Integer userId = ServletUtils.resolveUserId(session);
        try {
            OrderViewModel res = orderService.getOrderInfo(userId, orderNo);
            if (res == null) {
                resultModel.setCode(ResultModel.CODE_FAILURE);
            } else {
                resultModel.setMsg(ResultValues.SUCCESS);
                resultModel.setData(res);
            }

        } catch (IllegalArgumentException e) {
            log.error("getOrderInfo is error:" + e.getMessage());
            resultModel.setCode(ResultModel.CODE_FAILURE);
            resultModel.setMsg(e.getMessage());
        }
        return resultModel;
    }


    /**
     * 确认支付
     *
     * @param session
     * @param request
     * @param orderNo
     * @param model
     * @return
     */
    @RequestMapping("pay_mode")
    public String pay_mode(HttpSession session, HttpServletRequest request,
                           @RequestParam String orderNo, ModelMap model) {

        Optional<UserInfoEntity> optional = userService.getUserInfoById(ServletUtils.resolveUserId(session));
        if (!optional.isPresent()) {
            return "redirect:/home/enroll";
        }
        try {
            if (true) {
                JsAPI jsAPI = new JsAPI(getApiConfig());
                GetSignatureResponse response = jsAPI.getSignature(request.getRequestURL().toString() + "?orderNo=" + orderNo);

                model.addAttribute("appId", Configure.getAppid());
                model.addAttribute("timestamp", response.getTimestamp());
                model.addAttribute("nonceStrc", response.getNoncestr());
                model.addAttribute("signature", response.getSignature());
            }
            OrderViewModel order = orderService.getOrderInfo(optional.get().getId(), orderNo);
            model.addAttribute("model", order);
            return "online/pay_mode";

        } catch (IllegalArgumentException e) {
            log.error("could not get order: {}", e.getMessage());
            return "redirect:/home/enroll";
        }
    }

    /**
     * 查询订单列表
     *
     * @param session
     * @param page
     * @param max
     * @return
     */
    @RequestMapping("orderList")
    @ResponseBody
    public ResultModel getOrderList(HttpSession session,
                                    @RequestParam(required = false, defaultValue = "1")
                                    Integer page,
                                    @RequestParam(required = false, defaultValue = "10")
                                    Integer max) {

        ResultModel resultModel = new ResultModel();
        Integer userId = ServletUtils.resolveUserId(session);
        try {
            Page<OrderViewModel> res = orderService.getOrderList(userId, page, max);
            if (res == null) {
                resultModel.setCode(ResultModel.CODE_FAILURE);
            } else {
                resultModel.setMsg(ResultValues.SUCCESS);
                resultModel.setData(res);
            }
        } catch (IllegalArgumentException e) {
            log.error("getOrderList is error:" + e.getMessage());
            resultModel.setCode(ResultModel.CODE_FAILURE);
            resultModel.setMsg(e.getMessage());
        }
        return resultModel;
    }

    /**
     * 支付宝支付
     *
     * @param session
     * @param model
     * @param orderNo
     * @return
     */
    @RequestMapping(value = "payByAlipay", method = RequestMethod.POST)
    public String pay(HttpSession session, Model model, @RequestParam String orderNo) {

        Integer userId = ServletUtils.resolveUserId(session);
        try {
            OrderViewModel order = orderService.getOrderInfo(userId, orderNo);
            if (order != null) {
                String htmlContent
                        = AlipaySubmit.createHtmlContent(session.getId(), order.getOrderNumber(), "0.01", AlipayConfig.name + "-" + order.getDescription());
                model.addAttribute("html", htmlContent);
                return "alipay/payment_redirect";
            }
        } catch (IllegalArgumentException e) {
            log.error(e.getMessage());
            return "redirect:/home/enroll";
        }
        return "alipay/payment_illegal";

    }

    /**
     * 微信支付
     *
     * @param session
     * @param orderNo
     * @return
     */
    @RequestMapping(value = "payByWeChat", method = RequestMethod.POST)
    @ResponseBody
    public String payByWeChat(HttpSession session, HttpServletRequest request,
                              @RequestParam String orderNo, Model map) {

        Map resultMap = new HashMap<>();
        Integer userId = ServletUtils.resolveUserId(session);
        try {
            OrderViewModel order = orderService.getOrderInfo(userId, orderNo);

            String openId = (String) session.getAttribute("wx_openId");
            if (StringUtils.isBlank(openId)) {
                map.addAttribute("state", Configure.STATE_WX_JS_PAY);
                resultMap.put("err_code_des", "登录超时");
                resultMap.put("err_code", ResultValues.AUTHENTICATION_DENIED);
                return JSON.toJSONString(resultMap);
            }
//            JSPayReqData data
//                    = new JSPayReqData(AlipayConfig.name + "-" + order.getDescription(), order.getOrderNumber(), order.getOrderNumber(),
//                    order.getPrice().multiply(new BigDecimal(100)).intValue(), request.getRemoteAddr() + "", UtilDate.getTodayFullTime(), UtilDate.getTomorrowFullTime(), "", openId);
            JSPayReqData data
                    = new JSPayReqData(AlipayConfig.name + "-" + order.getDescription(), order.getOrderNumber(), order.getOrderNumber(),
                    1, request.getRemoteAddr() + "", UtilDate.getTodayFullTime(), UtilDate.getTomorrowFullTime(), "", openId);
            String xml = WXPay.requestPayService(data);
            Map params = XMLParser.getMapFromXML(xml);
            if (StringUtils.equals(params.get("return_code").toString(), "SUCCESS")
                    && StringUtils.equals(params.get("result_code").toString(), "SUCCESS")) {
                String tmp = Sign.create_timestamp();
                String str = "appId=" + Configure.getAppid() + "&nonceStr=" + params.get("nonce_str")
                        + "&package=prepay_id=" + params.get("prepay_id") + "&signType=MD5&timeStamp=" + tmp
                        + "&key=" + Configure.getKey();
                String paySign = MD5.MD5Encode(str).toUpperCase();

                resultMap.put("appId", Configure.getAppid());
                resultMap.put("timeStamp", tmp);
                resultMap.put("nonceStr", params.get("nonce_str"));
                resultMap.put("package_prepay_id", "prepay_id=" + params.get("prepay_id"));
                resultMap.put("paySign", paySign);
                resultMap.put("orderId", orderNo);

                return JSON.toJSONString(resultMap);
            } else if (StringUtils.equals(params.get("result_code").toString(), "FAIL")) {
                resultMap.put("err_code_des", params.get("err_code_des"));
                return JSON.toJSONString(resultMap);
            }
        } catch (Exception e) {
            e.printStackTrace();
            resultMap.put("err_code_des", "未知错误" + e.getMessage());
        }
        return JSON.toJSONString(resultMap);
    }

    @RequestMapping("success")
    public String success(HttpSession session) {

        return "online/success";
    }

}
