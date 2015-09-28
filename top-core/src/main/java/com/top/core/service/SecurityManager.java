package com.top.core.service;

import com.google.common.base.Optional;
import com.top.core.dao.UserDao;
import com.top.core.domain.UserInfoEntity;
import com.top.core.utils.MD5Utils;
import com.top.core.utils.ServletUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.triiskelion.tinyspring.security.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

/**
 * @author Sebastian MA
 */
@Service
public class SecurityManager extends TinySecurityManager {

    private static Logger log = LoggerFactory.getLogger(SecurityManager.class);

    @Resource
    private UserDao userDao;

    @Override
    public AuthenticationResult doAuthenticate(HttpSession session,
                                               String login, String password) {

        Optional<UserInfoEntity> userOpt = userDao.findByMobile(login);

        if (userOpt.isPresent()) {
            TinyUser user = new TinyUser(login, new ArrayList<>(), userOpt.get().getId());
            if (Objects.equals(userOpt.get().getPassword(), MD5Utils.encrypt(password, 16))) {
                session.setAttribute(SESSION_NAME_USER, user);
                return AuthenticationResult.of(user);
            }
        }
        return AuthenticationResult.denied();
    }

    @Override
    protected boolean doAuthenticateStatelessly(HttpServletRequest request,
                                                HttpServletResponse response) {

        return false;
    }

    @Override
    protected void onNotLogin(HttpServletRequest request, HttpServletResponse
            response) {

        try {
            ServletUtils.redirect(request, response, "/home/login");
        } catch (IOException e) {
            log.error("Could not redirect to: {}", "/home/login");
        }
    }


    @Override
    protected void onRequireAllPrivilegesFail(HttpServletRequest request, HttpServletResponse
            response, TinyUser tinyUser, String[] strings) {

    }

    @Override
    protected void onRequireAnyPrivilegeFail(HttpServletRequest request, HttpServletResponse
            response, TinyUser tinyUser, String[] strings) {

    }

    @Override
    public void onRequireRolesFail(HttpServletRequest request, HttpServletResponse
            response, TinyUser user, String[] roles) {

        try {
            response.getWriter().write("NOT_ALLOWED");
        } catch (IOException ignored) {
        }

    }


}
