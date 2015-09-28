package com.top.core.controller;

import com.top.core.AbstractSpringBean;
import com.top.core.service.*;

import javax.annotation.Resource;

public abstract class AbstractController extends AbstractSpringBean {

	@Resource
	ObjectMapper objectMapper;

	@Resource
	protected UserService userService;

	@Resource
	protected CategoryService categoryService;

	@Resource
	protected OrderService orderService;

	@Resource
	protected TradeRecordService tradeRecordService;

	@Resource
	protected ProjectService projectService;

	@Resource
	protected SchoolService schoolService;

	@Resource
	protected SpecialtyService specialtyService;

	@Resource
	protected IntegralRecordService integralRecordService;

}
