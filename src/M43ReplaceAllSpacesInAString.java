//Description
// You are given a string, write a method to replace all spaces in a string with '%20'. 
//You may assume that the string has sufficient space at the end of the string to 
//hold the additional characters, and that you are given the 'true' length of the string
//(Note£º if implementing in Java, please use a character array 
//so that you can perform this operation in place).
//
//Input
// The input should be two parts. 
//The first part should be a given string and 
//the second one should be the length of the string that in form of Integer.
//
//Output
// The output should be in form of string. 
//You may assume that the input string has sufficient space at the end of the string to 
//hold the additional characters.
//
//Sample Input
//a b, 3
//Sample Output
//a%20b
//HINT
// Linear Scan
//
//Source
//Easy

public class M43ReplaceAllSpacesInAString {
	public void replaceSpaces(char[] str, int length) {
		int spaces = 0;
		for (int i = 0; i < length; i++) {
			if (str[i] == ' ')
				spaces++;
		}
		int newlen = length + 2 * spaces;
		int i = length - 1;
		int j = newlen - 1;
		while (i >= 0) {
			if (str[i] != ' ') {
				str[j--] = str[i--];
			} else {
				i--;
				str[j--] = '0';
				str[j--] = '2';
				str[j--] = '%';
			}
		}
	}
}
