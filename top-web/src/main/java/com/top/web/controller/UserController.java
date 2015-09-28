package com.top.web.controller;


import com.google.common.base.Optional;
import com.top.core.controller.AbstractController;
import com.top.core.domain.UserInfoEntity;
import com.top.core.utils.ResultValues;
import com.top.core.utils.ServletUtils;
import com.top.core.utils.SmsUtils;
import com.top.core.viewmodel.ResultModel;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.triiskelion.tinyspring.security.SecurityCheck;
import org.triiskelion.tinyutils.Validator;

import javax.servlet.http.HttpSession;

/**
 * UserController
 *
 * @author WangLei
 */
@Controller
@RequestMapping("user")
public class UserController extends AbstractController {

	/**
	 * 注册发送验证码
	 *
	 * @param mobile
	 *
	 * @return
	 */
	@RequestMapping("sendVerifyCode")
	@ResponseBody
	public ResultModel sendVerifyCode(@RequestParam @NotNull String mobile) {

		ResultModel resultModel = new ResultModel();
		if(!Validator.isStrictMobileNumber(mobile)) {
			resultModel.setCode(ResultModel.CODE_FAILURE);
			resultModel.setMsg(ResultValues.MOBILE_INVALID);
		}
		String code = RandomStringUtils.randomNumeric(6);
		if(StringUtils.equals(SmsUtils.sendVerifyCode(mobile, code), ResultValues.SUCCESS)) {
			resultModel.setMsg(ResultValues.SUCCESS);
			resultModel.setData(code);
		}
		return resultModel;
	}

    /**
     * 用户注册
     *
     * @param mobile
     * @param password
     * @return
     */
    @RequestMapping("register")
    @ResponseBody
    public ResultModel register(@RequestParam @NotNull String mobile, @RequestParam @NotNull String password,
                                @RequestParam String refereeMobile) {
        ResultModel resultModel = new ResultModel();
        String res = userService.createUserByMobile(mobile, password, refereeMobile);
        if (!StringUtils.equals(res, ResultValues.SUCCESS)) {
            resultModel.setCode(ResultModel.CODE_FAILURE);
        }
        resultModel.setMsg(res);
        return resultModel;
    }

	/**
	 * 用户注册
	 *
	 * @param mobile
	 * @param password
	 *
	 * @return
	 */
	@RequestMapping("signUp")
	@ResponseBody
	public ResultModel signUp(
			@RequestParam @NotNull String mobile, @RequestParam @NotNull String password) {
		ResultModel resultModel = new ResultModel();
		String res = userService.createUserByMobile(mobile, password);
		if(!StringUtils.equals(res, ResultValues.SUCCESS)) {
			resultModel.setCode(ResultModel.CODE_FAILURE);
		}
		resultModel.setMsg(res);
		return resultModel;
	}

	/**
	 * 忘记密码发送验证码
	 *
	 * @param mobile
	 *
	 * @return
	 */
	@RequestMapping("sendVerifyCodeForForget")
	@ResponseBody
	public ResultModel sendVerifyCodeForForget(@RequestParam @NotNull String mobile) {

		ResultModel resultModel = new ResultModel();
		if(!Validator.isStrictMobileNumber(mobile)) {
			resultModel.setCode(ResultModel.CODE_FAILURE);
			resultModel.setMsg(ResultValues.MOBILE_INVALID);
		}
		if(userService.checkMobile(mobile)) {
			String code = RandomStringUtils.randomNumeric(6);
			if(StringUtils.equals(SmsUtils.sendVerifyCode(mobile, code), ResultValues.SUCCESS)) {
				resultModel.setMsg(ResultValues.SUCCESS);
				resultModel.setData(code);
			}
		} else {
			resultModel.setCode(ResultModel.CODE_FAILURE);
			resultModel.setMsg(ResultValues.USER_NOT_FOUND);
		}
		return resultModel;
	}


	/**
	 * 用户忘记密码
	 *
	 * @param mobile
	 * @param newPassword
	 *
	 * @return
	 */
	@RequestMapping("forgetPassword")
	@ResponseBody
	public String forgetPassword(
			@RequestParam @NotNull String mobile, @RequestParam @NotNull String newPassword) {

		return userService.changePassword(mobile, newPassword);
	}

	@RequestMapping("userInfo")
	@SecurityCheck
	public String userInfo(HttpSession session,ModelMap modelMap) {

		Integer userId = ServletUtils.resolveUserId(session);
		Optional<UserInfoEntity> optional=userService.getUserInfoById(userId);
		if (optional.isPresent()){
			modelMap.addAttribute("userInfo",optional.get());
			return "online/member";
		}
		return "redirect:/home/enroll";
	}

	@RequestMapping("modifyName")
	@SecurityCheck
	public String modifyName(HttpSession session, @RequestParam @NotNull String name) {
		Integer userId = ServletUtils.resolveUserId(session);
		userService.modifyName(userId, name);

		return "redirect:/user/userInfo";
	}

	@RequestMapping("modifyIdCardNum")
	@SecurityCheck
	public String modifyIdCardNum(HttpSession session, @RequestParam @NotNull String idCardNum) {
		Integer userId = ServletUtils.resolveUserId(session);
		userService.modifyIdCardNum(userId, idCardNum);
		return "redirect:/user/userInfo";
	}

}
