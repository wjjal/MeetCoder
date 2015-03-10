//Description
//You are given a string, implement a method to perform basic string compression 
//using the counts of repeated characters. 
//For example, the string aabcccccaaa would become a2blc5a3. 
//If the "compressed" string would not become smaller than the original string, 
//your method should return the original string.
//
//Input
//The input should be in form of String.
//
//Output
//The input should be in form of String.
//
//Sample Input
//aabcccccaaa
//Sample Output
//a2b1c5a3
//HINT
//Linear Scan
//
//Source
//Easy

public class M47StringCompression {
	public String compressString(String str) {
		int len = str.length();
		if (len <= 1)
			return str;
		StringBuffer sb = new StringBuffer();
		char last = str.charAt(0);
		int count = 1;
		for (int i = 1; i < len; i++) {
			if (str.charAt(i) == last) {
				count++;
			} else {
				sb.append(last);
				sb.append(count);
				last = str.charAt(i);
				count = 1;
			}
		}
		sb.append(last);
		sb.append(count);
		String cs = sb.toString();
		return cs.length() < str.length() ? cs : str;
	}
}
