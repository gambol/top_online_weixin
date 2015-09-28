/**
 * @author Glan.duanyj
 * @date 2014-05-12
 * @project rest_demo
 */
package com.top.core.utils;


import com.alibaba.fastjson.JSONObject;
import com.ucpaas.client.JsonReqClient;
import org.apache.commons.lang3.StringUtils;


public class SmsUtils {
    private static String accountSid = "8d41f8301363b5ea99294d600d79ab20";

    private static String authToken = "25d3464c932c585882a931170223ef88";

    private static String appId = "025aa060c3cc4f88844d59ee5eaf9dad";

    private static String templateId = "7907";

    /**
     * 发送验证码
     *
     * @param to    手机号
     * @param param 验证码
     * @return
     */
    public static String sendVerifyCode(String to, String param) {
        try {
            String result = new JsonReqClient().templateSMS(accountSid, authToken, appId, templateId, to, param);
            System.out.println("Response content is: " + result);
            JSONObject object=JSONObject.parseObject(result).getJSONObject("resp");
            if (StringUtils.equals(object.getString("respCode"), "000000")) {
                return ResultValues.SUCCESS;
            }
        } catch (Exception e) {
            // TODO: handle exception
            return ResultValues.FAILURE;
        }
        return ResultValues.FAILURE;
    }

//    public static void testFindAccount(boolean json, String accountSid, String authToken) {
//        try {
//            String result = InstantiationRestAPI(json).findAccoutInfo(accountSid, authToken);
//            System.out.println("Response content is: " + result);
//        } catch (Exception e) {
//            // TODO: handle exception
//        }
//    }
//
//    public static void testCreateClient(boolean json, String accountSid, String authToken, String appId, String clientName
//            , String chargeType, String charge, String mobile) {
//        try {
//            String result = InstantiationRestAPI(json).createClient(accountSid, authToken, appId, clientName, chargeType, charge, mobile);
//            System.out.println("Response content is: " + result);
//        } catch (Exception e) {
//            // TODO: handle exception
//        }
//    }
//
//    public static void testfindClients(boolean json, String accountSid, String authToken, String appId, String start
//            , String limit) {
//        try {
//            String result = InstantiationRestAPI(json).findClients(accountSid, authToken, appId, start, limit);
//            System.out.println("Response content is: " + result);
//        } catch (Exception e) {
//            // TODO: handle exception
//        }
//    }
//
//    public static void testfindClientByNbr(boolean json, String accountSid, String authToken, String clientNumber, String appId) {
//        try {
//            String result = InstantiationRestAPI(json).findClientByNbr(accountSid, authToken, clientNumber, appId);
//            System.out.println("Response content is: " + result);
//        } catch (Exception e) {
//            // TODO: handle exception
//        }
//    }
//
//    public static void testCloseClient(boolean json, String accountSid, String authToken, String clientNumber, String appId) {
//        try {
//            String result = InstantiationRestAPI(json).closeClient(accountSid, authToken, clientNumber, appId);
//            System.out.println("Response content is: " + result);
//        } catch (Exception e) {
//            // TODO: handle exception
//        }
//    }
//
//    public static void testChargeClient(boolean json, String accountSid, String authToken, String clientNumber,
//                                        String chargeType, String charge, String appId) {
//        try {
//            String result = InstantiationRestAPI(json).charegeClient(accountSid, authToken, clientNumber, chargeType, charge, appId);
//            System.out.println("Response content is: " + result);
//        } catch (Exception e) {
//            // TODO: handle exception
//        }
//    }
//
//    public static void testBillList(boolean json, String accountSid, String authToken, String appId, String date) {
//        try {
//            String result = InstantiationRestAPI(json).billList(accountSid, authToken, appId, date);
//            System.out.println("Response content is: " + result);
//        } catch (Exception e) {
//            // TODO: handle exception
//        }
//    }
//
//    public static void testClientBillList(boolean json, String accountSid, String authToken, String appId, String clientNumber, String date) {
//        try {
//            String result = InstantiationRestAPI(json).clientBillList(accountSid, authToken, appId, clientNumber, date);
//            System.out.println("Response content is: " + result);
//        } catch (Exception e) {
//            // TODO: handle exception
//        }
//    }
//
//    public static void testCallback(boolean json, String accountSid, String authToken, String appId, String fromClient, String to) {
//        try {
//            String result = InstantiationRestAPI(json).callback(accountSid, authToken, appId, fromClient, to);
//            System.out.println("Response content is: " + result);
//        } catch (Exception e) {
//            // TODO: handle exception
//        }
//    }
//
//    public static void testVoiceCode(boolean json, String accountSid, String authToken, String appId, String to, String verifyCode) {
//        try {
//            String result = InstantiationRestAPI(json).voiceCode(accountSid, authToken, appId, to, verifyCode);
//            System.out.println("Response content is: " + result);
//        } catch (Exception e) {
//            // TODO: handle exception
//        }
//    }
//
//    public static void testfindClientByMobile(boolean json, String accountSid, String authToken, String mobile, String appId) {
//        try {
//            String result = InstantiationRestAPI(json).findClientByMobile(accountSid, authToken, mobile, appId);
//            System.out.println("Response content is: " + result);
//        } catch (Exception e) {
//            // TODO: handle exception
//        }
//    }


    /**
     * 测试说明 参数顺序，请参照各具体方法参数名称
     * 参数名称含义，请参考rest api 文档
     *
     * @param args
     * @return void
     * @author Glan.duanyj
     * @date 2014-06-30
     * @method main
     */
    public static void main(String[] args) {
//        sendVerifyCode("18560683520", RandomStringUtils.randomNumeric(6));
    }
}
