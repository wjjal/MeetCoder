//Description
//You are given a very large integer, read implementation of 
//calculating the sum of digits.
//
//Input
//The input should be a non-negative integer less than 10100.
//
//Output
// The result should be in the format of String with 
//{"zero","one","two","three","four","five","six","seven","eight","nine"}
//
//Sample Input
//987654321
//Sample Output
//four five
//HINT
// Brute-force 
//
//Source
//Easy

public class M01ReadSumOfDigits {
	public String readSum(String n) {
		String[] val = { "zero", "one", "two", "three", "four", "five", "six",
				"seven", "eight", "nine" };
		int len = n.length();
		int sum = 0;
		String re = "";
		for (int i = 0; i < len; i++)
			sum += n.charAt(i) - '0';
		if (sum == 0)
			return val[0];
		while (sum > 0) {
			re = val[sum % 10] + " " + re;
			sum /= 10;
		}
		return re.substring(0, re.length() - 1);
	}
}
