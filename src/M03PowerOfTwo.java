//Description
//You are given an integer, how would you check if it is a power of 2 efficiently? 
//In mathematics, a power of two means a number of the form 2n where n is an integer.
//
//Input
//The input should be a non negative integer less than 109. 
//
//Output
//The output should be in the format of "true" or "false". 
//
//Sample Output
//false
//HINT
// Bit Operation
//
//Source
//Easy

public class M03PowerOfTwo {
	public boolean isPowerOf2_1(int n) {
		int num = 0;
		while (n > 0) {
			num += n & 1;
			n >>= 1;
		}
		if (num == 1)
			return true;
		return false;
	}

	public boolean isPowerOf2_2(int n) {
		if (n <= 0)
			return false;
		n = n & (n - 1);
		if (0 != n)
			return false;
		return true;
	}
}
