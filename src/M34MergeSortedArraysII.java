import java.util.Comparator;
import java.util.PriorityQueue;

//Description
//You are given K sorted arrays, merge them into one sorted array A. 
//You may assume that A has enough space to hold additional elements from K sorted arrays. 
//The number of K initialized in the first line of input.
//
//Input
//The first line of input should be the number of K, 
//where K should be less than or equal to 1,000. 
//
//The rest lines of input should be the K sorted arrays, 
//each integer in the arrays should be non-negative and less than or 
//equal to 2,147,483,647. 
//And the total number of integers should be less than or equal to 1,000,000.
//
//Output
//The output should be the sorted array of integers a. 
//You may assume that a has enough space to hold additional elements from K sorted arrays.
//
//Sample Input
//5
//1
//2
//2
//1
//3
//Sample Output
//1 1 2 2 3
//HINT
//Merge Sort
//
//Source
//Medium

public class M34MergeSortedArraysII {
	public static void main(String[] args) {
		int[][] a = { { 5 }, { 1, 3 }, { 2 }, { 2 }, { 1 },
				{ 3, 4, 5, 6, 7, 78 } };
		int[] A = new M34MergeSortedArraysII().mergeSortedArrays(a);
		for (int i : A) {
			System.out.print(i + " ");
		}
	}

	class Node {
		int val;
		int arnum;
		int index;

		public Node(int val, int arrnum, int index) {
			this.val = val;
			this.arnum = arrnum;
			this.index = index;
		}
	}

	int[] mergeSortedArrays(int[][] a) {
		int k = a.length;
		int len[] = new int[k];
		PriorityQueue<Node> q = new PriorityQueue<Node>(k,
				new Comparator<Node>() {
					public int compare(Node a, Node b) {
						if (a.val > b.val)
							return 1;
						else if (a.val == b.val)
							return 0;
						else
							return -1;
					}
				});
		int sumlen = 0;
		for (int i = 0; i < k; i++) {
			len[i] = a[i].length;
			sumlen += a[i].length;
			q.add(new Node(a[i][0], i, 0));
		}
		int[] A = new int[sumlen];
		int i = 0;
		while (q.size() > 0) {
			Node cur = q.poll();
			A[i++] = cur.val;
			if (cur.index < len[cur.arnum] - 1)
				q.add(new Node(a[cur.arnum][cur.index + 1], cur.arnum,
						cur.index + 1));
		}
		return A;
	}
}
