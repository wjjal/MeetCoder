//Description
//You are given two numbers A and B, count the number of bits that needed to be 
//flipped to convert A to B.
//
//Input
//The input should be two non-negative integers x and y that less than 1,000,000,000.
//
//Output
//The output should be the number of bits needed to be flipped to convert x to y. 
//It should be in the format of Integer.
//
//Sample Input
//2 3
//Sample Output
//1
//HINT
//Bit Operations
//
//Source
//Easy

public class M16IntegersConversion {
	public static void main(String[] args) {
		System.out.println(new M16IntegersConversion().countConversions(2, 3));
	}

	public int countConversions(int x, int y) {
		int diff = x ^ y;
		int re = 0;
		while (diff > 0) {
			re++;
			diff &= diff - 1;
		}
		return re;
	}
}
