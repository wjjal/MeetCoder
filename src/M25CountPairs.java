import java.util.Arrays;
import java.util.Comparator;

//Description
//You are given n circles centered on Y-aixs. 
//The ith circle¡¯s center is at point (i, 0) and its radius is A[i]. 
//Count the number of pairs of circles that have at least one common point?
//
//Input
//The input should be a list of n positive integers A, 
//each of them should be less than or equal to 1,000,000,000 
//and n should be less than or equal to 100,000.
//
//Output
//The output should be the number of pairs of circles that have 
//at least one common point in the format of Integer.
//
//Sample Input
//1 2 3
//Sample Output
//3
//HINT
// Sort & Count
//
//Source
//Medium

public class M25CountPairs {
	public static void main(String[] args) {
		int a[] = { 1, 2, 3 ,1};
		System.out.println(new M25CountPairs().countPairs(a));
	}

	class Line {
		int start;
		int end;

		public Line(int a, int b) {
			this.start = a;
			this.end = b;
		}
	}

	long countPairs(int[] A) {
		int len = A.length;
		Line[] ls = new Line[len];
		for (int i = 0; i < len; i++) {
			ls[i] = new Line(i - A[i], i + A[i]);
		}
		Arrays.sort(ls, new Comparator<Line>() {
			public int compare(Line l1, Line l2) {
				return l1.start - l2.start;
			}
		});
		long re = 0;
		for (int i = 0; i < len - 1; i++) {
			int key = ls[i].end;
			int j = binarySearch(ls, key, i + 1, len - 1);
			re += j - i;
		}
		return re;
	}

	private int binarySearch(Line[] ls, int key, int begin, int end) {
		if (ls[end].start <= key)
			return end;
		while (begin < end) {
			int mid = begin + (end - begin) / 2;
			if (ls[mid].start > key)
				end = mid;
			else
				begin = mid + 1;
		}
		return end - 1;
	}
}
