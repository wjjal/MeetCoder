//Description
//Write a function to swap odd and even bits in an integer with 
//as few instructions as possible. For example, bit-0 and bit-1 are swapped, 
//bit-2 and bit-3 are swapped, and so on.
//
//Input
//The input should be a single non-negative integer x less than 1,000,000,000.
//
//Output
//The output should be in the format of Integer.
//
//Sample Input
//2
//Sample Output
//1
//HINT
//Bit Operation
//
//Source
//Easy
public class M22SwapOddAndEvenBits {
	public static void main(String[] args) {
		System.out.println(new M22SwapOddAndEvenBits().swapOddEvenBits(2));
	}

	public int swapOddEvenBits(int x) {
		int a = x >> 1;
		int b = x << 1;
		int re = 0;
		for (int i = 0; i < 32; i++) {
			if ((i & 1) == 0)
				re += (1 << i) & a;
			else
				re += (1 << i) & b;
		}
		return re;
	}
}
