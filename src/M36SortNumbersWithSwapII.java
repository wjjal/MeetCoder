//Description
//You are given a random permutation from all possible permutations of integers 
//from 0 to N - 1, find the minimum number of the 0-Swap to sort the permutation. 
//A 0-Swap means swaping 0 with any other integers.
//
//Input
//The input should be a permutation of integers from 0 to N - 1, 
//where N should be less than or equal to 100,000.
//
//Output
//The output should be the minimum number of 0-Swap to sort the permutation.
//
//Sample Input
//2 1 0
//Sample Output
//1
//HINT
//Count Circle
//
//Source
//Medium

public class M36SortNumbersWithSwapII {
	public static void main(String[] args) {
		int[] a = { 4, 0, 2, 1, 3 };
		System.out.println(new M36SortNumbersWithSwapII().sortWithSwap(a));
	}

	public int sortWithSwap(int[] a) {
		int len = a.length;
		int hash[] = new int[len];
		int re = len;
		for (int i = 0; i < len; i++) {
			if (hash[a[i]] == 1)
				continue;
			if (a[i] == i) {
				hash[a[i]] = 1;
				re--;
				continue;
			}
			int start = i;
			int x = i;
			hash[x] = 1;
			while (true) {
				x = a[x];
				hash[x] = 1;
				if (x == start)
					break;
			}
			if (start == 0)
				re--;
			else
				re++;
		}
		return re;
	}
}
