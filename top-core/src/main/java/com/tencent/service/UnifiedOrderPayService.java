package com.tencent.service;

import com.tencent.common.Configure;
import com.tencent.protocol.pay_protocol.JSPayReqData;

/**
 * User: rizenguo
 * Date: 2014/10/29
 * Time: 16:03
 * 统一支付接口，可接叐JSAPI/NATIVE/APP 下预支付订单，返回预支付订单号。
 * NATIVE 支付返回二维码 code_url。
 * 注意：JSAPI 下单前需要调用登录授权接口(详细调用说明请点击打开链接)获叏到用户
 * 的 Openid。
 */
public class UnifiedOrderPayService extends BaseService {

    public UnifiedOrderPayService() throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        super(Configure.PAY_UNIFIED_ORDER_API);
    }

    /**
     * 请求支付服务
     *
     * @param jsPayReqData 这个数据对象里面包含了API要求提交的各种数据字段
     * @return API返回的数据
     * @throws Exception
     */
    public String request(JSPayReqData jsPayReqData) throws Exception {

        //--------------------------------------------------------------------
        //发送HTTPS的Post请求到API地址
        //--------------------------------------------------------------------
        String responseString = sendPost(jsPayReqData);

        return responseString;
    }
}
