//Description
// You are given an integer N, count "0 xor 1 xor 2 xor......xor N".
//
//Input
// The input should be a non-negative integer x less than 1018 
//(1,000,000,000,000,000,000).
//
//Output
// The output should be the XOR sum in the format of Integer.
//
//Sample Input
//3
//Sample Output
//O
//HINT
// Bit Operation & Count
//
//Source
//Easy

public class M20XORSum {
	public static void main(String[] args) {
		System.out.println(new M20XORSum().xorSum(100));
	}

	public long xorSum(long x) {
		long re = 0;
		long i = 1L << 62;
		while (x > 3) {
			if ((x & i) != 0) {
				if (((x - i + 1) & 1) == 1)
					re += i;
				x ^= i;
			}
			i >>= 1;
		}
		if (x == 2)
			re += 3;
		else if (x == 1)
			re += 1;
		return re;
	}
}
