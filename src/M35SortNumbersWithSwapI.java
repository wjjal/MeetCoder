//Description
//You are given a random permutation from all possible permutations of integers 
//from 0 to N - 1, find the minimum number of the 2-Swap to sort the permutation. 
//A 2-Swap means swaping any two integers at one time.
//
//Input
//The input should be a permutation of integers from 0 to N - 1, 
//where N should be less than or equal to 100,000.
//
//Output
//The output should be the minimum number of 2-Swap to sort the permutation.
//
//Sample Input
//2 1 0
//Sample Output
//1
//HINT
// Count Circle
//
//Source
//Medium

public class M35SortNumbersWithSwapI {
	public static void main(String[] args){
		int[] a = {0,4,2,1,3};
		System.out.println(new M35SortNumbersWithSwapI().sortWithSwap(a));
	}
	
	public int sortWithSwap(int[] a) {
		int len = a.length;
		int hash[] = new int[len];
		int re = len;
		for (int i = 0; i < len; i++) {
			if (hash[a[i]] == 1)
				continue;
			int start = i;
			int x = i;
			hash[x] = 1;
			while (true) {
				x = a[x];
				hash[x] = 1;
				if (x == start)
					break;
			}
			re--;
		}
		return re;
	}
}
