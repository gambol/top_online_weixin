package com.top.web.controller;

import com.top.core.controller.AbstractController;
import com.top.core.domain.UserInfoEntity;
import com.top.core.utils.ServletUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.triiskelion.tinyspring.security.AuthenticationResult;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Sebastian MA
 */
@Controller
@RequestMapping("auth")
public class AuthenticationController extends AbstractController {

    @Resource
    private com.top.core.service.SecurityManager securityManager;

    /**
     * 用户登录鉴权
     *
     * @param username
     * @param password
     * @return
     */
    @RequestMapping("login")
    @ResponseBody
    public Map serviceProviderLogin(HttpSession session,HttpServletRequest request, RedirectAttributes attributes,
                                    @RequestParam String username, @RequestParam String password) {

        Map map = new HashMap<>();
        AuthenticationResult result
                = securityManager.doAuthenticate(session, username, password);

        if (result.isSuccess()) {
            String openId = (String) session.getAttribute("wx_openId");
            log.debug("wx_openId start:"+openId);
            if (ServletUtils.checkWeChat(request) && StringUtils.isNotBlank(openId)) {
                userService.bindingWeChat(ServletUtils.resolveUserId(session),openId);
                log.debug("wx_openId:"+openId);
            }
            map.put("success", true);
        } else {

            map.put("success", false);
            map.put("errorMsg", "failure");
        }
        return map;

    }

    @RequestMapping("logout")
    public String serviceProviderLogin(HttpSession session) {

        session.invalidate();
        return "redirect:/home/login";
    }

}
