package com.top.web.controller;

import com.top.core.controller.AbstractController;
import com.top.core.domain.CategoryEntity;
import com.top.core.utils.ResultValues;
import com.top.core.viewmodel.ProjectMinimal;
import com.top.core.viewmodel.ResultModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Tian MA
 */
@Controller
@RequestMapping("api/project")
public class ProjectController extends AbstractController {

	/**
	 * 根据项目id查找
	 *
	 * @param projectId
	 * 		项目id
	 */
	@RequestMapping("get")
	@ResponseBody
	public ResultModel findById(@RequestParam int projectId) {

		return ResultModel.ofOptional(projectService.findById(projectId));
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
	@RequestMapping("find")
	@ResponseBody
	public ResultModel find(@RequestParam int levelId,
	                        @RequestParam int majorId,
	                        @RequestParam int schoolId) {

		return ResultModel.ofOptional(projectService.find(levelId, majorId, schoolId));
	}

	@RequestMapping("list")
	@ResponseBody
	public List<ProjectMinimal> list(@RequestParam int categoryId) {

		common.utils.Objects.require(categoryId >= 3, "categoryId must be greater than 3");
		return projectService.list(categoryId)
		                     .stream()
		                     .map(x -> new ProjectMinimal(x.getId(), x.getName()))
		                     .collect(Collectors.toList());
	}

	/**
	 * 根据parentId 获取下一级list
	 *
	 * @param parentId
	 *
	 * @return
	 */
	@RequestMapping("getList")
	@ResponseBody
	@Deprecated
	public ResultModel getList(@RequestParam Integer parentId) {

		List<CategoryEntity> list = categoryService.findByParentId(parentId);
		ResultModel resultModel = new ResultModel();
		if(list != null && !list.isEmpty()) {
			resultModel.setData(list);
			resultModel.setMsg(ResultValues.SUCCESS);
			return resultModel;
		} else {
			resultModel.setCode(ResultModel.CODE_FAILURE);
			resultModel.setMsg(ResultValues.FAILURE);
			return resultModel;
		}
	}

}
