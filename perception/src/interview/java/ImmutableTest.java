package interview.java;

import java.util.HashMap;

public class ImmutableTest {

	/*
	 * public static void main(String[] args) { String str = "abkumar"; str="abc";
	 * str = str.replace("abk", "b");//str.replace("abk", "b");
	 * System.out.println(str);
	 * 
	 * HashMap<String, String> map=new HashMap<>(); map.put("abc", "abc"); boolean
	 * ab=str.isEmpty(); System.out.println(ab);
	 * 
	 * }
	 */

	// is st2 roated of st2
	public boolean isRotated(String st1, String st2) {
		return (st1 + st1).contains(st2);
	}

	public boolean s1Ands2MadeBySameString(String s1, String s2) {

		if (s1.length() != s2.length())
			return false;

		char cha1[] = s1.toLowerCase().toCharArray();
		char cha2[] = s2.toLowerCase().toCharArray();
		int a[] = new int[26];
		int b[] = new int[26];
		// since s1 and s2 have same laneth
		//asci value of a=48
		for (int i = 0; i < s1.length(); i++) {
			a[cha1[i] - 48]++;
			b[cha2[i] - 48]++;
		}
		
		for (int i = 0; i < a.length; i++) {
			if (a[i] != b[i])
				return false;
		}
		return true;
	}
}
