//Description
//You are given a non-negative integer N, find the last non-zero digit of N!.
//
//Input
//The input should be a non-negative integer N less than or equal to 1,000,000.
//
//Output
//The output should be the last non-zero digit of N!.
//
//Sample Input
//5
//Sample Output
//2
//HINT
//Brute-force.
//
//
//Source
//Easy

public class M08FindLastNonZeroDigitOfFactorial {
	public static void main(String[] args) {
		System.out.println(new M08FindLastNonZeroDigitOfFactorial().lastDigit(10));
	}

	public int lastDigit(int n) {
		int re = 1;
		int n5 = 0;
		int t = n;
		while (t >= 5) {
			n5 += t / 5;
			t /= 5;
		}
		for (int i = 1; i <= n; i++) {
			t = i;
			while (n5 > 0 && t % 2 == 0) {
				n5--;
				t /= 2;
			}
			while (t % 5 == 0)
				t /= 5;
			re = ((t % 10) * re) % 10;
		}

		return re;
	}
}
