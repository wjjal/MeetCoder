//Description
//You are given an array with N elements, can you check if it is almost sorted?
//
//An almost sorted array is an array that it can be 
//sorted by performing the following operations
//(just once, no repeating operations is allowed): 
//
//1. Swap two elements. 
//
//2. Reverse the elements of one sub-segment (sub-array)
//
//Input
//The input should be N non-negative integers, 
//where N should be less than or equal to 1,000,000. 
//Each integer should be less than or equal to 2,147,483,647.  
//
//Output
//The output should be "true" or "false". "true" 
//if the array is almost sorted. Otherwise it should be "false".
//
//Sample Input
//1 2 3 4 5
//Sample Output
//true
//HINT
//Linear Scan
//
//Source
//Medium

public class M31AlmostSortedArray {
	public static void main(String[] args) {
		int[] a = { 9, 2, 3, 1 };
		System.out.println(new M31AlmostSortedArray().isAlmostSorted(a));
	}

	public boolean isAlmostSorted(int[] a) {
		int len = a.length;
		int i = 0;
		while (i < len - 1 && a[i] <= a[i + 1])
			i++;
		if (i == len - 1)
			return true;
		int peek = i;
		i = peek + 1;
		while (i < len - 1 && a[i] <= a[i + 1])
			i++;
		i++;
		if (i < len && a[peek] >= a[i - 1]
				&& (peek == 0 || a[i] >= a[peek - 1]) && a[i] <= a[peek + 1]) {
			if (i == len - 1)
				return true;
			if (a[peek] <= a[i + 1]) {
				i++;
				while (i < len - 1 && a[i] <= a[i + 1])
					i++;
				if (i == len - 1)
					return true;
			}
		}

		i = peek;
		while (i < len - 1 && a[i] >= a[i + 1])
			i++;
		if (peek == 0 && i == len - 1)
			return true;
		int end = i;
		// peek到end间是一段降序序列
		i++;
		if (peek == 0 && a[0] <= a[end + 1]) {
			while (i < len - 1) {
				if (a[i] > a[i + 1])
					return false;
				i++;
			}
			return true;
		} else if (peek != 0 && a[end] >= a[peek - 1]
				&& (i >= len || a[peek] < a[i])) {
			while (i < len - 1) {
				if (a[i] > a[i + 1])
					return false;
				i++;
			}
			return true;
		}
		return false;
	}
}
