package main;

public class StringOperations {

	public static String reverse(String s) {
		char[] stringArray = new char[s.length()];

		for (int i = 0; i < s.length(); i++) {
			stringArray[i] = s.charAt(i);
		}

		String returnString = "";

		for (int i = s.length() - 1; i != -1; i--) {
			returnString += stringArray[i];
		}

		return returnString;
	}

	public static boolean isPalindrome(String s) {
		return s.equals(reverse(s)) ;
	}
	
	public static void main(String[] args) {
		System.out.println(reverse("habibi"));
		System.out.println(isPalindrome("habibi"));
		
	}
}
