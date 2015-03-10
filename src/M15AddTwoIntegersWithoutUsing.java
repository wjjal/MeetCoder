//Description
//Write a function to add two integers without using any of the arithmetic operator, 
//like +.
//
//Input
//The input should be two non-negative integers less than 1,000,000,000.
//
//Output
//The result should be in the format of Integer.
//
//Sample Input
//2 3
//Sample Output
//5
//HINT
// Bit Operations
//
//Source
//Easy

public class M15AddTwoIntegersWithoutUsing {
	public static void main(String[] args) {
		System.out.println(new M15AddTwoIntegersWithoutUsing().aPlusb(999999999,
				999999999));
	}

	public int aPlusb(int a, int b) {
		if (b == 0)
			return a;
		int sum = a ^ b;
		int carry = (a & b) << 1;
		return aPlusb(sum, carry);
	}
}
