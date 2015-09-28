package com.top.core.service.impl;


import com.top.core.base.GeoLocation;

import java.util.Optional;

/**
 * @author Sebastian MA
 */
public interface GeoLocationService {

	/**
	 * 根据地址获取坐标
	 *
	 * @param address
	 * 		详细地址
	 *
	 * @return 经纬度坐标
	 */
	Optional<GeoLocation> resolveGeolocation(String address);
}
