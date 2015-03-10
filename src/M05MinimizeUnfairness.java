import java.util.Arrays;

//Description
//You are given a list of N integers, 
//the goal is to minimize the unfairness by selecting K integers from the list.
//
//The unfairness is defined as following:
//
//Max(x1,x2,…,xk) − Min(x1,x2,…,xk)
//
//where (x1,x2,x3,…,xk) are K numbers selected from the list N, 
//and the Max() picks the greatest integer among the elements of K, 
//and the Min() picks the smallest integer among the elements of K.
//
//Input
//The input should include two lines. 
//The first line should be a list of N non-negative integers 
//less than or equal to 1,000,000,000, where 0 < N <= 100,000. 
//And the second line should be K, where 2 <= K <= N.
//
//Output
//The result should be the number of minimum unfairness.
//
//Sample Input
//10 100 300 200 1000 20 30
//3
//Sample Output
//20
//HINT
//Sort & Greedy
//
//Source
//Easy

public class M05MinimizeUnfairness {
	public int minimizeUnfairness(int[] a, int k) {
		Arrays.sort(a);
		if (k > a.length)
			return a[a.length - 1] - a[0];
		int re = Integer.MAX_VALUE;
		for (int i = 0; i <= a.length - k; i++) {
			re = Math.min(re, a[i + k - 1] - a[i]);
		}
		return re;
	}
}
