package com.malviyad.algo.ds;

import java.util.Stack;

public class StackParenthesisProblem {
	public static void main(String[] args) {
		char exp[] = { '{', '(', ')', '}', '[', ']', '(', ')' };
		if (areParenthesisBalanced(exp)) {
			System.out.println("Balanced ");
		} else {
			System.out.println("Not Balanced ");
		}
	}

	private static boolean areParenthesisBalanced(char[] exp) {
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < exp.length; i++) {
			if (exp[i] == '{' || exp[i] == '(' || exp[i] == '[') {
				stack.push(exp[i]);
			}
			if (exp[i] == '}' || exp[i] == ')' || exp[i] == ']') {
				if (stack.isEmpty() || !isMatchingPair(stack.pop(), exp[i])) {
					return false;
				}
			}
		}
		return stack.isEmpty()?true:false;
		
	}

	private static boolean isMatchingPair(char character1, char character2) {
		if ((character1 == '(' && character2 == ')') || (character1 == '{' && character2 == '}')
				|| (character1 == '[' && character2 == ']')) {
			return true;
		}
		return false;
	}
}
