import java.util.Arrays;

//Description
//You are given a non-empty zero-based indexing array A that consists of N integers, 
//count the number of the triangle triple indexes.
//
//A triangle triple index is a triple of integers ( 0 <= P < Q < R < N ) that is 
//defined as follows: 
//
//A[P] + A[Q] > A[R] 
//
//A[p] + A[R] > A[Q] 
//
//A[Q] + A[R] > A[P]
//
//Input
//The input should be a list of N non-negative integers less than 1,000,000, 
//where N should be less than or equal to 1,000.
//
//Output
//The output should be the number of the triangle triple index.
//
//Sample Input
//1 2 3 4
//Sample Output
//1
//HINT
//Sort & Scan
//
//Source
//Easy

public class M09CountTriangleTripleIndex {
	int countTriangleTripleIndex(int[] A) {
		int len = A.length;
		int re = 0;
		Arrays.sort(A);
		for (int i = 0; i < len - 2; i++) {
			for (int j = i + 1; j < len - 1; j++) {
				for (int k = j + 1; k < len; k++) {
					if (A[i] + A[j] > A[k])
						re++;
				}
			}
		}
		return re;
	}
}
