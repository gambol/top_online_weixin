package com.top.core.dao;

import com.top.core.domain.IntegralRecordEntity;
import org.springframework.stereotype.Repository;
import org.triiskelion.tinyspring.dao.AbstractDao;

/**
 * Created with IntelliJ IDEA.
 * User: Wang Lei
 * Date: 2015/6/15
 * Time: 13:42
 * <p>
 * TODO
 */
@Repository
public class IntegralRecordDao extends AbstractDao<IntegralRecordEntity>{
    @Override
    protected Class<IntegralRecordEntity> getEntityClass() {
        return IntegralRecordEntity.class;
    }
}
