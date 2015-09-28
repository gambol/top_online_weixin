package com.top.core.service;

import com.top.core.domain.CategoryEntity;
import com.top.core.domain.OrderEntity;
import com.top.core.domain.UserInfoEntity;
import com.top.core.utils.DateUtils;
import com.top.core.viewmodel.CategoryViewModel;
import com.top.core.viewmodel.OrderViewModel;
import com.top.core.viewmodel.UserViewModel;
import com.top.core.service.impl.AbstractService;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * Object mapping service
 *
 * @author Sebastian MA
 */
@Service
public class ObjectMapper extends AbstractService implements ApplicationContextAware {

    private MapperFacade mapper;

    /**
     * for i18n
     */
    private ApplicationContext appContext;


    @Override
    public void setApplicationContext(ApplicationContext applicationContext)
            throws BeansException {

        this.appContext = applicationContext;
    }

    @PostConstruct
    public void init() {

        DefaultMapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();

        // map user
        //        mapperFactory.classMap(AdEntity.class, AdViewModel.class)
        //                     .byDefault()
        //                     .register();

        mapper = mapperFactory.getMapperFacade();
    }

    public MapperFacade mapper() {

        return mapper;
    }

    /**
     * 用户view
     *
     * @return
     */
    public UserViewModel map(UserInfoEntity entity) {
        UserViewModel model = mapper.map(entity, UserViewModel.class);

        model.setRegisterDate(entity.getRegisterDate().toString(DateUtils.DEFAULT_FORMAT1));
        return model;

    }


    public OrderViewModel map(OrderEntity entity) {
        OrderViewModel model = mapper.map(entity, OrderViewModel.class);
        model.setCreateTime(entity.getCreateTime().toString(DateUtils.DEFAULT_FORMAT1));

        if (entity.getNotifyTime() != null) {
            model.setNotifyTime(entity.getNotifyTime().toString(DateUtils.DEFAULT_FORMAT1));
        }

        return model;
    }

    public CategoryViewModel map(CategoryEntity entity) {
        CategoryViewModel model = mapper.map(entity, CategoryViewModel.class);

        if (entity.getStartDate() != null) {
            model.setStartDate(entity.getStartDate().toString(DateUtils.DEFAULT_FORMAT1));
        }
        if (entity.getEndDate() != null) {
            model.setEndDate(entity.getEndDate().toString(DateUtils.DEFAULT_FORMAT1));
        }
        if (entity.getCreateTime() != null) {
            model.setCreateTime(entity.getCreateTime().toString(DateUtils.DEFAULT_FORMAT1));
        }
        if (entity.getUpdateTime() != null) {
            model.setUpdateTime(entity.getUpdateTime().toString(DateUtils.DEFAULT_FORMAT1));
        }


        return model;
    }
}
