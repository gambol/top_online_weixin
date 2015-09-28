package com.top.core.viewmodel;

import com.google.common.base.Optional;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;

/**
 * Created with IntelliJ IDEA.
 * User: Wang Lei
 * Date: 2015/6/11
 * Time: 11:04
 * <p>
 * rest api result model
 */
public class ResultModel {

	/**
	 * result success code default {@value 1}
	 */
	public final static Integer CODE_SUCCESS = 1;

	/**
	 * result failure code default {@value 0}
	 */
	public final static Integer CODE_FAILURE = 0;

	private int code = 1;

	private String msg = "";

	private Object data = "";

	public int getCode() {

		return code;
	}

	public void setCode(int code) {

		this.code = code;
	}

	public String getMsg() {

		return msg;
	}

	public void setMsg(String msg) {

		this.msg = msg;
	}

	public Object getData() {

		return data;
	}

	public void setData(Object data) {

		this.data = data;
	}

	/**
	 * Return a successful ResultModel
	 *
	 * @param msg
	 * 		attached text message
	 * @param data
	 * 		attached result
	 *
	 * @return
	 */
	public static ResultModel success(@Nullable String msg, @NotNull Object data) {

		Objects.requireNonNull(data);

		ResultModel model = new ResultModel();
		model.msg = msg != null ? msg : "";
		model.setCode(CODE_SUCCESS);
		model.setData(data);
		return model;
	}

	/**
	 * Return a failed ResultModel
	 *
	 * @param msg
	 * 		attached text message
	 *
	 * @return
	 */
	public static ResultModel fail(@Nullable String msg) {

		ResultModel model = new ResultModel();
		model.msg = msg != null ? msg : "";
		model.setCode(CODE_FAILURE);
		model.setData(null);
		return model;
	}

	public static ResultModel ofOptional(Optional opt) {

		ResultModel model = new ResultModel();
		model.msg = "";
		if(opt.isPresent()) {
			return success("", opt.get());
		} else {
			return fail("");
		}
	}
}
