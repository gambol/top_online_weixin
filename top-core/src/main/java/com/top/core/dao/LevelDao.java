package com.top.core.dao;

import com.top.core.domain.LevelEntity;
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
public class LevelDao extends AbstractDao<LevelEntity> {
    @Override
    protected Class<LevelEntity> getEntityClass() {
        return LevelEntity.class;
    }
}
