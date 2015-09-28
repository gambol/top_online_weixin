package com.top.core.utils;

import org.joda.time.DateTime;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.sql.Date;

/**
 * @author Sebastian MA
 */
@Converter
public class DateConverter implements AttributeConverter<DateTime, Date> {


	@Override
	public Date convertToDatabaseColumn(DateTime attribute) {


		return new Date(attribute.getMillis());
	}

	@Override
	public DateTime convertToEntityAttribute(Date dbData) {

		return new DateTime(dbData.getYear() + 1900, dbData.getMonth() + 1, dbData.getDate(), 0, 0);
	}
}
