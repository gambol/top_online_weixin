package com.top.core.dao;

import com.google.common.base.Optional;
import com.top.core.domain.ProjectEntity;
import org.springframework.stereotype.Repository;
import org.triiskelion.tinyspring.dao.AbstractDao;

import java.util.List;

import static org.triiskelion.tinyspring.dao.TinyPredicate.equal;

/**
 * @author Tian MA
 */
@Repository
public class ProjectDao extends AbstractDao<ProjectEntity> {

	@Override
	protected Class<ProjectEntity> getEntityClass() {

		return ProjectEntity.class;
	}

	/**
	 * 根据参数查找学历提升项目
	 *
	 * @param levelId
	 * @param majorId
	 * @param schoolId
	 *
	 * @return
	 */
	public Optional<ProjectEntity> find(int levelId, int majorId, int schoolId) {

		return beginQuery().select()
		                   .where(equal("type", 1))
		                   .and(equal("levelId", levelId))
		                   .and(equal("majorId", majorId))
		                   .and(equal("schoolId", schoolId))
		                   .and(equal("deleted", ProjectEntity.DEL_NORMAL))
		                   .getFirstResult();
	}

	public List<ProjectEntity> findByCategoryId(int categoryId) {

		return beginQuery().select()
		                   .where(equal("type", categoryId))
		                   .and(equal("deleted", ProjectEntity.DEL_NORMAL))
		                   .getResultList();
	}
}
