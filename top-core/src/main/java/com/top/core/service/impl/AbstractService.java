package com.top.core.service.impl;

import com.top.core.dao.*;
import com.top.core.AbstractSpringBean;
import com.top.core.service.IntegralRecordService;
import com.top.core.service.ObjectMapper;

import javax.annotation.Resource;

public abstract class AbstractService extends AbstractSpringBean {

    @Resource
    protected ObjectMapper objectMapper;

    @Resource
    protected UserDao userDao;

    @Resource
    protected OrderDao orderDao;

    @Resource
    protected CategoryDao categoryDao;

    @Resource
    protected TradeRecordDAO tradeRecordDAO;

    @Resource
    protected SpecialtyDao specialtyDao;

    @Resource
    protected SchoolDao schoolDao;

    @Resource
    protected LevelDao levelDao;

    @Resource
    protected ProjectDao projectDao;

    @Resource
    protected IntegralRecordDao integralRecordDao;

    @Resource
    protected IntegralRecordService integralRecordService;


}
