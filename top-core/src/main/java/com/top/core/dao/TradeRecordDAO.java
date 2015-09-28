package com.top.core.dao;

import com.top.core.domain.TradeRecordEntity;
import org.springframework.stereotype.Repository;
import org.triiskelion.tinyspring.dao.AbstractDao;

/**
 * Created by Wang Lei.
 * Date on 2015/2/2
 * Time 17:25
 * TODO
 */
@Repository
public class TradeRecordDAO extends AbstractDao<TradeRecordEntity> {
    @Override
    protected Class<TradeRecordEntity> getEntityClass() {
        return TradeRecordEntity.class;
    }
}
