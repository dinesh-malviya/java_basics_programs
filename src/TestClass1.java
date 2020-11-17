
public class TestClass1 {
	public static void main(String[] args) {
		//String text = "baoollnnololgbax";
		String text = "balloonxballoonyballoonz";
		int result = maxNumberOfBalloons(text);
		System.out.println(result);
		char value = 45;
		//System.out.println(value);
		char value1 = 46;
		//System.out.println(value1);
		testMethod(4);
		testMethod(5);
		testMethod(6);
		testMethod(7);
		testMethod(8);
	}

	private static void testMethod(int n){
		switch (n)
		{	
		case 4:
		case 5:
		case 6:
		case 7:
		case 8:
		System.out.println("here");
		  break;
		    case 2: // code to be executed if n = 2;
		  break;
		    default: // code to be executed if 
		      // n doesn't match any cases
		}
	}
	public static int maxNumberOfBalloons(String text) {
		int[] count = new int[26];
		for (char c : text.toCharArray()) {
			count[c - 'a']++;
		}
		int result = Integer.MAX_VALUE;
		char[] l = new char[] { 'b', 'a', 'l', 'o', 'n' };

		for (int i = 0; i < l.length; i++) {
			if (l[i] == 'l' || l[i] == 'o') {
				result = Math.min(result, count[l[i] - 'a'] / 2);
			} else {
				result = Math.min(result, count[l[i] - 'a']);
			}
		}
		return result;
	}
}
