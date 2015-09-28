package com.tencent.protocol.pay_protocol;

/**
 * User: rizenguo
 * Date: 2014/10/22
 * Time: 21:29
 */

import com.tencent.common.Configure;
import com.tencent.common.RandomStringGenerator;
import com.tencent.common.Signature;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * 请求JS支付API需要提交的数据
 */
public class JSPayReqData {


    /**
     * 公众账号ID
     * appid
     * 是
     * String(32)
     * wx8888888888888888
     * 微信分配的公众账号ID
     * 商户号
     * mch_id
     * 是
     * String(32)
     * 1900000109
     * 微信支付分配的商户号
     * 设备号
     * device_info
     * 否
     * String(32)
     * 013467007045764
     * 终端设备号(门店号或收银设备ID)，注意：PC网页或公众号内支付请传"WEB"
     * 随机字符串
     * nonce_str
     * 是
     * String(32)
     * 5K8264ILTKCH16CQ2502SI8ZNMTM67VS
     * 随机字符串，不长于32位。推荐随机数生成算法
     * 签名
     * sign
     * 是
     * String(32)
     * C380BEC2BFD727A4B6845133519F3AD6
     * 签名，详见签名生成算法
     * 商品描述
     * body
     * 是
     * String(32)
     * Ipad mini  16G  白色
     * 商品或支付单简要描述
     * 商品详情
     * detail
     * 否
     * String(8192)
     * Ipad mini  16G  白色
     * 商品名称明细列表
     * 附加数据
     * attach
     * 否
     * String(127)
     * 说明
     * 附加数据，在查询API和支付通知中原样返回，该字段主要用于商户携带订单的自定义数据
     * 商户订单号
     * out_trade_no
     * 是
     * String(32)
     * 1217752501201407033233368018
     * 商户系统内部的订单号,32个字符内、可包含字母, 其他说明见商户订单号
     * 货币类型
     * fee_type
     * 否
     * String(16)
     * CNY
     * 符合ISO 4217标准的三位字母代码，默认人民币：CNY，其他值列表详见货币类型
     * 总金额
     * total_fee
     * 是
     * Int
     * 888
     * 订单总金额，只能为整数，详见支付金额
     * 终端IP
     * spbill_create_ip
     * 是
     * String(16)
     * 8.8.8.8
     * APP和网页支付提交用户端ip，Native支付填调用微信支付API的机器IP。
     * 交易起始时间
     * time_start
     * 否
     * String(14)
     * 20091225091010
     * 订单生成时间，格式为yyyyMMddHHmmss，如2009年12月25日9点10分10秒表示为20091225091010。其他详见时间规则
     * 交易结束时间
     * time_expire
     * 否
     * String(14)
     * 20091227091010
     * 订单失效时间，格式为yyyyMMddHHmmss，如2009年12月27日9点10分10秒表示为20091227091010。其他详见时间规则
     * 商品标记
     * goods_tag
     * 否
     * String(32)
     * WXG
     * 商品标记，代金券或立减优惠功能的参数，说明详见代金券或立减优惠
     * 通知地址
     * notify_url
     * 是
     * String(256)
     * http://www.baidu.com/
     * 接收微信支付异步通知回调地址
     * 交易类型
     * trade_type
     * 是
     * String(16)
     * JSAPI
     * 取值如下：JSAPI，NATIVE，APP，WAP,详细说明见参数规定
     * 商品ID
     * product_id
     * 否
     * String(32)
     * 12235413214070356458058
     * trade_type=NATIVE，此参数必传。此id为二维码中包含的商品ID，商户自行定义。
     * 用户标识
     * openid
     * 否
     * String(128)
     * oUpF8uMuAJO_M2pxb1Q9zNjWeS6o
     * trade_type=JSAPI，此参数必传，用户在商户appid下的唯一标识。下单前需要调用【网页授权获取用户信息】接口获取到用户的Openid。
     */

    //每个字段具体的意思请查看API文档
    private String appid = "";
    private String mch_id = "";
    private String device_info = "";
    private String nonce_str = "";
    private String sign = "";
    private String body = "";
    private String detail = "";
    private String attach = "";
    private String out_trade_no = "";
    private String fee_type = "CNY";
    private int total_fee = 0;
    private String spbill_create_ip = "";
    private String time_start = "";
    private String time_expire = "";
    private String goods_tag = "";
    private String notify_url = "";
    private String trade_type = "";
    private String product_id = "";
    private String openid = "";

    /**
     * @param body           要支付的商品的描述信息，用户会在支付成功页面里看到这个信息
     * @param attach         支付订单里面可以填的附加数据，API会将提交的这个附加数据原样返回
     * @param outTradeNo     商户系统内部的订单号,32个字符内可包含字母, 确保在商户系统唯一
     * @param totalFee       订单总金额，单位为“分”，只能整数
     * @param spBillCreateIP 订单生成的机器IP
     * @param timeStart      订单生成时间， 格式为yyyyMMddHHmmss，如2009年12 月25 日9 点10 分10 秒表示为20091225091010。时区为GMT+8 beijing。该时间取自商户服务器
     * @param timeExpire     订单失效时间，格式同上
     * @param goodsTag       商品标记，微信平台配置的商品标记，用于优惠券或者满减使用
     */
    public JSPayReqData(String body, String attach, String outTradeNo, int totalFee, String spBillCreateIP,
                        String timeStart, String timeExpire, String goodsTag,String openId) {

        //微信分配的公众号ID（开通公众号之后可以获取到）
        setAppid(Configure.getAppid());

        //微信支付分配的商户号ID（开通公众号的微信支付功能之后可以获取到）
        setMch_id(Configure.getMchid());

        //终端设备号(门店号或收银设备ID)，注意：PC网页或公众号内支付请传"WEB"
        setDevice_info("WEB");

        //随机字符串，不长于32 位
        setNonce_str(RandomStringGenerator.getRandomStringByLength(32));

        //要支付的商品的描述信息，用户会在支付成功页面里看到这个信息
        setBody(body);

        //商品名称明细列表
        setDetail(body);

        //支付订单里面可以填的附加数据，API会将提交的这个附加数据原样返回，有助于商户自己可以注明该笔消费的具体内容，方便后续的运营和记录
        setAttach(attach);

        //商户系统内部的订单号,32个字符内可包含字母, 确保在商户系统唯一
        setOut_trade_no(outTradeNo);

        //符合ISO 4217标准的三位字母代码，默认人民币：CNY，其他值列表详见货币类型
        setFee_type("CNY");

        //订单总金额，单位为“分”，只能整数
        setTotal_fee(totalFee);

        //订单生成的机器IP
        setSpbill_create_ip(spBillCreateIP);

        //订单生成时间， 格式为yyyyMMddHHmmss，如2009年12 月25 日9 点10 分10 秒表示为20091225091010。时区为GMT+8 beijing。该时间取自商户服务器
        setTime_start(timeStart);

        //订单失效时间，格式同上
        setTime_expire(timeExpire);

        //商品标记，微信平台配置的商品标记，用于优惠券或者满减使用
        setGoods_tag(goodsTag);

        //接收微信支付异步通知回调地址
        //TODO
        setNotify_url(Configure.NOTIFY_URL);

        //取值如下：JSAPI，NATIVE，APP，WAP,详细说明见参数规定
        setTrade_type("JSAPI");

        //trade_type=NATIVE，此参数必传。此id为二维码中包含的商品ID，商户自行定义。
        setProduct_id("");

        //trade_type=JSAPI，此参数必传，用户在商户appid下的唯一标识。下单前需要调用【网页授权获取用户信息】接口获取到用户的Openid。
        setOpenid(openId);

        //根据API给的签名规则进行签名
        String sign = Signature.getSign(toMap());
        setSign(sign);//把签名数据设置到Sign这个属性中

    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getMch_id() {
        return mch_id;
    }

    public void setMch_id(String mch_id) {
        this.mch_id = mch_id;
    }

    public String getDevice_info() {
        return device_info;
    }

    public void setDevice_info(String device_info) {
        this.device_info = device_info;
    }

    public String getNonce_str() {
        return nonce_str;
    }

    public void setNonce_str(String nonce_str) {
        this.nonce_str = nonce_str;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getAttach() {
        return attach;
    }

    public void setAttach(String attach) {
        this.attach = attach;
    }

    public String getOut_trade_no() {
        return out_trade_no;
    }

    public void setOut_trade_no(String out_trade_no) {
        this.out_trade_no = out_trade_no;
    }

    public int getTotal_fee() {
        return total_fee;
    }

    public void setTotal_fee(int total_fee) {
        this.total_fee = total_fee;
    }

    public String getSpbill_create_ip() {
        return spbill_create_ip;
    }

    public void setSpbill_create_ip(String spbill_create_ip) {
        this.spbill_create_ip = spbill_create_ip;
    }

    public String getTime_start() {
        return time_start;
    }

    public void setTime_start(String time_start) {
        this.time_start = time_start;
    }

    public String getTime_expire() {
        return time_expire;
    }

    public void setTime_expire(String time_expire) {
        this.time_expire = time_expire;
    }

    public String getGoods_tag() {
        return goods_tag;
    }

    public void setGoods_tag(String goods_tag) {
        this.goods_tag = goods_tag;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getFee_type() {
        return fee_type;
    }

    public void setFee_type(String fee_type) {
        this.fee_type = fee_type;
    }

    public String getNotify_url() {
        return notify_url;
    }

    public void setNotify_url(String notify_url) {
        this.notify_url = notify_url;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    public String getTrade_type() {
        return trade_type;
    }

    public void setTrade_type(String trade_type) {
        this.trade_type = trade_type;
    }

    public Map<String, Object> toMap() {
        Map<String, Object> map = new HashMap<String, Object>();
        Field[] fields = this.getClass().getDeclaredFields();
        for (Field field : fields) {
            Object obj;
            try {
                obj = field.get(this);
                if (obj != null) {
                    map.put(field.getName(), obj);
                }
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return map;
    }

}
