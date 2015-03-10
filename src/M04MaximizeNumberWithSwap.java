//Description
//Given an integer, find the maximum integer by swapping any two digits.
//
//Input
//The input should be a non-negative integer less than 1010.
//
//Output
//The result should be in the format of Integer.
//
//Sample Input
//102
//Sample Output
//201
//HINT
//Brute-force
//
//
//Source
//Easy

public class M04MaximizeNumberWithSwap {
	public int maximizeResult(int n) {
		int[] digits = new int[9];
		int len = 0;
		while (n > 0) {
			digits[len++] = n % 10;
			n /= 10;
		}
		for (int i = len - 1; i > 0; i--) {
			int num = digits[0];
			int index = 0;
			for (int j = 1; j < i; j++) {
				if (digits[j] > num) {
					index = j;
					num = digits[j];
				}
			}
			if (num > digits[i]) {
				digits[index] = digits[i];
				digits[i] = num;
				break;
			}
		}
		int re = 0;
		for (int i = len - 1; i >= 0; i--)
			re = re * 10 + digits[i];
		return re;
	}
}
