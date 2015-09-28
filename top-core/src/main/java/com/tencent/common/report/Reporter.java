package com.tencent.common.report;

import com.tencent.common.report.protocol.ReportReqData;
import com.tencent.common.report.service.ReportService;

/**
 * User: rizenguo
 * Date: 2014/12/3
 * Time: 11:42
 */
public class Reporter {

    private ReportRunable r;
    private Thread t;
    private ReportService rs;

    /**
     * ����ͳ���ϱ�API
     * @param reportReqData ������ݶ������������APIҪ���ύ�ĸ��������ֶ�
     */
    public Reporter(ReportReqData reportReqData){
        rs = new ReportService(reportReqData);
    }

    public void run(){
        r = new ReportRunable(rs);
        t = new Thread(r);
        t.setDaemon(true);  //��̨�߳�
        t.start();
    }
}
