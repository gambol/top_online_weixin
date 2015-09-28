package com.top.core;

import com.github.sd4324530.fastweixin.api.OauthAPI;
import com.github.sd4324530.fastweixin.api.config.ApiConfig;
import com.tencent.common.Configure;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;

/**
 * @author Tian MA
 */
public class AbstractSpringBean {

    protected Logger log;

    @PostConstruct
    void postConstruct() {

        log = LoggerFactory.getLogger(this.getClass().getCanonicalName());
    }

    protected static OauthAPI oauthAPI;
    protected static ApiConfig config;

    public static ApiConfig getApiConfig() {
        if (config == null) {
            config = new ApiConfig(Configure.getAppid(), Configure.getAppsecret(), true);
        }
        return config;
    }

    public static OauthAPI getOauthApi() {
        if (oauthAPI == null) {
            oauthAPI = new OauthAPI(getApiConfig());
        }
        return oauthAPI;
    }

}
