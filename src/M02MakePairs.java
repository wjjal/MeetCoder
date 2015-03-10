import java.util.Arrays;

//Description
//You are given two equal length lists of integers A and B,  
//and an integer K. How would you pair each element of A with 
//each element of B (i.e. 1-to-1 match NOT 1-to-n or n-to-1 match) 
//so that the sum of each pair is greater than or equal to K?
//
//Input
//The input should include two parts. The first part should be 
//two lists of non-negative integers A and B. Each of integers 
//in the given lists should be less than or equal to 109. 
//The length of each of the two lists should be less than or equal to 1,000. 
//The second part should be a non-negative integer K, 
//where K should be less than or equal to 109. 
//
//Output
//The output should be "true" or "false". 
//¡°true¡± if you can pair each element of A with each element of B 
//(i.e. 1-to-1 match NOT 1-to-n or n-to-1 match) 
//so that the sum of each pair is greater than or equal to K. 
//Otherwise it should be "false".
//
//Sample Input
//1 2 3
//4 5 6
//7
//Sample Output
//true
//HINT
//Sort & Greedy
//
//
//Source
//Easy

public class M02MakePairs {
	public boolean makePair(int[] a, int[] b, int k) {
		int len = a.length;
		Arrays.sort(a);
		Arrays.sort(b);
		for (int i = 0; i < len; i++) {
			if (a[i] + b[len - 1 - i] < k)
				return false;
		}
		return true;
	}
}
