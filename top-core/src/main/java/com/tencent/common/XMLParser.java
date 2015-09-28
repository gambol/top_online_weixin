package com.tencent.common;

import com.tencent.protocol.refund_query_protocol.RefundOrderData;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.core.util.QuickWriter;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.xml.PrettyPrintWriter;
import com.thoughtworks.xstream.io.xml.XppDriver;
import org.dom4j.io.SAXReader;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.servlet.http.HttpServletRequest;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * User: rizenguo
 * Date: 2014/11/1
 * Time: 14:06
 */
public class XMLParser {

    /**
     * 从RefunQueryResponseString里面解析出退款订单数据
     *
     * @param refundQueryResponseString RefundQuery API返回的数据
     * @return 因为订单数据有可能是多个，所以返回一个列表
     */
    public static List<RefundOrderData> getRefundOrderList(String refundQueryResponseString) throws IOException, SAXException, ParserConfigurationException {
        List list = new ArrayList();

        Map<String, Object> map = XMLParser.getMapFromXML(refundQueryResponseString);

        int count = Integer.parseInt((String) map.get("refund_count"));
        Util.log("count:" + count);

        if (count < 1) {
            return list;
        }

        RefundOrderData refundOrderData;

        for (int i = 0; i < count; i++) {
            refundOrderData = new RefundOrderData();

            refundOrderData.setOutRefundNo(Util.getStringFromMap(map, "out_refund_no_" + i, ""));
            refundOrderData.setRefundID(Util.getStringFromMap(map, "refund_id_" + i, ""));
            refundOrderData.setRefundChannel(Util.getStringFromMap(map, "refund_channel_" + i, ""));
            refundOrderData.setRefundFee(Util.getIntFromMap(map, "refund_fee_" + i));
            refundOrderData.setCouponRefundFee(Util.getIntFromMap(map, "coupon_refund_fee_" + i));
            refundOrderData.setRefundStatus(Util.getStringFromMap(map, "refund_status_" + i, ""));
            list.add(refundOrderData);
        }

        return list;
    }

    public static Map<String, Object> getMapFromXML(String xmlString) throws ParserConfigurationException, IOException, SAXException {

        //这里用Dom的方式解析回包的最主要目的是防止API新增回包字段
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        InputStream is = Util.getStringStream(xmlString);
        Document document = builder.parse(is);

        //获取到document里面的全部结点
        NodeList allNodes = document.getFirstChild().getChildNodes();
        Node node;
        Map<String, Object> map = new HashMap<String, Object>();
        int i = 0;
        while (i < allNodes.getLength()) {
            node = allNodes.item(i);
            if (node instanceof Element) {
                map.put(node.getNodeName(), node.getTextContent());
            }
            i++;
        }
        return map;

    }


    /**
     * 解析微信发来的请求（XML）
     *
     * @param request
     * @return
     * @throws Exception
     */
    @SuppressWarnings("unchecked")
    public static Map<String, String> parseXml(HttpServletRequest request) throws Exception {
        // 将解析结果存储在HashMap中
        Map<String, String> map = new HashMap<String, String>();

        // 从request中取得输入流
        InputStream inputStream = request.getInputStream();
        // 读取输入流
        SAXReader reader = new SAXReader();
        org.dom4j.Document document = reader.read(inputStream);
        // 得到xml根元素
        org.dom4j.Element root = document.getRootElement();
        // 得到根元素的所有子节点
        List<org.dom4j.Element> elementList = root.elements();

        // 遍历所有子节点
        for (org.dom4j.Element e : elementList)
            if (e.elements().size() == 0) {
                map.put(e.getName(), e.getText());
            } else {
                List<org.dom4j.Element> childElementList = e.elements();
                for (org.dom4j.Element child : childElementList)
                    map.put(child.getName(), child.getText());
            }
        // 释放资源
        inputStream.close();
        inputStream = null;

        return map;
    }

    /**
     * 扩展xstream，使其支持CDATA块
     *
     * @date 2013-05-19
     */
    private static XStream xstream = new XStream(new XppDriver() {
        public HierarchicalStreamWriter createWriter(Writer out) {
            return new PrettyPrintWriter(out) {
                // 对所有xml节点的转换都增加CDATA标记
                boolean cdata = true;

                @SuppressWarnings("unchecked")
                public void startNode(String name, Class clazz) {
                    super.startNode(name, clazz);
                    if (name.equals("CreateTime")) {
                        cdata = false;
                    }
                }

                protected void writeText(QuickWriter writer, String text) {
                    if (cdata) {
                        writer.write("<![CDATA[");
                        writer.write(text);
                        writer.write("]]>");
                    } else {
                        writer.write(text);
                    }
                }
            };
        }
    });


}
