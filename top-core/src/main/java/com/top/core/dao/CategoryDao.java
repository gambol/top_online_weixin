package com.top.core.dao;

import com.top.core.domain.CategoryEntity;
import org.springframework.stereotype.Repository;
import org.triiskelion.tinyspring.dao.AbstractDao;

/**
 * Created with IntelliJ IDEA.
 * User: Wang Lei
 * Date: 2015/6/11
 * Time: 9:42
 * <p>
 * TODO
 */
@Repository
public class CategoryDao extends AbstractDao<CategoryEntity> {
    @Override
    protected Class<CategoryEntity> getEntityClass() {
        return CategoryEntity.class;
    }
}
