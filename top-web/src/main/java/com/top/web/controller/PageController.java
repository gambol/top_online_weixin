package com.top.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Sebastian MA
 */
@Controller
public class PageController {

	@RequestMapping("error")
	public String error(HttpServletRequest request) {

		return "online/error";
	}
}
