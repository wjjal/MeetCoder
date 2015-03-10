//Description
//Given a sorted array A of distinct integers,  
//find a magic index if it exists in array A.  
//
//A magic index in an array A[0¡­n-l] is defined as an index so that A[i] = i. 
//
//Input
//The input should be a list of N integers, where N is less than or equal to 10,000. 
//The absolute values of all intergers should be less than 1,000,000,000.
//
//Output
//The output should be the first magic index if it exists.
//Otherwise the output should be -1.
//
//Sample Input
//0 1 2
//Sample Output
//O
//HINT
//Binary Search
//
//Source
//Easy

public class M12FindMagicIndex {
	public static void main(String[] args) {
		int[] A = { 0, 1, 2, 3 };
		System.out.println(new M12FindMagicIndex().getMagicIndex(A));
	}

	public int getMagicIndex(int[] A) {
		int len = A.length;
		int start = 0, end = len - 1;
		int re = -1;
		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (A[mid] == mid)
				re = mid;
			if (A[mid] >= mid)
				end = mid - 1;
			if (A[mid] < mid)
				start = mid + 1;
		}
		return re;
	}
}
