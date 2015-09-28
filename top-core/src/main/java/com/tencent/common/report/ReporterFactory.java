package com.tencent.common.report;

import com.tencent.common.report.protocol.ReportReqData;

/**
 * User: rizenguo
 * Date: 2014/12/3
 * Time: 17:44
 */
public class ReporterFactory {

    /**
     * ����ͳ���ϱ�API
     * @param reportReqData ������ݶ������������APIҪ���ύ�ĸ��������ֶ�
     * @return ����һ��Reporter
     */
    public static Reporter getReporter(ReportReqData reportReqData){
        return new Reporter(reportReqData);
    }

}
