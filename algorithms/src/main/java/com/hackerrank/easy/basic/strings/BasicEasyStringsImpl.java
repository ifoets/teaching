package com.hackerrank.easy.basic.strings;

import java.util.*;

public class BasicEasyStringsImpl implements IBasicEasyStrings {

	/** strings **/ // Start...

	/* CamelCase */
	// @Idea count upper case letters return count+1
	// ASCII of A-Z 65 - 90
	@Override
	public int camelcase(String s) {
		int count = 0;
		for (char c : s.toCharArray()) {
			if (c >= 65 && c <= 90)
				count++;
		}
		return count + 1;
	}

	/* Strong Password */
	/* Strong Password */
	@Override
	// @Idea count each stuff, check length<6 specially if 6-length>missing count
	// then 6-length other wise missing count
	// ASCII of A-Z 65 - 90 and a-z 97-122
	public int minimumNumber(int n, String password) {
		String numStr = "0123456789";
		String speStr = "!@#$%^&*()-+";
		int count[] = new int[4];
		for (char c : password.toCharArray()) {
			if (count[0] == 0 && c >= 65 && c <= 90)
				count[0]++;
			else if (count[1] == 0 && c >= 97 && c <= 122)
				count[1]++;
			else if (count[2] == 0 && numStr.contains(c + ""))
				count[2]++;
			else if (count[3] == 0 && speStr.contains(c + ""))
				count[3]++;
		}
		int result = 0;
		for (int i = 0; i < count.length; i++) {
			if (count[i] == 0)
				result++;
		}
		// check length<6 specially
		if (n < 6 && 6 - n > result)
			return 6 - n;
		return result;
	}

	/* Caesar Cipher */
	// @Idea add rotation to Ascii of each char if it>122 then it-122+64
	// for -ve k it it<97 then 97-it+121, similar to A-Z
	// ASCII of A-Z 65 - 90 and a-z 97-122
	@Override
	public String caesarCipher(String s, int k) {
		// ke may be any number 26th rotation is 0 ration
		k = k % 26;
		StringBuilder builder = new StringBuilder();
		for (char c : s.toCharArray()) {
			if (c >= 97 && c <= 122) {
				int newAscii = c + k;
				if (newAscii > 122)
					newAscii = newAscii - 122 + 96;
				else if (newAscii < 97)
					newAscii = 122 - (97 - newAscii) + k;
				builder.append((char) (newAscii));
			} else if (c >= 65 && c <= 90) {
				int newAscii = c + k;
				if (newAscii > 90)
					newAscii = newAscii - 90 + 64;
				else if (newAscii < 65)
					newAscii = 90 - (65 - newAscii) + k;
				builder.append((char) (newAscii));
			} else
				builder.append(c);
		}
		return builder.toString();
	}

	/* Mars Exploration */
	// @Idea find message count create expected and return miss match count
	// each unit of message SOS
	@Override
	public int marsExploration(String s) {
		int resultCount = 0;
		StringBuilder builder = new StringBuilder();
		String messageUnit = "SOS";
		int totalUnits = s.length() / messageUnit.length();
		for (int i = 0; i < totalUnits; builder.append(messageUnit), i++)
			;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) != builder.toString().charAt(i))
				resultCount++;
		}
		return resultCount;
	}

	/* HackerRank in a String! */
	// @Idea keep "hackerrank" in queue on iteration of s remove queue element on
	// matching
	@Override
	public String hackerrankInString(String s) {
		char[] hRank = "hackerrank".toCharArray();
		Queue<Character> queue = new LinkedList<>();
		for (int i = 0; i < hRank.length; queue.add(hRank[i]), i++)
			;
		for (char c : s.toCharArray()) {
			if (c == queue.peek())
				queue.poll();

			if (queue.size() == 0)
				return "YES";
		}
		return "NO";
	}

	/* Alternating Characters */
	// @Idea find the adjacent match if yes count
	@Override
	public int alternatingCharacters(String s) {
		int count = 0;
		char charArr[] = s.toCharArray();
		for (int i = 0; i < s.length() - 1; i++) {
			if (charArr[i] == charArr[i + 1])
				count++;
		}
		return count;
	}

	/* Gemstones */
	// @Idea find a-z in each string and count matching
	// ASCII of a-z 97-122
	@Override
	public int gemstones(List<String> arr) {
		int count = 0;
		for (int i = 97; i <= 122; i++) {
			int matchingCount = 0;
			for (String str : arr) {
				for (char ch : str.toLowerCase().toCharArray()) {
					if (ch == i) {
						matchingCount++;
						break;
					}
				}
			}
			if (matchingCount == arr.size())
				count++;
		}
		return count;
	}

	/* Funny String */
	// @Idea find reverse and check absolute corresponding ASCII difference
	@Override
	public String funnyString(String s) {
		String revS = new StringBuilder(s).reverse().toString();
		for (int i = 0; i < s.length() - 1; i++) {
			if (Math.abs(s.charAt(i) - s.charAt(i + 1)) != Math.abs(revS.charAt(i) - revS.charAt(i + 1)))
				return "Not Funny";
		}
		return "Funny";
	}

	/* Separate the Numbers */
	// @Idea try each possible no till s.len/2
	@Override
	public void separateNumbers(String s) {

		boolean valid = false;
		long firstx = -1;
		// Try each possible starting number
		for (int i = 1; i <= s.length() / 2; ++i) {
			long x = Long.parseLong(s.substring(0, i));
			firstx = x;
			// Build up sequence starting with this number
			String test = Long.toString(x);
			while (test.length() < s.length()) {
				test += Long.toString(++x);
			}
			// Compare to original
			if (test.equals(s)) {
				valid = true;
				break;
			}
		}
		System.out.println(valid ? "YES " + firstx : "NO");
	}

	/* Pangrams */
	// @Idea check every char of z-z
	@Override
	public String pangrams(String s) {
		s = s.toLowerCase().replace(" ", "");
		for (int i = 97; i <= 122; i++) {
			if (!s.contains((char) i + ""))
				return "not pangram";
		}
		return "pangram";
	}

	/* The Love-Letter Mystery */
	// @Idea i=0,j=len, i<j count absolute ASCII difference
	@Override
	public int theLoveLetterMystery(String s) {
		int count = 0;
		int i = 0;
		int j = s.length() - 1;
		while (i < j) {
			count += Math.abs(s.charAt(i) - s.charAt(j));
			i++;
			j--;
		}
		return count;
	}

	private boolean isPalindrome(String str) {
		return str.equals(new StringBuilder(str).reverse().toString());
	}

	/* Palindrome Index */
	// @Idea to check with removing every latter is str Palindrome
	@Override
	public int palindromeIndex(String s) {
		if (isPalindrome(s))
			return -1;
		int j = s.length() - 1;
		int result = -1;
		for (int i = 0; i < s.length() / 2; i++, j--) {
			StringBuilder builder1 = new StringBuilder(s);
			StringBuilder builder2 = new StringBuilder(s);
			if (isPalindrome(builder1.deleteCharAt(i).toString())) {
				result = i;
				break;
			}
			if (isPalindrome(builder2.deleteCharAt(j).toString())) {
				result = j;
				break;
			}
		}
		return result;
	}

//@Better performance  need to find the @idea
	public int palindromeIndexX(String str) {
		char[] s = str.toCharArray();
		int i, j = str.length() - 1;
		for (i = 0; i < str.length() / 2; i++, j--) {
			if (s[i] != s[j]) {
				if (s[i + 1] == s[j])
					if (s[i] == s[j - 1] && s[i + 1] == s[j - 2])
						return j;
					else
						return i;

				else if (s[j - 1] == s[i])
					return j;
			}
		}
		return -1;
	}

	/* Anagram */
	// @Idea divide/2 ,find char of one into another and remove the same for next or
	// count mismatching
	@Override
	public int anagram(String str) {
		int len = str.length();
		if (len % 2 == 1)
			return -1;
		int count = 0;
		String s1 = str.substring(0, len / 2);
		String s2 = str.substring(len / 2, len);
		char[] s1Chars = s1.toCharArray();
		for (char c : s1Chars) {
			int index = s2.indexOf(c);
			if (index == -1) {
				count++;
			} else {
				s2 = s2.substring(0, index) + s2.substring(index + 1);
			}
		}
		return count;
	}

	/* Making Anagrams */
	// @Idea find the matching char count from small to big string then
	// len1-count+len2-count;
	@Override
	public int makingAnagrams(String s1, String s2) {
		int count = 0;
		char[] s1Chars = s1.toCharArray();
		// s2 is dynamic at runtime real length affected
		String newS2 = s2;
		for (char c : s1Chars) {
			int index = s2.indexOf(c);
			if (index != -1) {
				s2 = s2.substring(0, index) + s2.substring(index + 1);
				count++;
			}
		}
		return s1.length() + newS2.length() - 2 * count;
	}

	/* Game of Thrones - I */
	// @Idea check string can be arranged in a palindrome string ie till single odd
	@Override
	public String gameOfThrones(String s) {
		Map<Character, Integer> map = new HashMap<>();
		for (char c : s.toCharArray()) {
			if (map.containsKey(c))
				map.put(c, map.get(c) + 1);
			else
				map.put(c, 1);
		}
		int count = 0;
		for (Map.Entry<Character, Integer> set : map.entrySet()) {
			if (set.getValue() % 2 != 0)
				count++;
			if (count > 1)
				return "NO";
		}
		return "YES";
	}

	/* Two Strings */
	// @Idea this is basically to check common char in both here question is just
	// twisted
	// if common sub string have len>1 even then must be a char common
	@Override
	public String twoStrings(String s1, String s2) {
		int a[] = new int[26];
		for (int i = 0; i < s1.length(); a[s1.charAt(i) - 'a']++, i++)
			;
		for (int i = 0; i < s2.length(); i++) {
			if (a[s2.charAt(i) - 'a'] != 0)
				return "YES";
		}
		return "NO";
	}

	/* String Construction */
	// @Idea to find the unique character
	@Override
	public int stringConstruction(String s) {
		int unique = 0;
		int count[] = new int[26];
		char[] chr = s.toLowerCase().toCharArray();
		for (char ch : chr) {
			count[ch - 'a']++;
		}
		for (int i = 0; i < 26; i++) {
			if (count[i] != 0)
				unique++;
		}
		return unique;
	}

	/* Beautiful Binary String */
	// @Count independent 010
	@Override
	public int beautifulBinaryString(String b) {

		int count = 0;
		char ch[] = b.toCharArray();
		for (int i = 0; i < b.length()-2; i++) {
			if (ch[i] == '0' && ch[i + 1] == '1' && ch[i + 2] == '0') {
				count++;
				i = i + 2;
			}
		}
		return count;
	}
	/*********************************************************************************************************************************/
	/** strings **/ // Continue...
}
