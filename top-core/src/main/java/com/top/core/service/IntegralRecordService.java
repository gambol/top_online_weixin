package com.top.core.service;

import com.google.common.base.Optional;
import com.top.core.domain.IntegralRecordEntity;
import com.top.core.domain.SchoolEntity;
import com.top.core.domain.UserInfoEntity;
import com.top.core.service.impl.AbstractService;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.triiskelion.tinyspring.dao.TinyPredicate;
import org.triiskelion.tinyspring.viewmodel.Page;

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
public class IntegralRecordService extends AbstractService {

    /**
     * 通过id查询 page{@link IntegralRecordEntity}
     *
     * @param userId
     * @return
     */
    public Page<IntegralRecordEntity> findByUserId(Integer userId, Integer page, Integer max) {
        return integralRecordDao.beginQuery()
                .select()
                .where(TinyPredicate.equal("userId", userId))
                .page(page, max)
                .getPagedResult();
    }

    /**
     * 添加积分变动记录
     *
     * @param userId
     * @param tradingCapacity
     * @param description
     * @param outTradeNo
     */
    @Transactional
    public void add(@NotNull Integer userId, @NotNull Integer tradingCapacity,
                    String description, String outTradeNo) {
        Optional<UserInfoEntity> optional = userDao.findById(userId);
        if (optional.isPresent()) {
            UserInfoEntity user = optional.get();
            IntegralRecordEntity entity = new IntegralRecordEntity();
            entity.setUserId(user.getId());
            entity.setTradingCapacity(tradingCapacity);
            entity.setIntegralBefore(user.getAvailableCredits());
            entity.setIntegralBehind(user.getAvailableCredits() + tradingCapacity);
            entity.setDescription(description);
            entity.setOutTradeNo(outTradeNo);
            integralRecordDao.persist(entity);
        }


    }

}
