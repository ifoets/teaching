package com.design.analysis.algo.randd;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.safety.Whitelist;

//@SuppressWarnings("deprecation")
public class RAndDImpl implements IRAndD {

	/* Filter html and non html String */
	public boolean isStringContainHtml(String str) {
		return str.matches(".*\\<[^>]+>.*");
	}

	public boolean isStringContainHtmlJsoup(final String str) {

		// Whitelist
		return Jsoup.isValid(str, Whitelist.none());

	}

	private static final String HTML_TAG_FORMAT_PATTERN = "<(\"[^\"]*\"|'[^']*'|[^'\">])*>";
	private static Pattern pattern = Pattern.compile(HTML_TAG_FORMAT_PATTERN);
	private static Matcher matcher;

	public static void main(String[] args) {
		String str = "<abc,key:val>";
		System.out.println(validate(str));
	}

	public static boolean validate(final String tag) {

		matcher = pattern.matcher(tag);
		return matcher.matches();

	}
}
