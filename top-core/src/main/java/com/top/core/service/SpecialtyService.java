package com.top.core.service;

import com.google.common.base.Optional;
import com.top.core.domain.SpecialtyEntity;
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
public class SpecialtyService extends AbstractService {

    /**
     * 通过id查询 {@link SpecialtyEntity}
     *
     * @param id
     * @return
     */
    public SpecialtyEntity findById(Integer id) {
        Optional<SpecialtyEntity> optional = specialtyDao.findById(id);

        if (optional.isPresent()) {
            return optional.get();
        }
        return null;
    }

    /**
     * 通过levelId查询 {@link SpecialtyEntity}
     *
     * @param levelId
     * @return
     */
    public List<SpecialtyEntity> findByLevelId(Integer levelId) {

        return specialtyDao.beginQuery()
                .select()
                .where(TinyPredicate.equal("levelId", levelId))
                .getResultList();
    }

    public List<SpecialtyEntity> findAll() {
        return specialtyDao.findAll();
    }
}
