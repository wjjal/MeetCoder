import java.util.LinkedList;

//Description
//You are given an array of integers,
//find the length of the shortest sequence you need to 
//sort to make all the elements of the array in order. 
//A shortest sequence is a minimum unsorted sub-array indices M and N 
//so that the entire array would be sorted if you sort elements M through N.
//
//Input
//The input should be N non-negative integers, 
//where N should be less than 100,000. 
//Each integer should be less than or equal to 2,147,483,647.
//
//Output
//The output should be the length of the shortest sequence.
//
//Sample Input
//1 2 5 4 6
//Sample Output
//2
//HINT
//Linear Scan
//
//
//Source
//Medium

public class M29FindLengthOfShortestSequence {
	public static void main(String[] args) {
		int[] a = { 1, 2, 4, 5, 6 };
		System.out.println(new M29FindLengthOfShortestSequence()
				.getShortestSequenceLength(a));
	}

	public int getShortestSequenceLength(int[] a) {
		int len = a.length;
		if (len == 0)
			return 0;
		LinkedList<Integer> qh = new LinkedList<Integer>();
		LinkedList<Integer> qt = new LinkedList<Integer>();
		int i = 0;
		while (i < len && (qh.isEmpty() || a[i] >= qh.peek())) {
			qh.push(a[i++]);
		}

		while (i < len) {
			while (!qh.isEmpty() && qh.peek() > a[i]) {
				qh.pop();
			}
			i++;
		}
		int j = len - 1;
		while (j >= 0 && (qt.isEmpty() || a[j] <= qt.peek())) {
			qt.push(a[j--]);
		}
		while (j >= 0) {
			while (!qt.isEmpty() && qt.peek() < a[j]) {
				qt.pop();
			}
			j--;
		}
		return Math.max(0, len - (qh.size() + qt.size()));
	}
}
