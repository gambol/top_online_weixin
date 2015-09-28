package com.top.core.service;

import com.google.common.base.Optional;
import com.top.core.domain.SchoolEntity;
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
public class SchoolService extends AbstractService {

    /**
     * 通过id查询 {@link com.top.core.domain.SchoolEntity}
     *
     * @param id
     * @return
     */
    public SchoolEntity findById(Integer id) {
        Optional<SchoolEntity> optional = schoolDao.findById(id);
        if (optional.isPresent()) {
            return optional.get();
        }
        return null;
    }

    public List<SchoolEntity> findAll() {
        return schoolDao.findAll();
    }

    /**
     * 查询学校根据层次，专业
     *
     * @param levelId
     * @param specialtyId
     * @return
     */
    public List<SchoolEntity> find(Integer levelId, Integer specialtyId) {
        String jpql = "SELECT s from SchoolEntity s,ProjectEntity p WHERE s.id=p.schoolId AND " +
                "p.levelId =" + levelId + " AND p.majorId = " + specialtyId + " GROUP BY s.id";

        return projectDao.beginQuery().query(jpql).getUntypedResultList();
    }
}
