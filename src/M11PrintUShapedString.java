//Description
// You are given a string S of length N, print it into a U shaped string.
//
//To do this, we follow the rules:
//
//(a) The characters should be printed in the original order, 
//starting top-down from the left vertical line with n1 characters, 
//then left to right along the bottom line with n2 characters, 
//and finally bottom-up along the vertical line with n3 characters.
//
//(b) And more, we would like U to be as squared as possible, 
//meaning that it should follow the rule below:
//
//n1 = n3 = max { k| k <= n2 for all 3 <= n2 <= N } with n1 + n2 + n3 - 2 = n.
//
//For example, the word ¡°helloworld¡± should be printed like this below:
//
//h     d
//
//e     l
//
//l      r
//
//lowo
//
//Input
// The input should be a string contains of lower-case letters only. 
//The length of the string should be in [5..99].
//
//Output
// The output should be in the format of String with mutiple lines. 
//For exaplem, the first line of output of "helloworld" should be "h  d", the second line should be "e  l", the third line should be "l  r" and the last line should be "lowo".
//
//Sample Input
//helloworld
//Sample Output
//h  d
//e  l
//l  r
//lowo
//HINT
// Just do it :-)
//
//Source
//Medium
public class M11PrintUShapedString {
	public static void main(String[] args) {
		String[] ss = new M11PrintUShapedString().uFormat("helloworld");
		for (String s : ss)
			System.out.println(s);
	}

	String[] uFormat(String s) {
		int len = s.length();
		int high = (len + 2) / 3;
		int wide = len + 2 - 2 * high;
		String[] re = new String[high];
		String black = "";
		for (int i = 0; i < wide - 2; i++)
			black += " ";
		for (int i = 0; i < high - 1; i++) {
			re[i] = s.substring(i, i + 1) + black
					+ s.substring(len - 1 - i, len - i);
		}
		re[high - 1] = s.substring(high - 1, high - 1 + wide);
		return re;
	}
}
