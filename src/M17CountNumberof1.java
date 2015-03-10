//Description
//You are given an integer, count number of 1's in binary representation.
//
//Input
//The input should be a non-negative integer less than 1,000,000,000.
//
//Output
//The output should be the number of 1's in binary representation.
//
//Sample Input
//3
//Sample Output
//2
//HINT
// Bit Operations
//
//Source
//Easy
public class M17CountNumberof1 {
	public int count1(int x) {
		int re = 0;
		while (x > 0) {
			x &= x - 1;
			re++;
		}
		return re;
	}
}
