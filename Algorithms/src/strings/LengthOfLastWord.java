package strings;

public class LengthOfLastWord {
	public int lengthOfLastWord(String s) {
		int length = s.length(), last = 0, count = 0;
		for (int i = 0; i < length; i++) {
			if (s.charAt(i) == ' ') {
				if (count != 0) last = count;
				count = 0;
			} else {
				count++;
			}
		}

		return count == 0? last : count;
	}
}
