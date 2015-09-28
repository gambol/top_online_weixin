package com.top.core.utils;

import org.joda.time.DateTime;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.sql.Timestamp;

/**
 * @author Tian MA
 */
public class TimestampConverter implements AttributeConverter<DateTime, Timestamp> {

	@Override
	public Timestamp convertToDatabaseColumn(DateTime attribute) {

		if(attribute == null) {
			return null;
		}
		return new Timestamp(attribute.getMillis());
	}

	@Override
	public DateTime convertToEntityAttribute(Timestamp dbData) {

		if(dbData == null) {
			return null;
		}
		return new DateTime(dbData.getTime());
	}
}