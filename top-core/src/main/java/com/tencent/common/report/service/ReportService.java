package com.tencent.common.report.service;

import com.tencent.common.Configure;
import com.tencent.common.HttpsRequest;
import com.tencent.common.Util;
import com.tencent.common.report.protocol.ReportReqData;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * User: rizenguo
 * Date: 2014/11/12
 * Time: 17:07
 */
public class ReportService {

    private ReportReqData reqData ;

    /**
     * ����ͳ���ϱ�API
     * @param reportReqData ������ݶ������������APIҪ���ύ�ĸ��������ֶ�
     */
    public ReportService(ReportReqData reportReqData){
        reqData = reportReqData;
    }

    public String request() throws UnrecoverableKeyException, KeyManagementException, NoSuchAlgorithmException, KeyStoreException, IOException {
        String responseString = new HttpsRequest().sendPost(Configure.REPORT_API, reqData);

        Util.log("   report���ص����ݣ�" + responseString);

        return responseString;
    }

    /**
     * ����ͳ���ϱ�API
     * @param reportReqData ������ݶ������������APIҪ���ύ�ĸ��������ֶ�
     * @return API���ص�����
     * @throws Exception
     */
    public static String request(ReportReqData reportReqData) throws Exception {

        //--------------------------------------------------------------------
        //����HTTPS��Post����API��ַ
        //--------------------------------------------------------------------
        String responseString = new HttpsRequest().sendPost(Configure.REPORT_API, reportReqData);

        Util.log("report���ص����ݣ�" + responseString);

        return responseString;
    }

    /**
     * ��ȡtime:ͳ�Ʒ���ʱ�䣬��ʽΪyyyyMMddHHmmss����2009��12 ��25 ��9 ��10 ��10 ���ʾΪ20091225091010��ʱ��ΪGMT+8 beijing��
     * @return ��������ʱ��
     */
    private static String getTime(){
        //��������ʱ����Ȼ���ǵ�ǰ������ϵͳʱ�俩
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        return simpleDateFormat.format(new Date());
    }

}
