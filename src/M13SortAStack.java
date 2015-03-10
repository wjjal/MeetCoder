import java.util.Stack;

//Description
//You are given a stack, write a program to sort the stack in ascending order, 
//meaning that the biggest element on the top. 
//You are allowed to have one additional stack to hold the elements, 
//but not allowed to copy the elements into any other data structures, 
//such as an array or a list or else. 
//
//Input
//The input should be a list of non-negative integers in the original stack 
//from bottom to top. Any integers in the stack should be less than 1,000,000,000. 
//And the length of the list should be less than or equal to 2,000.
//
//Output
//The output should be a sorted stack in ascending order.
//
//Sample Input
//5 8 7
//Sample Output
//8 7 5
//HINT
//Brute-force
//
//Source
//Easy

public class M13SortAStack {
	public static void main(String[] args) {
		Stack<Integer> s = new Stack<Integer>();
		s.push(5);
		s.push(8);
		s.push(7);
		new M13SortAStack().sortStack(s);
	}

	public Stack<Integer> sortStack(Stack<Integer> s) {
		Stack<Integer> tmp = new Stack<Integer>();
		while (!s.isEmpty()) {
			int cur = s.pop();
			while (!tmp.isEmpty() && cur < tmp.peek()) {
				s.push(tmp.pop());
			}
			tmp.push(cur);
		}
		return tmp;
	}
}
