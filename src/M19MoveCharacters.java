//Description
//Given a string consists of lower-case letters and spaces only, 
//you are only allowed to MOVE characters from the given string.
//The goal is to change the original string to a new string with character moves, 
//no order of the letters change is allowed, 
//so that all the spaces should be at the beginning of the new string. 
//How would you move it in-place to reach this goal?
//
//Input
//The input should be a string, and the length of string should be 
//less than or equal to 1,000,000.
//
//Output
//The output should be in the format of String. 
//All the spaces should be at the beginning of the new string
//
//Sample Input
//a b   c
//Sample Output
//    abc
//HINT
//Linear Scan
//
//Source
//Easy

public class M19MoveCharacters {
	public static void main(String[] args) {
		String ss = "a b   c";
		char[] s = ss.toCharArray();
		for (char c : s)
			System.out.print(c);
		System.out.println();
		new M19MoveCharacters().moveThem(s);
		for (char c : s)
			System.out.print(c);
	}

	public void moveThem(char[] s) {
		int len = s.length;
		int pos = len - 1;
		for (int i = len - 1; i >= 0; i--) {
			if (s[i] != ' ') {
				s[pos] = s[i];
				if (pos != i)
					s[i] = ' ';
				pos--;
			}
		}
	}
}
