package com.top.core.dao;

import com.top.core.domain.OrderEntity;
import org.springframework.stereotype.Repository;
import org.triiskelion.tinyspring.dao.AbstractDao;

/**
 * Created with IntelliJ IDEA.
 * User: Wang Lei
 * Date: 2015/6/11
 * Time: 9:41
 * <p>
 * TODO
 */
@Repository
public class OrderDao extends AbstractDao<OrderEntity> {
    @Override
    protected Class<OrderEntity> getEntityClass() {
        return OrderEntity.class;
    }
}
