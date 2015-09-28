package com.alipay.config;

/* *手机网页专用
 *类名：AlipayConfig  手机网页专用
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *版本：3.3
 *日期：2012-08-10
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
	
 *提示：如何获取安全校验码和合作身份者ID
 *1.用您的签约支付宝账号登录支付宝网站(www.alipay.com)
 *2.点击“商家服务”(https://b.alipay.com/order/myOrder.htm)
 *3.点击“查询合作者身份(PID)”、“查询安全校验码(Key)”

 *安全校验码查看时，输入支付密码后，页面呈灰色的现象，怎么办？
 *解决方法：
 *1、检查浏览器配置，不让浏览器做弹框屏蔽设置
 *2、更换浏览器或电脑，重新登录查询。
 */

public class AlipayConfig {

    //↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓
    // 合作身份者ID，以2088开头由16位纯数字组成的字符串
    public static String partner = "2088811518335407";

    // 卖家收款支付宝帐户
    static public String seller_email = "wtyqdtop@126.com";

    // 交易安全检验码，由数字和字母组成的32位字符串
    // 如果签名方式设置为“MD5”时，请设置该参数
    public static String key = "iz3wx9e966k4ysgowvk4w4f0lrk3cdg5";

    // 商户的私钥
    // 如果签名方式设置为“0001”时，请设置该参数
    public static String private_key = "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAMOVATfkq5JvFsIrQle+N9pjLQGakT0MizCeOQXLFIzyhJzsqD24dy/L7oX8CXd1pVGLIqYnbkuxo781qn6wzbkoDFUFkKlc8Df0THFhSvGAeaGFDjarweteXIRJ1RjE0q0M+e9D6zCDqmOvj/TenQn9pqH2DaqHURt6JVlYLHHvAgMBAAECgYANYbCHpnmmtzsTZepQHo+rvYViyrSNPMJ5PRohr1dknWM9aWPJdUmSV52mRSxQpBf/kEl6nNALFchiWMWljWtF1TUd/CHW5lH4c822O42EIdYvNxvxdKyGQNeMVkZefiexR5CY9xrgCS6GslEkokfvlF+HnXCdx2qO83eDS1zqoQJBAOoHO48hRyDgT2mrpPaVdrfvNa/eBacyWMGu97ckc0UKkdT6T1+IgebR/6M4tqGlfAokNCtMnEH6+hGZS6aVwDUCQQDV8bv9LpUmxjc6HoNEW4VTQYMNaiohrcdJcwUMBuzywQ8oXMStITCM8Q+7ggH7ZJuit94X7dxBqc5lNZKq9DYTAkA4V5ltMhPPxHEZ/arverhkPADu4EL4J9TafGdC/lGKE6tcXQ7y7whnK7Oh9itx60dboa+1pPIRqHy/8+oUpwTpAkBpoPlEzov7YeAAhPIgfOM9sNmodOMqT6dWH0C9qGmyjRkTv4GnTPywiZBP7qdV3F1vIEK6I8kcbl8l3yZz2zEbAkEAvVaFpuubgSEjlRPIAPO9tOphMfcJvtFUZBsW1wU4n6QVieiXiIF6HqVVTZvK/9Kn1zGsIILdGYQmdKy0f7C0zQ==";

    // 支付宝的公钥  手机网页支付使用的公钥
    // 如果签名方式设置为“0001”时，请设置该参数
    public static String ali_public_key = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCNM1NWgpwmkJG6rJGR7QYMO/OI2LwxKN/dB+PPUXyIOdBfO0e+IDDX2swVYzds5d89mV9ymRNcx/0YNBDOXHJm8SlBM4IyZ/Y7zTjRso/vcWmv9ZbX84IIgJqKl5gTCdBhsbmRzkPrhCWePYCqauesIdJqtrJWwVP1wTmUTS278wIDAQAB";

    //↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    //页面跳转同步通知页面路径
    static public String return_url = "http://member.oltop.cn/order/success";

    //服务器异步通知页面路径
    static public String notify_url = "http://member.oltop.cn/notify/alipay/mobile";

    //操作中断返回地址
    public static String merchant_url = "http://member.oltop.cn";
    //用户付款中途退出返回商户的地址。需http://格式的完整路径，不允许加?id=123这类自定义参数

    /**
     * 支付宝 直接到帐 交易状态：交易成功
     */
    public static final String TRADE_STATUS_TRADE_SUCCESS = "TRADE_SUCCESS";

    // 订单名称
    static public String name = "托普在线";

    // 调试用，创建TXT日志文件夹路径
    public static String log_path = "D:\\";

    // 字符编码格式 目前支持  utf-8
    public static String input_charset = "utf-8";

    // 签名方式，选择项：0001(RSA)、MD5
    public static String sign_type = "0001";
    // 无线的产品中，签名方式为rsa时，sign_type需赋值为0001而不是RSA

}
