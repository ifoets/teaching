package com.design.analysis.company.hackerrank.google;

public class GoogleImpl implements IGoogle {

	/** find goolge **/
	public boolean findGoogle(String str) {

		if (str == null || str.length() < 6 || str.length() > 8)
			return false;

		int i = 0;
		int count = 0;
		char ch = str.charAt(i);
		if (ch == 'G' || ch == 'g') {
			i++;
			count++;
		}
		ch = str.charAt(i);

		if (ch == 'o' || ch == 'O' || ch == '0') {
			i++;
			count++;
		} else {
			char chRev = str.charAt(i + 1);
			if (ch == '<' || ch == '(' || ch == '[') {
				if (ch == '<' && chRev == '>' || ch == '(' && chRev == ')' || ch == '[' && chRev == ']')
					i += 2;
				count++;
			}
		}
		ch = str.charAt(i);

		if (ch == 'o' || ch == 'O' || ch == '0') {
			i++;
			count++;
		} else {
			char chRev = str.charAt(i + 1);
			if (ch == '<' || ch == '(' || ch == '[') {
				if (ch == '<' && chRev == '>' || ch == '(' && chRev == ')' || ch == '[' && chRev == ']')
					i += 2;
				count++;
			}
		}
		ch = str.charAt(i);
		if (ch == 'G' || ch == 'g') {
			i++;
			count++;
		}
		ch = str.charAt(i);
		if (ch == 'I' || ch == 'L' || ch == 'l') {
			i++;
			count++;
		}
		ch = str.charAt(i);
		if (ch == 'E' || ch == 'e' || ch == '3') {
			i++;
			count++;
		}

		if (i == str.length() && count==6)
			return true;
		return false;
	}
}
