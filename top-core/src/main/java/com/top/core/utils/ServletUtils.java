package com.top.core.utils;

import com.top.core.domain.UserInfoEntity;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.MultiValueMap;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.triiskelion.tinyspring.security.TinySecurityManager;
import org.triiskelion.tinyspring.security.TinyUser;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * @author Sebastian MA
 */
public class ServletUtils {

	/**
	 * @param models
	 * 		modal map
	 * @param message
	 * 		错误信息
	 * @param detail
	 * 		详细说明
	 * @param redirect
	 * 		跳转链接
	 *
	 * @return
	 */
	public static String errorPage(RedirectAttributes models, String message, String detail,
	                               String redirect) {

		models.addFlashAttribute("message", message)
		      .addFlashAttribute("detail", detail)
		      .addFlashAttribute("redirect", redirect);

		return "redirect:/error";
	}

	/**
	 * 从session中获取登录成功后保存的UserInfoEntity对象
	 *
	 * @param session
	 *
	 * @return
	 */
	public static Integer resolveUserId(HttpSession session) {

		TinyUser user = (TinyUser) session.getAttribute(TinySecurityManager.SESSION_NAME_USER);
		if(user != null)
			return (Integer) user.getNestedEntity();
		else
			throw new IllegalStateException("user not found");
	}

	public static UserInfoEntity resolveUserId(HttpServletRequest request) {

		return (UserInfoEntity) request.getAttribute(TinySecurityManager.SESSION_NAME_USER);
	}

	/**
	 * 获取参数 无默认值
	 *
	 * @param criteria
	 * @param key
	 *
	 * @return
	 */
	public static Integer getFirstInteger(MultiValueMap<String, String> criteria, String key) {

		List<String> list = criteria.get(key);
		if(list == null) {
			return null;
		}
		try {
			return Integer.valueOf(list.get(0));
		} catch(NumberFormatException e) {
			return null;
		}
	}

	/**
	 * 获取参数 有默认值
	 *
	 * @param criteria
	 * @param key
	 * @param defaultValue
	 *
	 * @return
	 */
	public static Integer getFirstInteger(MultiValueMap<String, String> criteria, String key,
	                                      Integer defaultValue) {

		List<String> list = criteria.get(key);
		if(list == null) {
			return defaultValue;
		}
		return StringUtils.isBlank(list.get(0)) ? defaultValue : Integer.valueOf(list.get(0));
	}

	/**
	 * check if browser if a mobile device based on its user agent.
	 *
	 * @param request
	 *
	 * @return
	 */
	public static boolean checkMobileDevice(HttpServletRequest request) {

		boolean flag = false;
		String[] keywords = { "Android", "iPhone", "iPod", "iPad", "Windows Phone", "MQQBrowser" };
		String userAgent = request.getHeader("User-Agent");
		if(!userAgent.contains("Windows NT") || (userAgent.contains("Windows NT") && userAgent
				.contains("compatible; MSIE 9.0;"))) {
			//排除 苹果桌面系统
			if(!userAgent.contains("Windows NT") && !userAgent.contains("Macintosh")) {
				for(String str : keywords) {
					if(userAgent.contains(str)) {
						flag = true;
						break;
					}
				}
			}
		}

		return flag;
	}

	/**
	 * 获取参数 无默认值
	 *
	 * @param criteria
	 * @param key
	 *
	 * @return
	 */
	public static String getFirstString(MultiValueMap<String, String> criteria, String key) {

		List<String> list = criteria.get(key);
		if(list == null) {
			return null;
		}
		try {
			return list.get(0);
		} catch(NumberFormatException e) {
			return null;
		}
	}

	public static boolean checkCellPhoneNumber(String cellphone) {

		Pattern pattern = Pattern.compile("^1\\d{10}$");
		Matcher matcher = pattern.matcher(cellphone);
		return matcher.matches();
	}


	/**
	 * check if browser if a wechat based on its user agent.
	 *
	 * @param request
	 *
	 * @return
	 */
	public static boolean checkWeChat(HttpServletRequest request) {

		String user_agent = request.getHeader("user-agent");
		if(user_agent.indexOf("MicroMessenger") > 0) {
			return true;
		}
		return false;
	}

	public static void redirect(HttpServletRequest req, HttpServletResponse res, String url)
			throws IOException {

		res.sendRedirect(req.getContextPath() + url);
	}
}
