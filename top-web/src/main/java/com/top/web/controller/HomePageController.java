package com.top.web.controller;


import com.google.common.base.Optional;
import com.tencent.common.Configure;
import com.top.core.controller.AbstractController;
import com.top.core.domain.ProjectEntity;
import com.top.core.domain.UserInfoEntity;
import com.top.core.utils.ServletUtils;
import common.utils.Objects;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.triiskelion.tinyspring.security.SecurityCheck;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * UserController
 *
 * @author WangLei
 */
@Controller
@RequestMapping("home")
public class HomePageController extends AbstractController {


    /**
     * 注册跳转
     *
     * @return
     */
    @RequestMapping("register")
    public String register(HttpSession session) {

        return "online/register";
    }

    /**
     * 登录跳转
     *
     * @return
     */
    @RequestMapping("login")
    public String login(HttpSession session, HttpServletRequest request, ModelMap modelMap) {
        String openId = (String) session.getAttribute("wx_openId");
        if (ServletUtils.checkWeChat(request) && StringUtils.isBlank(openId)) {
            modelMap.addAttribute("isWeChat", true);
            modelMap.addAttribute("state", Configure.STATE_DEFAULT);
            return "redirect:/weChat/entrance";
        } else {
            modelMap.addAttribute("isWeChat", false);
            return "online/login";
        }
    }


    /**
     * 1. 报名页面, 用户选择合适的项目确认后进入确认订单页面
     *
     * @param session
     * @return
     * @author Tian MA
     */
    @RequestMapping("enroll")
    @SecurityCheck
    public String enroll(HttpSession session) {

        return "online/enroll";
    }

    /**
     * 2. 确认订单页面, 用户确认金额后点击确定即生成订单并跳转到支付界面
     *
     * @param models
     * @param session
     * @param projectId 购买的项目id
     * @return
     * @author Tian MA
     */
    @RequestMapping("confirmOrder")
    @SecurityCheck
    public String confirmOrder(ModelMap models, HttpSession session, @RequestParam int projectId,
                               RedirectAttributes redirectAttrs) {


        Optional<ProjectEntity> opt = projectService.findById(projectId);
        if (!opt.isPresent()) {

            return ServletUtils.errorPage(redirectAttrs,
                    "未找到项目",
                    "您选择的项目可能已经关闭,请重新选择",
                    "/home/enroll");
        }

        Optional<UserInfoEntity> optional = userService.getUserInfoById(ServletUtils.resolveUserId(session));
        models.put("realname", Objects.or(optional.get().getName(), "暂无"));
        models.put("mobile", Objects.or(optional.get().getMobile(), "暂无"));

        ProjectEntity project = opt.get();

        models.put("projectId", projectId);
        try {
            String name = specialtyService.findById(project.getMajorId()).getName();
            models.put("name", name);
        } catch (NullPointerException e) {
            models.put("name", "暂无信息");
        }

        String unit = "";
        switch (project.getStudyUnit()) {
            case 1:
                unit = "学年";
                break;
            case 2:
                unit = "月";
                break;
            case 3:
                unit = "日";
                break;
            case 4:
                unit = "小时";
                break;
        }


        models.put("duration", project.getStudyDuration() + unit);
        models.put("examFee", project.getExamFee() + "元");
        models.put("tuitionFee", project.getTuitionFee() + "元/" + unit);
        models.put("bookFee", project.getBookFee() + "元");
        models.put("totalFee", project.getTotalFee() + "元");

        models.put("point", 20);
        //todo 积分折现公式待定
        models.put("discount", 20 / (float) 10);

        models.put("total", project.getTotalFee());

        return "online/confirmOrder";
    }

    @RequestMapping("forgetPass")
    public String forgetPass(HttpSession session) {

        return "online/forgetPass";
    }

    @RequestMapping("person")
    public String person(HttpSession session) {

        return "online/person";
    }

    @RequestMapping("member")
    public String member(HttpSession session) {

        return "online/member";
    }

    /**
     * 修改用户基本信息
     *
     * @param session
     * @param type    1:用户姓名；2:用户身份证号码
     * @return
     */
    @RequestMapping("userInfoModify")
    public String userInfoModify(ModelMap models, HttpSession session, @RequestParam int type) {
        Optional<UserInfoEntity> optional = userService.getUserInfoById(ServletUtils.resolveUserId(session));
        if (optional.isPresent()) {
            if (type == 1) {
                models.put("title", "真实姓名");
            } else if (type == 2) {
                models.put("title", "身份证号");
            }
            models.put("name", optional.get().getName());
            models.put("idCardNum", optional.get().getIdCard());
            models.put("type", type);
            return "online/userInfoModify";
        }
        return "online/userInfoModify";
    }
}
