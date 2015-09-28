package com.top.core.service.impl;

import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * @author Sebastian MA
 */
public interface SystemPropertyService {


	Optional<String> getString(String key);

	Optional<Integer> getInt(String key);

	Optional<Double> getDouble(String key);

	<T> Optional<T> getObject(String key, Class<T> clazz);

	<T> List<T> getArray(String key, Class<T> clazz);

	<T> Map<String, T> getMap(String key, Class<T> clazz);

}
