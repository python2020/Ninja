package strings;


public class ReverseWordsInSentence {
	public static void reverse(char[] sc, int start, int end) {
		char t;
		while (start < end) {
			t = sc[start];
			sc[start] = sc[end];
			sc[end] = t;
			start++;
			end--;
		}
	}

	public static String reverseWords(String s) {
		// error check
		if (s == null) throw new NullPointerException();

		char[] strChar = s.toCharArray();
		int length = s.length();

		// 1. reverse the whole string
		reverse(strChar, 0, length-1);

		// 2. traverse the string, identify and then flip each word
		int start = 0, end = 0;

		while (end < length) {
			if (strChar[end] == ' ') { 
				reverse(strChar, start, end-1);
				start = end + 1;
			}
			end++;
		}

		if (start != end) reverse(strChar, start, end-1);

		return new String(strChar);
	}
	
	
	public static void main(String[] args) {
		
		System.out.println(ReverseWordsInSentence.reverseWords("this is a cat"));
	}
}
