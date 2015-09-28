package com.top.core.controller;

import org.springframework.util.MultiValueMap;
import org.triiskelion.tinyspring.viewmodel.Page;

import javax.servlet.http.HttpSession;

/**
 * Created with IntelliJ IDEA.
 * User: Sebastian MA
 * Date: December 21, 2014
 * Time: 15:27
 * <p></p>
 * ModelController通过和前端交换view model对象完成CRUD操作
 */
public interface ModelController<T> {

	public static String PAGE = "page";

	public static String MAX = "max";

	public String add(HttpSession session, T model);

	public String remove(HttpSession session, T model);

	public String update(HttpSession session, T model);

	public Page<T> query(HttpSession session, MultiValueMap<String, String> criteria);


}
