package com.top.core.service;

import com.alibaba.fastjson.JSON;
import com.alipay.config.AlipayConfig;
import com.alipay.util.UtilDate;
import com.google.common.base.Optional;
import com.top.core.domain.OrderEntity;
import com.top.core.domain.ProjectEntity;
import com.top.core.domain.UserInfoEntity;
import com.top.core.service.impl.AbstractService;
import com.top.core.utils.ResultValues;
import com.top.core.viewmodel.OrderViewModel;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;
import org.joda.time.DateTime;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.triiskelion.tinyspring.dao.TinyPredicate;
import org.triiskelion.tinyspring.viewmodel.Page;

import java.math.BigDecimal;

/**
 * Created with IntelliJ IDEA.
 * User: Wang Lei
 * Date: 2015/6/11
 * Time: 9:51
 * <p>
 * TODO
 */
@Service
public class OrderService extends AbstractService {

    /**
     * 创建订单
     *
     * @param userId
     * @param projectId
     * @param payFull
     * @param integral
     * @param actual_fee
     * @return
     */
    @Transactional
    public String create(Integer userId, Integer projectId, boolean payFull,
                         double integral, double actual_fee) {

        try {
            Optional<UserInfoEntity> up = userDao.findById(userId);
            if (!up.isPresent()) {
                return ResultValues.USER_NOT_FOUND;
            }
            UserInfoEntity user = up.get();

            Optional<ProjectEntity> optional = projectDao.findById(projectId);
            if (!optional.isPresent()) {
                return ResultValues.CATEGORY_NOT_FOUND;
            }

            ProjectEntity projectEntity = optional.get();

            OrderEntity entity = new OrderEntity();
            entity.setOrderNumber(UtilDate.getOrderNum());
            entity.setUserId(up.get().getId());
            entity.setProjectId(projectEntity.getId());
            entity.setDescription(projectEntity.getName());
            entity.setCategory(JSON.toJSONString(projectEntity));
            entity.setCreateTime(DateTime.now());
            entity.setReferrer(up.get().getReferrerMobile());
            entity.setStatus(OrderEntity.STATUS_CREATE);
            entity.setPay_full(payFull ? 1 : 0);
            entity.setPrice(new BigDecimal(actual_fee));
            entity.setTotalPrice(projectEntity.getTotalFee());
            orderDao.persist(entity);

            //todo 扣除积分
            if (integral > 0) {
                entity.setIntegral(new BigDecimal(integral));
                user.setAvailableCredits(user.getAvailableCredits() - ((int) integral * 10));
                integralRecordService.add(user.getId(), -((int) integral * 10), "消费积分", entity.getOrderNumber());
            }
            if (StringUtils.isNotBlank(user.getReferrerMobile())) {
                Optional<UserInfoEntity> referrerUp = userDao.findByMobile(user.getReferrerMobile());
                if (referrerUp.isPresent() && StringUtils.isNoneBlank(user.getReferrerMobile())) {
                    UserInfoEntity referrer = referrerUp.get();
                    referrer.setAvailableCredits(referrer.getAvailableCredits() + ((int) integral * 10));
                    integralRecordService.add(referrer.getId(), UserService.RegisterPoints, "被推荐人" + user.getMobile() + "消费，赠送积分", entity.getOrderNumber());
                }
            }

            return entity.getOrderNumber();
        } catch (Exception e) {
            e.printStackTrace();
            log.error("create order error,msg:" + e.getMessage());
            return ResultValues.FAILURE;
        }
    }


    /**
     * 查询订单根据用户id和订单号
     *
     * @param userId
     * @param orderNo
     * @return
     */
    public OrderViewModel getOrderInfo(Integer userId, @NotNull String orderNo) {

        if (StringUtils.isBlank(orderNo)) {
            throw new IllegalArgumentException(ResultValues.PARAM_INVALID);
        }
        Optional<UserInfoEntity> up = userDao.findById(userId);
        if (!up.isPresent()) {
            throw new IllegalArgumentException(ResultValues.USER_NOT_FOUND);
        }
        Optional<OrderEntity> optional = orderDao.beginQuery()
                .select()
                .where(TinyPredicate.equal("orderNumber",
                        orderNo))
                .and(TinyPredicate.equal("userId", userId))
                .getFirstResult();

        if (!optional.isPresent()) {
            throw new IllegalArgumentException(ResultValues.ORDER_NOT_FOUND);
        }

        return objectMapper.map(optional.get());
    }

    /**
     * 根据用户id查询订单列表
     *
     * @param userId
     * @param page
     * @param max
     * @return
     */
    public Page<OrderViewModel> getOrderList(Integer userId, Integer page, Integer max) {

        Optional<UserInfoEntity> up = userDao.findById(userId);
        if (!up.isPresent()) {
            throw new IllegalArgumentException(ResultValues.USER_NOT_FOUND);
        }
        Page<OrderEntity> result = orderDao.beginQuery()
                .select()
                .and(TinyPredicate.equal("userId", userId))
                .page(page, max)
                .getPagedResult();
        return result.map(OrderViewModel.class, objectMapper::map);
    }

    /**
     * 缴费通知确认
     *
     * @param out_trade_no
     * @param price
     * @return
     */
    @Transactional
    public boolean onConfirmPayment(String out_trade_no, BigDecimal price) {

        Optional<OrderEntity> opt = orderDao.findById(out_trade_no);

        if (!opt.isPresent()) {
            return false;
        }

        OrderEntity entity = opt.get();
        if (entity.getStatus() == OrderEntity.STATUS_CREATE && price.compareTo(entity.getPrice())
                == 0) {
            entity.setNotifyTime(DateTime.now());
            entity.setStatus(OrderEntity.STATUS_PAY_OK);
        } else {
            log.error("onConfirmPayment failed. Order is not on right status. no={},amount={}",
                    out_trade_no, price);
            return false;

        }
        return true;
    }

}
