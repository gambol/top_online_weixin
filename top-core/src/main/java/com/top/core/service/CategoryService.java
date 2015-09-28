package com.top.core.service;

import com.google.common.base.Optional;
import com.top.core.domain.CategoryEntity;
import com.top.core.service.impl.AbstractService;
import org.springframework.stereotype.Service;
import org.triiskelion.tinyspring.dao.TinyPredicate;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Wang Lei
 * Date: 2015/6/11
 * Time: 10:04
 * <p>
 * TODO
 */
@Service
@Deprecated
public class CategoryService extends AbstractService {

    /**
     * 通过id查询 {@link CategoryEntity}
     *
     * @param id
     * @return
     */
    public CategoryEntity findById(Integer id) {
        Optional<CategoryEntity> optional = categoryDao.findById(id);
        if (optional.isPresent()) {
            return optional.get();
        }
        return null;
    }

    /**
     * 通过prentId查询 {@link CategoryEntity}
     *
     * @param parentId
     * @return
     */
    public List<CategoryEntity> findByParentId(Integer parentId) {

        return categoryDao.beginQuery()
                .select()
                .where(TinyPredicate.equal("parentId", parentId))
                .getResultList();
    }
}
