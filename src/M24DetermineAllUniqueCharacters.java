import java.util.Arrays;

//Description
//You are given a string, check if all its elements are unique. 
//It means, there are no repeated characters.
//
//For example: HELLO -> not all its characters are 
//unique since character ¡®L¡¯ appears twice.
//
//WORLD -> has all unique characters.
//
//This problem has many possible solutions, and to make it more interesting 
//let¡¯s suppose we are not allowed to use any extra data structure 
//(a few extra variables are allowed but an entire copy of the array is not).
//
//Input
//The input should be in the format of string of letters in English.
//
//Output
//The output shoud be "true" if the string has all unique characters. 
//Otherwise it should be "false".
//
//Sample Input
//adca
//Sample Output
//false
//HINT
//Sort
//
//
//Source
//Easy

public class M24DetermineAllUniqueCharacters {
	public boolean hasUniqueCharacters(char[] str) {
		int len = str.length;
		if (len == 0)
			return true;
		Arrays.sort(str);
		char c = str[0];
		for (int i = 1; i < len; i++) {
			if (str[i] == c)
				return false;
			c = str[i];
		}
		return true;
	}
}
