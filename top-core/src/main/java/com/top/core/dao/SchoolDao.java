package com.top.core.dao;

import com.top.core.domain.SchoolEntity;
import org.springframework.stereotype.Repository;
import org.triiskelion.tinyspring.dao.AbstractDao;

/**
 * Created with IntelliJ IDEA.
 * User: Wang Lei
 * Date: 2015/6/12
 * Time: 11:11
 * <p>
 * TODO
 */
@Repository
public class SchoolDao extends AbstractDao<SchoolEntity> {
    @Override
    protected Class<SchoolEntity> getEntityClass() {
        return SchoolEntity.class;
    }
}
