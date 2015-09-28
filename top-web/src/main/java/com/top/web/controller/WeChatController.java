package com.top.web.controller;

import com.github.sd4324530.fastweixin.api.OauthAPI;
import com.github.sd4324530.fastweixin.api.config.ApiConfig;
import com.github.sd4324530.fastweixin.api.enums.OauthScope;
import com.github.sd4324530.fastweixin.api.response.OauthGetTokenResponse;
import com.tencent.common.Configure;
import com.top.core.controller.AbstractController;
import com.top.core.utils.ResultValues;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

/**
 * Created with IntelliJ IDEA.
 * User: Wang Lei
 * Date: 2015/6/12
 * Time: 17:31
 * <p>
 * TODO
 */
@RequestMapping("weChat")
@Controller
public class WeChatController extends AbstractController {


    /**
     * 1 第一步：用户同意授权，获取code
     *
     * @param state 标识
     * @return oauth url
     */
    @RequestMapping("entrance")
    public String entrance(@RequestParam(required = false, defaultValue = Configure.STATE_DEFAULT) String state) {

        return "redirect:" + getOauthApi().getOauthPageUrl(Configure.getRedirect_uri(), OauthScope.SNSAPI_BASE, state);
    }

    /**
     * 获取用户 openid
     *
     * @param session
     * @param code
     * @param state
     * @param map
     * @return
     */
    @RequestMapping("getOpenId")
    public String getOpenId(HttpSession session,
                            @RequestParam(required = false) String code,
                            @RequestParam(required = false, defaultValue = Configure.STATE_DEFAULT) String state, ModelMap map) {
        OauthGetTokenResponse response = getOauthApi().getToken(code);
        String openId = response.getOpenid();
        session.setAttribute("wx_openId", openId);
        switch (state) {
            case Configure.STATE_DEFAULT:
                return "redirect:" + "/home/login";

            default:
                return "redirect:" + "/home/login";
        }
    }

}
