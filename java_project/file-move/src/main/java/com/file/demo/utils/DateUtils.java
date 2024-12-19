package com.file.demo.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.file.demo.model.RegexResponse;

public class DateUtils {
	/**
	 * Regex method for string
	 * @param value	String value
	 * @param regex Regex string which may consists of different format
	 * @return response from regex which includes boolean and matched string
	 */
	public RegexResponse dateMatcher(String value, String regex) {
		Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(value);

		return new RegexResponse(matcher.find(), matcher.group());
	}
}
