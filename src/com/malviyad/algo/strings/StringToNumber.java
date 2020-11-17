package com.malviyad.algo.strings;

public class StringToNumber {
	public static void main(String[] args) {
		int num = convertStringToNumber("3256");
		System.out.println("String to Number: "+num);
		num = getNumber("3256");
		System.out.println("String to Number: "+num);
		num = getNumberUsingPower("3256");
		System.out.println("String to Number: "+num);
		
		boolean areOnlyDigits = checkIfStringContainsOnlyDigits("3256");
		System.out.println("areOnlyDigits: "+areOnlyDigits);
	}
	
	private static int convertStringToNumber(String stringNum){
		char charArr[] = stringNum.toCharArray();
		int sum = 0;
		int zeroAscii = '0';
		for (char c : charArr) {
			int tempAscii = (int)c;
			sum = (sum*10)+(tempAscii-zeroAscii);
		}
		return sum;
	}
	
	public static int getNumberUsingPower(String stringNum) {
		double number=0;
	    for (int i = 0; i < stringNum.length(); i++) {
	        int tempNumber =  stringNum.charAt(i)-'0';
	        number = number+ (tempNumber*Math.pow(10, (stringNum.length()-i-1)));
	        System.out.println("number:"+number);
	    }
	    return (int) (number);
	}

	public static int getNumber(String stringNum) {
	    int result = 0;
	    int j='0'; 
	    //for 0-9, the ASCII value is 48 to 57 
	    System.out.println("ASCII Value of '0':"+j);
	    for (int i = 0; i < stringNum.length(); i++) {
	        result = result * 10 + stringNum.charAt(i) - '0';
	        System.out.println("result:"+result);
	    }
	    return result;
	}
	
	private static boolean checkIfStringContainsOnlyDigits(String str) {
		for(int i = 0; i<str.length(); i++) {
			int asciiValue = str.charAt(i);
			if(!(asciiValue >=48 && asciiValue<=57)) {
				return false;
			}
		}
		return true;
	}
}
