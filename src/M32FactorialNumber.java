//Description
//You are given an integer N, find the smallest integer M that M! 
//contains at least N trailing zeros.
//
//Input
//The input should be a positive integer N less than or equal to 1017.
//
//Output
//The output should be the smallest integer M that M! contains at least N trailing zeros.
//
//Sample Input
//1
//Sample Output
//5
//HINT
// Binary Search & Number Theory 
//
//Source
//Medium

public class M32FactorialNumber {
	public static void main(String[] args) {
		System.out.println(new M32FactorialNumber().findM((long) Math.pow(10,
				17)));
	}

	public long findM(long n) {
		long start = 0;
		long end = Long.MAX_VALUE;
		while (start < end) {
			long mid = start + (end - start) / 2;
			long num = calFactorial(mid);
			if (num == n) {
				if (mid % 10 <= 4)
					return mid / 10 * 10;
				else
					return mid / 10 * 10 + 5;
			} else if (num < n)
				start = mid + 1;
			else {
				end = mid;
			}
		}
		if (end % 10 <= 4)
			return end / 10 * 10;
		else
			return end / 10 * 10 + 5;
	}

	private long calFactorial(long a) {
		long re = 0;
		while (a > 0) {
			re += a / 5;
			a /= 5;
		}
		return re;
	}
}
