package com.top.core.service;


import com.google.common.base.Optional;
import com.top.core.domain.UserInfoEntity;
import com.top.core.service.impl.AbstractService;
import com.top.core.utils.MD5Utils;
import com.top.core.utils.ResultValues;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.triiskelion.tinyutils.Validator;

@Service
public class UserService extends AbstractService {

    public static final int RegisterPoints = 100;
    /**
     * 检查手机号是否存在
     *
     * @param mobile
     * @return 存在 true 不存在 false
     */
    public boolean checkMobile(String mobile) {
        Optional<UserInfoEntity> optional = userDao.findByMobile(mobile);
        if (optional.isPresent()) {
            return true;
        }
        return false;
    }

    @Transactional
    public String createUserByMobile(String mobile, String password) {
        try {
            if (checkMobile(mobile)) {
                return ResultValues.MOBILE_ALREADY_EXISTS;
            }
            if (Validator.isStrictMobileNumber(mobile) && StringUtils.isNotBlank(password)) {
                UserInfoEntity entity = new UserInfoEntity();
                entity.setMobile(mobile);
                entity.setPassword(MD5Utils.encrypt(password, 16));
                entity.setRegisterDate(DateTime.now());
                userDao.persist(entity);
                return ResultValues.SUCCESS;
            }
            return ResultValues.PARAM_INVALID;
        } catch (Exception e) {
            return ResultValues.FAILURE;
        }
    }

    /**
     * 创建用户，并且为推荐人添加积分
     * @param mobile
     * @param password
     * @param refereeMobile
     * @return
     */
    @Transactional
    public String createUserByMobile(String mobile, String password, String refereeMobile) {
        try {
            UserInfoEntity referee = null;
            if (checkMobile(mobile)) {
                return ResultValues.MOBILE_ALREADY_EXISTS;
            }
            if (refereeMobile != null && refereeMobile.length() > 0) {
                if (!checkMobile(refereeMobile)) {
                    return ResultValues.REFEREE_NOT_FOUND;
                } else {
                    referee = userDao.findByMobile(refereeMobile).get();
                }
            }
            if (Validator.isStrictMobileNumber(mobile) && StringUtils.isNotBlank(password)) {
                UserInfoEntity entity = new UserInfoEntity();
                entity.setMobile(mobile);
                entity.setPassword(MD5Utils.encrypt(password, 16));
                entity.setRegisterDate(DateTime.now());
                entity.setAvailableCredits(RegisterPoints);
                entity.setReferrerMobile(refereeMobile);
                userDao.persist(entity);
                integralRecordService.add(entity.getId(), RegisterPoints, "注册赠送积分", null);
                if (referee != null) {
                    referee.setAvailableCredits(RegisterPoints + referee.getAvailableCredits());
                    integralRecordService.add(referee.getId(),RegisterPoints,"推荐"+mobile+"注册赠送积分",null);

                    userDao.merge(referee);
                }
                return ResultValues.SUCCESS;
            }
            return ResultValues.PARAM_INVALID;
        } catch (Exception e) {
            return ResultValues.FAILURE;
        }
    }

    public Optional<UserInfoEntity> getUserInfoById(Integer id) {
        return userDao.findById(id);
//        Optional<UserInfoEntity> optional = userDao.findById(id);
//        if (optional.isPresent()) {
//            return optional.get();
//        }
//        return null;
    }

    /**
     * 用户修改密码或者忘记密码
     *
     * @param mobile
     * @param newPassword
     * @return
     */
    @Transactional
    public String changePassword(String mobile, String newPassword) {
        Optional<UserInfoEntity> optional = userDao.findByMobile(mobile);
        if (optional.isPresent()) {
            UserInfoEntity user = optional.get();
            user.setPassword(MD5Utils.encrypt(newPassword, 16));
            return ResultValues.SUCCESS;
        } else {
            return ResultValues.USER_NOT_FOUND;
        }
    }

    /**
     * 绑定用户微信openid
     *
     * @param id
     * @param openId
     */
    @Transactional
    public void bindingWeChat(Integer id, String openId) {
        Optional<UserInfoEntity> optional = getUserInfoById(id);
        if (optional.isPresent()) {
            optional.get().setWeChat(openId);
            userDao.merge(optional.get());
        }
    }

    /**
     * 用户修改真实姓名
     * @param id
     * @param name
     */
    @Transactional
    public void modifyName(Integer id, String name) {
        Optional<UserInfoEntity> optional = getUserInfoById(id);
        if (optional.isPresent()) {
            optional.get().setName(name);
        }
    }

    @Transactional
    public void modifyIdCardNum(Integer id, String idCardNum) {
        Optional<UserInfoEntity> optional = getUserInfoById(id);
        if (optional.isPresent()) {
            optional.get().setIdCard(idCardNum);
        }
    }
}
