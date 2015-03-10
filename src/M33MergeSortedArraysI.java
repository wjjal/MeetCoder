//Description
//You are given two sorted integer arrays A and B, merge B into A as one sorted array. 
//You may assume that A has enough space to hold additional elements from B. 
//The number of elements initialized in A and B are m and n, respectively.
//
//Input
//The input should be two sorted integer arrays A and B.
//
//Output
//The output should be one sorted array A. 
//You may assume that A has enough space to hold additional elements from B.
//
//Sample Input
//1 2 3
//4 5 6
//Sample Output
//1 2 3 4 5 6
//HINT
// Two Pointers
//
//Source
//Easy

public class M33MergeSortedArraysI {
	public int[] mergeSortedArray(int A[], int m, int B[], int n) {
		int i = m - 1, j = n - 1, k = m + n - 1;
		while (i >= 0 && j >= 0) {
			if (A[i] <= B[j])
				A[k--] = B[j--];
			else
				A[k--] = A[i--];
		}
		while (j >= 0) {
			A[k--] = B[j--];
		}
		return A;
	}
}
