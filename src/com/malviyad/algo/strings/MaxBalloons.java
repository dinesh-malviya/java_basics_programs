package com.malviyad.algo.strings;

public class MaxBalloons {
	public static void main(String[] args) {
		//String text = "baoollnnololgbax";
		String text = "balloonxballoonyballoonz";
		int count = maxNumberOfBalloons(text);
		System.out.println("count: " + count);
		
		int[] array = new int[26];
		for (int i : array) {
			System.out.println(i);
		}
		array[5]++;
		System.out.println("========");
		for (int i : array) {
			System.out.println(i);
		}
	}

	public static int maxNumberOfBalloons(String text) {
		int[] count = new int[26];
		for (char ch : text.toCharArray()) {
			count[ch - 'a']++;//here we are incrementing the value at ch-'a' index. eg. 'a'-'a' =0++ which 1
		}
		
		int res = Integer.MAX_VALUE;
		res = Math.min(res, count['b' - 'a']);
		res = Math.min(res, count['a' - 'a']);
		res = Math.min(res, count['l' - 'a'] / 2);
		res = Math.min(res, count['o' - 'a'] / 2);
		res = Math.min(res, count['n' - 'a']);
		
		return res;
	}
}
