//Description
// You are given a string, how would you reverse the string in place.
//
//Input
// The input should be in the format of String.
//
//Output
// The output should be in the format of String.
//
//Sample Input
//abcde
//Sample Output
//edcba
//HINT
// Two Pointers
//
//Source
//Easy

public class M44ReverseString {
	public char[] reverse(char[] str) {
		int i = 0, j = str.length - 1;
		while (i < j) {
			char c = str[i];
			str[i] = str[j];
			str[j] = c;
			i++;
			j--;
		}
		return str;
	}
}
