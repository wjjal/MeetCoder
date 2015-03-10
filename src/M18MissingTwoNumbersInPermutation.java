//Description
//If exactly two numbers are missing in a permutation of integers from 1 to n, 
//how would you find them efficiently?
//
//Input
//The input should be a list of exactly (n - 2) numbers, where n > 2. 
//And the numbers should be a permutation of integers from 1 to n 
//except the two missing distinct numbers, 
//where n should be less than or equal to 1,000,000.
//
//Output
//The output should be the two missing numbers in ascending order.
//
//Sample Input
//3 4 5 1 2
//Sample Output
//6 7
//HINT
//Math or Bit Operations
//
//Source
//Easy

public class M18MissingTwoNumbersInPermutation {
	public static void main(String[] args) {
		int[] a = { 3, 4, 5, 1, 7 };
		int[] re = new M18MissingTwoNumbersInPermutation().missing2Numbers(a);
		for (int i : re)
			System.out.println(i);
	}

	int[] missing2Numbers(int[] a) {
		int re[] = new int[2];
		int n = a.length + 2;
		int x = n;
		for (int i = 1; i < n; i++)
			x ^= i;
		System.out.println(x);
		for (int i : a)
			x ^= i;
		// int diff = x&(-x);
		int diff = x & (x ^ (x - 1));
		int p = 0, q = 0;
		for (int i = 1; i <= n; i++) {
			if ((i & diff) != 0)
				p ^= i;
			else
				q ^= i;
		}
		for (int i : a) {
			if ((i & diff) != 0)
				p ^= i;
			else
				q ^= i;
		}
		if (p > q) {
			p = p ^ q;
			q = p ^ q;
			p = p ^ q;
		}
		re[0] = p;
		re[1] = q;
		return re;
	}
}
