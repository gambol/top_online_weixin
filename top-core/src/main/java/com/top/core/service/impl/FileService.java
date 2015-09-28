package com.top.core.service.impl;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author Sebastian MA
 */
public interface FileService {


	String prefix = "http://www.eggcharge.com/images/";

	public String put(String path, String filename, byte[] bytes);

	public String upload(MultipartFile file);

	/**
	 * 获取完整的url
	 *
	 * @param relativeUrl
	 * 		没有域名的相对路径
	 *
	 * @return 完整的url
	 */
	default public String getAbsoluteUrl(String relativeUrl) {

		return prefix + relativeUrl;
	}
}
