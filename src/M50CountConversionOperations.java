//Description
//You are given an integer n, count the minimum number of operations that 
//changing x into n.
//
//To do this, in each step you are allowed to do one of the following operations we. 
//In other words, you are allowed to operate either (a) or (b) in every step 
//when you convert x into n. Suppose x starts at 0.
//
//(a) x = x * 2
//
//(b) x = x + 1
//
// 
//Input
//The input should be a non-negative integer n less than or equal to 2,147,483,647
//
//Output
//The output should be the minimum number of operations that changing x into n.
//
//Sample Input
//5
//Sample Output
//4
//HINT
//Bit Operation
//
//
//Source
//Easy

public class M50CountConversionOperations {
	public int countOperations(int n) {
		if (n <= 1)
			return n;
		int re = 1;
		while (n > 1) {
			if ((n & 1) == 1)
				re += 2;
			else
				re++;
			n >>= 1;
		}
		return re;
	}
}
