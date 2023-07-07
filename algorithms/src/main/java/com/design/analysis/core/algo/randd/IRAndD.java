package com.design.analysis.core.algo.randd;

public interface IRAndD {

	//https://stackoverflow.com/questions/32065069/is-there-any-method-to-identify-whether-a-string-contains-html-tags-in-java
	/* Filter html and non html String */
	public boolean isStringContainHtml(String str);

	public boolean isStringContainHtmlJsoup(final String str);

	// public boolean isContainHtml(String s);
}
