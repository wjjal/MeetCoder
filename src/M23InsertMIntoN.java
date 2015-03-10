//Description
//You are given two 32-bit numbers,N and M, and two bit positions, i and j. 
//Write a method to insert M into N such that M starts at bit j and ends at bit i. 
//You can assume that the bits j through i have enough space to fit all of M. That is, 
//if M=10011, you can assume that there are at least 5 bits between j and i. 
//You would not, for example, have j=3 and i =2, 
//because M could not fully fit between bit 3 and bit 2.
//
//Input
//The input should be four non-negative integers. 
//The 1st and 2nd integers should be n and m, where they should be less than 1,000,000,000.  The 3rd and 4th integers should be i and j, where m can be fit into (j - i + 1) bits. Both n and m should be treated as 32-bit integer.
//
//Output
//The output should be in the format of Integer.
//
//Sample Input
//7 5 1 3
//Sample Output
//11
//HINT
//Bit Operation
//
//Source
//Easy

public class M23InsertMIntoN {
	public static void main(String[] args) {
		System.out.println(new M23InsertMIntoN().updateBits(7, 5, 1, 3));
	}

	public int updateBits(int n, int m, int i, int j) {
		int left = (n >> (j + 1)) << (j + 1);
		int right = (1 << (i - 1)) & n;
		int mid = m << i;
		return left + mid + right;
	}
}
