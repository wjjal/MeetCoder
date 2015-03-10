//Description
//The classic Maximum SubArray problem is the task of finding the contiguous subarray 
//within a one-dimensional array of numbers which has the largest sum. 
//For example, for the sequence of values −2, 1, −3, 4, −1, 2, 1, −5, 4; 
//the contiguous subarray with the largest sum is 4, −1, 2, 1, with sum 6.
//
//Now we have a new problem based on the classic one - 
//finding the sum of the maximum sum subarray elements after performing a single swap 
//operation. For example, given an array {3, -10, 4, 5}, we can swap 3 and -10 to 
//get a maximum sum subarray {3, 4, 5}, which has the maximum sum 12.
//
//Input
//The input should be a list of integers with length N, 
//where N should be less than or equal to 1,000,000. 
//The absolute value of each integer of the list should be less than or equal to 1,000.
//
//Output
//The output should be the sum of the maximum sum subarray elements 
//after performing a single swap operation.
//
//Sample Input
//1 2 3 4 5 -1 9 7 8 6 
//Sample Output
//45
//HINT
//Dynamic Programming
//
//Source
//Hard

//First notice that if you are given some slice and you are asked to make it 
//better by doing a swap, its pointless to swap elements within the slice, 
//if we are going to swap we should always swap largest element not 
//in the slice with the smallest one in the slice (if this makes the sum larger 
//of course).
//
//Now how do we find the optimal sum?
//if we didnt do any swaps at all then this is just normal maximum sum subarray 
//which can be solved easily using divide and conquer or kadanes algorithm.
//if we can do one swap then we picked ith element not in the subarray and 
//swapped it with one element in the subarray, so the subarray could be completely to 
//it's left or completely to it's right (q<i or p>i).
//
//lets assume it's on it's left, now the problem becomes, for each i find 
//the maximum sum subarray that ends somewhere before i and 
//we delete one element from it.
//
//to solve such a problem define 
//f[i] = maximum subarray ending at ith position
//g[i] = maximum subarray ending at ith position with one element deleted.
//
//we have f[i]=max(f[i-1] + a[i], a[i])
//and g[i]=max(f[i-1], a[i]+g[i-1])
//now the result becomes max{a[i]+max{g[0],...,g[i-1]}
//
//we've have to run the algorithm on the array and 
//it's reverse in order to handle the other case.

public class M49MaximumSumSubArrayWithSingleSwap {
	public static void main(String[] args) {
		int[] A = {1,2,3,4};
		System.out.println(new M49MaximumSumSubArrayWithSingleSwap()
				.getMaxSubarraySum(A));
	}

	public int getMaxSubarraySum(int[] A) {
		int len = A.length;
		int[] B = new int[len];
		int nodelsum = Integer.MIN_VALUE;
		int tmp = 0;
		for (int i = 0; i < len; i++) {
			B[i] = A[len - 1 - i];
			tmp += A[i];
			nodelsum = Math.max(nodelsum, tmp);
			tmp = Math.max(tmp, 0);
		}
		return Math.max(nodelsum,
				Math.max(findMaxWithASwap(A), findMaxWithASwap(B)));
	}

	private int findMaxWithASwap(int[] a) {
		int n = a.length;
		int[] f = new int[n];
		int[] g = new int[n];
		f[0] = a[0];
		g[0] = 0;
		int re = Integer.MIN_VALUE;
		for (int i = 1; i < n; i++) {
			f[i] = Math.max(a[i], f[i - 1] + a[i]);
			g[i] = Math.max(f[i - 1], g[i - 1] + a[i]);
		}
		int gmax = g[0];
		for (int i = 1; i < n; i++) {
			gmax = Math.max(gmax, g[i - 1]);
			re = Math.max(re, a[i] + gmax);
		}
		return re;
	}
}
