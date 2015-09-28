package com.tencent.common.report.protocol;

import com.tencent.common.Configure;
import com.tencent.common.RandomStringGenerator;
import com.tencent.common.Signature;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * User: rizenguo
 * Date: 2014/11/12
 * Time: 17:05
 */
public class ReportReqData {

    //ÿ���ֶξ������˼��鿴API�ĵ�
    private String appid;
    private String mch_id;
    private String sub_mch_id;
    private String device_info;
    private String nonce_str;
    private String sign;

    //�ϱ���Ӧ�Ľӿڵ�����URL�����ƣ�https://api.mch.weixin.qq.com/pay/unifiedorder
    private String interface_url;
    //�ӿں�ʱ�������λΪ����
    private int execute_time_cost;
    //����ӿڵ���ʱ�Ļ���IP
    private String user_ip;
    //�ϱ���ͳ������ʱ��ϵͳʱ�䣬��ʽΪyyyyMMddHHmmss
    private String time;

    //������API�ӿڷ��صĶ�Ӧ����
    private String return_code;
    private String return_msg;
    private String result_code;
    private String err_code;
    private String err_code_des;
    private String out_trade_no;

    /**
     * ����ͳ���ϱ�API
     * @param deviceInfo ΢��֧��������ն��豸�ţ��̻��Զ���
     * @param interfaceUrl �ϱ���Ӧ�Ľӿڵ�����URL�����ƣ� https://api.mch.weixin.qq.com/pay/unifiedorder
     * @param executeTimeCost �ӿں�ʱ�������λΪ����
     * @param returnCode API���صĶ�Ӧ�ֶ�
     * @param returnMsg API���صĶ�Ӧ�ֶ�
     * @param resultCode API���صĶ�Ӧ�ֶ�
     * @param errCode API���صĶ�Ӧ�ֶ�
     * @param errCodeDes API���صĶ�Ӧ�ֶ�
     * @param outTradeNo API���صĶ�Ӧ�ֶ�
     * @param userIp ����ӿڵ���ʱ�Ļ���IP
     */
    public ReportReqData(String deviceInfo, String interfaceUrl,int executeTimeCost, String returnCode,String returnMsg,String resultCode,String errCode,String errCodeDes, String outTradeNo,String userIp){
        //΢�ŷ���Ĺ��ں�ID����ͨ���ں�֮����Ի�ȡ����
        setAppid(Configure.getAppid());

        //�̻�ϵͳ�Լ����ɵ�Ψһ�Ķ�����
        setOut_trade_no(outTradeNo);

        //΢��֧��������̻���ID����ͨ���ںŵ�΢��֧������֮����Ի�ȡ����
        setMch_id(Configure.getMchid());
        setSub_mch_id(Configure.getSubMchid());
        setDevice_info(deviceInfo);
        setInterface_url(interfaceUrl);
        setExecute_time_cost(executeTimeCost);
        setReturn_code(returnCode);
        setReturn_msg(returnMsg);
        setResult_code(resultCode);
        setErr_code(errCode);
        setErr_code_des(errCodeDes);
        setUser_ip(userIp);
        setTime(getTime());

        //����ַ�����������32 λ
        setNonce_str(RandomStringGenerator.getRandomStringByLength(32));

        //����API����ǩ���������ǩ��
        String sign = Signature.getSign(toMap());
        setSign(sign);//��ǩ���������õ�Sign���������
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

    public String getSub_mch_id() {
        return sub_mch_id;
    }

    public void setSub_mch_id(String sub_mch_id) {
        this.sub_mch_id = sub_mch_id;
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

    public String getInterface_url() {
        return interface_url;
    }

    public void setInterface_url(String interface_url) {
        this.interface_url = interface_url;
    }

    public int getExecute_time_cost() {
        return execute_time_cost;
    }

    public void setExecute_time_cost(int execute_time) {
        this.execute_time_cost = execute_time;
    }

    public String getReturn_code() {
        return return_code;
    }

    public void setReturn_code(String return_code) {
        this.return_code = return_code;
    }

    public String getReturn_msg() {
        return return_msg;
    }

    public void setReturn_msg(String return_msg) {
        this.return_msg = return_msg;
    }

    public String getResult_code() {
        return result_code;
    }

    public void setResult_code(String result_code) {
        this.result_code = result_code;
    }

    public String getErr_code() {
        return err_code;
    }

    public void setErr_code(String err_code) {
        this.err_code = err_code;
    }

    public String getErr_code_des() {
        return err_code_des;
    }

    public void setErr_code_des(String err_code_des) {
        this.err_code_des = err_code_des;
    }

    public String getOut_trade_no() {
        return out_trade_no;
    }

    public void setOut_trade_no(String out_trade_no) {
        this.out_trade_no = out_trade_no;
    }

    public String getUser_ip() {
        return user_ip;
    }

    public void setUser_ip(String user_ip) {
        this.user_ip = user_ip;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Map<String,Object> toMap(){
        Map<String,Object> map = new HashMap<String, Object>();
        Field[] fields = this.getClass().getDeclaredFields();
        for (Field field : fields) {
            Object obj;
            try {
                obj = field.get(this);
                if(obj!=null){
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
