import java.util.HashMap;
import java.util.Map;

//Description
// Write a function to multiply two integers without 
//using any of the arithmetic operator, like *.
//
//Input
//The input should be two non-negative integers less than 1,000,000,000.
//
//Output
//The result should be in the format of Integer.
//
//Sample Input
//2 3
//Sample Output
//6
//HINT
//Bit Operations
//
//Source
//Easy

public class M14MultiplyTwoIntegersWithoutUsing {
	public static void main(String[] args) {
		System.out.println(new M14MultiplyTwoIntegersWithoutUsing().aMultiplyb_1(2,
				3));
	}

	public long aMultiplyb_1(int a, int b) {
		long x = a;
		long y = b;
		long re = 0;
		Map<Long, Integer> bitmap = new HashMap<Long, Integer>();
		for (int i = 0; i < 32; i++)
			bitmap.put((long) (1 << i), i);
		while (y > 0) {
			int lastbit = bitmap.get(y & ~(y - 1));
			re += x << lastbit;
			y &= y - 1;
		}
		return re;
	}

	public long aMultiplyb_2(int a, int b) {
		long x = a;
		long y = b;
		long re = 0;
		while (x > 0) {
			if ((x & 1) == 1)
				re += y;
			y <<= 1;
			x >>= 1;
		}
		return re;
	}
}
