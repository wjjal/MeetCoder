//Description
//You are given an integer n, write a function that returns count of trailing zeroes 
//in n!.
//
//Input
//The input should be a non-negative integer less than or equal to 1,000,000,000.
//
//Output
//The output should be the number of trailing zeros in n!.
//
//Sample Input
//5
//Sample Output
//1
//HINT
//Number Theory
//
//Source
//Easy

public class M30CountTrailingZeros {
	public int countTrailingZeros(int n) {
		int re = 0;
		while (n >= 5) {
			re += n / 5;
			n = n / 5;
		}
		return re;
	}
}
