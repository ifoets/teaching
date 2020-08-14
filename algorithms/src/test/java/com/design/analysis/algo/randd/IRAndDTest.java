package com.design.analysis.algo.randd;

import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;

public class IRAndDTest {

	private IRAndD rnd = null;

	@Before
	public void init() {
		rnd = new RAndDImpl();
	}

	/* Filter html and non html String */
	@Test // TODO
	public void isStringContainHtmlTest() {
		String nonHtml[] = { "<f", ">", "&", "", "=", "%", "Euro", "_", ",", "-", ":", "~", "*", "^", "@?", "(?", ")?",
				"ac>ef&<", "<<", "/>", "&scr=", "good", "/^/", "lt&", "gt&", "amp&", "quot&", "\\", "abc efg",
				"ab>ce/>*&$%" };

		String html[] = { "<h1>A</h1>", "</>", "&lt", "&gt", "<html>",
				"<a href=\"https://www.w3schools.com\">This is a link</a>", "<br>", "<p>", "</body>", "&amp", "&quot",
				"<a>", "<//a>", "<herf=>", "<herf=", "<p>Hello, world!</p>", " /", "<h1>", "<b>", "<pre>", "</>",
				"<abc>", " ", "av<jkjk", "<abce/<*&$%" };

		for (int i = 0; i < nonHtml.length; i++) {

			System.out.println(nonHtml[i] + "     " + rnd.isStringContainHtml(nonHtml[i]));
		}
		System.out.println();
		System.out.println();
		for (int i = 0; i < html.length; i++) {
			System.out.println(html[i] + "     " + rnd.isStringContainHtml(html[i]));
		}

		JSONObject js1 = new JSONObject();
		JSONObject js2 = new JSONObject();
		JSONObject js3 = new JSONObject();
		JSONObject js4 = new JSONObject();
		js1.append("key1", "x<y");
		js1.append("key2", "a<b");

		js2.append("key1", "x>y");
		js2.append("key2", "a>b");

		js3.append("key1", "x>y");
		js3.append("key2", "a<b");

		js4.append("key1", "x<y");
		js4.append("key2", "a>b");
		String str1 = js1.toString();
		String str2 = js2.toString();
		String str3 = js3.toString();
		String str4 = js4.toString();
		System.out.println(str1 + "    " + rnd.isStringContainHtml(str1));
		System.out.println(str2 + "    " + rnd.isStringContainHtml(str2));
		System.out.println(str3 + "    " + rnd.isStringContainHtml(str3));
		System.out.println(str4 + "    " + rnd.isStringContainHtml(str4));

	}

	@Test
	public void isStringContainHtmlJsoupTest() {
		String nonHtml[] = { "<", ">", "&", "", "=", "%", "Euro", "_", ",", "-", ":", "~", "*", "^", "@?", "(?", ")?",
				"ac>ef&<", "<<", "/>", "&scr=", "good", "/^/", "lt&", "gt&", "amp&", "quot&", "\\", "abc efg",
				"ab>ce/>*&$%" };

		String html[] = { "< ", "<h1>A</h1>", "</>", "&lt", "&gt", "<html>",
				"<a href=\"https://www.w3schools.com\">This is a link</a>", "<br>", "<p>", "</body>", "&amp", "&quot",
				"<a>", "<//a>", "<herf=>", "<herf=", "<p>Hello, world!</p>", " /", "<h1>", "<b>", "<pre>", "</>",
				"<abc>", " ", "av<jkjk", "<abce/<*&$%" };

		for (int i = 0; i < nonHtml.length; i++) {

			System.out.println(nonHtml[i] + "     " + rnd.isStringContainHtmlJsoup(nonHtml[i]));

		}
		System.out.println();
		System.out.println();
		for (int i = 0; i < html.length; i++) {
			System.out.println(html[i] + "     " + rnd.isStringContainHtmlJsoup(html[i]));
		}

		JSONObject js1 = new JSONObject();
		JSONObject js2 = new JSONObject();
		JSONObject js3 = new JSONObject();
		JSONObject js4 = new JSONObject();
		js1.append("key1", "x<y");
		js1.append("key2", "a<b");

		js2.append("key1", "x>y");
		js2.append("key2", "a>b");

		js3.append("key1", "x>y");
		js3.append("key2", "a<b");

		js4.append("key1", "x<y");
		js4.append("key2", "a>b");
		String str1 = js1.toString();
		String str2 = js2.toString();
		String str3 = js3.toString();
		String str4 = js4.toString();
		System.out.println(str1 + "    " + rnd.isStringContainHtmlJsoup(str1));
		System.out.println(str2 + "    " + rnd.isStringContainHtmlJsoup(str2));
		System.out.println(str3 + "    " + rnd.isStringContainHtmlJsoup(str3));
		System.out.println(str4 + "    " + rnd.isStringContainHtmlJsoup(str4));
	}

}
