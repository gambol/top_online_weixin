package com.top.core.service;

import com.top.core.domain.TradeRecordEntity;
import com.top.core.service.impl.AbstractService;
import com.top.core.utils.ResultValues;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.triiskelion.tinyutils.datetime.JodaDateTimeFactory;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.UUID;

/**
 * Created by Wang Lei.
 * Date on 2015/2/3
 * Time 15:48
 * TODO
 */
@Service
public class TradeRecordService extends AbstractService {

    /**
     * 支付通知记录*
     *
     * @param tradeNumber 支付宝交易号
     * @param outTradeNo  订单号
     * @param notifyTime  通知时间
     * @param totalFee    交易 金额
     * @param result      交易状态
     * @param buyerId     卖家支付宝id
     * @param subject     交易账目名称
     * @return
     */
    @Transactional
    public String add(String tradeNumber, String outTradeNo, Timestamp notifyTime, String totalFee,
                      String result, String buyerId, String subject) {
        try {
            TradeRecordEntity entity = new TradeRecordEntity();
            entity.setId(UUID.randomUUID().toString());
            entity.setTradeNumber(tradeNumber);
            entity.setOutTradeNo(outTradeNo);
            entity.setNotifyTime(notifyTime);
            entity.setTotalFee(new BigDecimal(totalFee));
            entity.setResult(result);
            entity.setBuyerId(buyerId);
            entity.setSubject(subject);
            entity.setCreateTime(JodaDateTimeFactory.Timestamp.now());
            tradeRecordDAO.persist(entity);
            return ResultValues.SUCCESS;
        } catch (Exception e) {
            log.error("save alipay data fail,like had deal:" + e.getMessage());
            return ResultValues.FAILURE;
        }

    }
}
