package com.top.core.service;

import com.google.common.base.Optional;
import com.top.core.dao.ProjectDao;
import com.top.core.domain.ProjectEntity;
import com.top.core.service.impl.AbstractService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 报名项目
 *
 * @author Tian MA
 */
@Service
public class ProjectService extends AbstractService {

	@Resource
	protected ProjectDao projectDao;

	/**
	 * 根据项目id查找
	 *
	 * @param projectId
	 * 		项目id
	 */
	public Optional<ProjectEntity> findById(int projectId) {

		return projectDao.findById(projectId);
	}

	/**
	 * 根据选择器查找专业
	 *
	 * @param levelId
	 * 		层次id
	 * @param majorId
	 * 		专业id
	 * @param schoolId
	 * 		学校id
	 */
	public Optional<ProjectEntity> find(int levelId, int majorId, int schoolId) {

		return projectDao.find(levelId, majorId, schoolId);
	}

	public List<ProjectEntity> list(int categoryId) {

		return projectDao.findByCategoryId(categoryId);
	}
}
