package com.malviyad.algo.strings;

public class CountCharacterInEachWords {
	public static void main(String[] args) {
		String sentence = "my name is dinesh malviya";
		count(sentence);
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
}
