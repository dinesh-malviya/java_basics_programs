package com.malviyad.algo.strings;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Stack;
import java.util.stream.Collectors;

/*ASCI Values:-
	0 to 9 = 48 to 57
	a to z = 97 to 122
	A to Z = 65 to 90
*/
public class StringProblems {
	public static void main(String[] args) {
		// KMP Algorithm
		String message = "abcbacab";// "AABAACAADAABAAABAA";
		searchStringPattern(message, "cab");

		ArrayList<String> list = new ArrayList<>();
		list.add("dinesh");
		list.add("abcgattu");
		list.add("mahesh");
		list.add("abcverma");
		list.add("bcdpuneet");
		list.add("cdfkumar");
		list.add("abcsuresh");
		List<String> newList = list.stream().filter(p -> p.startsWith("abc")).collect(Collectors.toList());
		System.out.println(newList);

		/****************************************************
		 * Find First Non Repetitive Character
		 ****************************************************/
		char c = findFirstNonRepetitiveCharacter("ddiinesh");
		System.out.println("first non repetitive char: " + c);

		/****************************************************
		 * Anagram Strings
		 ****************************************************/
		char str1[] = ("geeksforgeeks").toCharArray();
		char str2[] = ("forgeeksgeeks").toCharArray();
		boolean anagram = areStringsAnagram(str1, str2);
		System.out.println("Anagram :" + anagram);

		/****************************************************
		 * Find no. of balloons we can build using given String
		 ****************************************************/
		// we need to find how many balloon words we can build using the given string
		String text = "balloonxballoonyballoonz";
		int count = maxNumberOfBalloons(text);
		System.out.println("count: " + count);

		/****************************************************
		 * Print duplicate elements from String
		 ****************************************************/
		printDuplicates("abdafrcf");

		/****************************************************
		 * Reverse String using recursion
		 ****************************************************/
		String str = reverseString("dinesh");
		System.out.println("reversed string: " + str);

		/****************************************************
		 * Print all permutations
		 ****************************************************/
		String testStr = "ABC";
		printAllPermutations(testStr, 0, testStr.length());
		permutation("", testStr);
		
		/****************************************************
		 * Count characters in each words for a given String
		 ****************************************************/
		String sentence = "my name is dinesh malviya";
		count("my name is dinesh malviya");
		
		/****************************************************
		 * Reverse each word in a given sentence
		 ****************************************************/
		reverseEachWordInString("my name is dinesh malviya");
	}

	private static char findFirstNonRepetitiveCharacter(String str) {
		Map<Character, Integer> counts = new LinkedHashMap<>(str.length());
		for (char c : str.toCharArray()) {
			counts.put(c, counts.containsKey(c) ? counts.get(c) + 1 : 1);
		}
		Iterator<Character> k = counts.keySet().iterator();
		while (k.hasNext()) {
			System.out.println(k.next());
		}
		counts.forEach((key,v)->System.out.println("Key: "+key+", Value:"+v));

		for (Entry<Character, Integer> entry : counts.entrySet()) {
			if (entry.getValue() == 1) {
				return entry.getKey();
			}
		}
		throw new RuntimeException("didn't find any non repeated Character");
	}

	private static void searchStringPattern(String txt, String pat) {
		int txtLen = txt.length();
		int pattLen = pat.length();
		for (int i = 0; i <= txtLen - pattLen; i++) {
			int j;
			for (j = 0; j < pattLen; j++) {
				if (txt.charAt(i + j) != pat.charAt(j)) {
					break;
				}
			}
			if (j == pattLen) {
				System.out.println("Pattern found from index: " + i + " to: " + (i + (pattLen - 1)));
			}
		}
	}

	private static boolean areStringsAnagram(char str1[], char str2[]) {
		if (str1.length != str2.length) {
			return false;
		}
		int arr1[] = new int[26];
		int arr2[] = new int[26];
		for (int i = 0; i < str1.length && i < str2.length; i++) {
			arr1[str1[i] - 'a']++;
			arr2[str2[i] - 'a']++;
		}
		for (int i = 0; i < 26; i++) {
			if (arr1[i] != arr2[i]) {
				return false;
			}
		}
		return true;
	}

	public static int maxNumberOfBalloons(String text) {
		int[] count = new int[26];
		for (char ch : text.toCharArray()) {
			count[ch - 'a']++;// here we are incrementing the value at ch-'a' index. eg. 'a'-'a' =0++ which 1
		}
		int res = Integer.MAX_VALUE;
		res = Math.min(res, count['b' - 'a']);
		res = Math.min(res, count['a' - 'a']);
		res = Math.min(res, count['l' - 'a'] / 2);
		res = Math.min(res, count['o' - 'a'] / 2);
		res = Math.min(res, count['n' - 'a']);

		return res;
	}

	private static void printDuplicates(String str) {
		HashSet<Character> set = new HashSet<>();
		char array[] = str.toCharArray();
		for (char i : array) {
			if (set.add(i)) {
				System.out.println("Adding number: " + i);
			} else {
				System.out.println("duplicate number: " + i);
			}
		}
		Iterator<Character> iterator = set.iterator();
		while (iterator.hasNext()) {
			System.out.println("printing: " + iterator.next());
		}
	}

	private static String reverseString(String str) {
		if (str.length() == 1) {
			return str;
		}
		return str.charAt(str.length() - 1) + reverseString(str.substring(0, str.length() - 1));
	}

	private static void printAllPermutations(String str, int start, int end) {
		for (int i = start; i < end; i++) {
			if (start == end - 1) {
				System.out.println("Permutations:" + str);
				for (char ch : str.toCharArray()) {
					System.out.println(ch);
				}
			}
			// Swapping the string by fixing a character
			str = swapString(str, start, i);
			// Recursively calling function generatePermutation() for rest of the characters
			printAllPermutations(str, start + 1, end);
			// Backtracking and swapping the characters again.
			str = swapString(str, start, i);
		}
	}

	private static String swapString(String str, int i, int j) {
		char ch[] = str.toCharArray();
		char temp = ch[i];
		ch[i] = ch[j];
		ch[j] = temp;
		return String.valueOf(ch);
	}

	private static void permutation(String perm, String word) {
		if (word.isEmpty()) {
			System.out.println(perm + word);
		} else {
			for (int i = 0; i < word.length(); i++) {
				System.out.println("i: " + i + ", word: " + word);
				permutation(perm + word.charAt(i), word.substring(0, i) + word.substring(i + 1, word.length()));
			}
		}
	}
	private static void count(String sentence) {
		for (int i = 0; i < sentence.length(); i++) {
			StringBuilder word = new StringBuilder();
			while (i < sentence.length() && sentence.charAt(i) != ' ') {
				word = word.append(sentence.charAt(i));
				i++;
			}
			if (word.length() != 0) {
				System.out.println(word + " ->" + word.length());
			}
		}
	}
	
	private static void reverseEachWordInString(String str) {
		Stack<Character> stack = new Stack<>();
		for(int i =0; i<str.length(); i++) {
			if(str.charAt(i)!= ' ') {
				stack.push(str.charAt(i));
			}else {
				while(!stack.isEmpty())
				System.out.print(stack.pop());
			}
			System.out.print(" ");
		}
	}
}
