//Description
//There is an ideal random number generator, which given a positive integer 
//M can generate any real number between 0 to M, and probability density function is 
//uniform in [0, M].
//
//Suppose we generate 2 numbers x and y via the generator by 
//giving it 2 positive integers A and B, what is the probability that 
//x + y is less than C? where C is a positive integer.
//
//Input
//The first line of the input is an integer N, the number of test cases. 
//N lines follow. Each line contains 3 positive integers a, b and c, 
//where should be less than or equal to 10,000.
//
//Output
//For each output, output a fraction that indicates the probability. 
//The greatest common divisor of each pair of numerator and denominator should be 1.
//
//Sample Input
//1 1 1
//Sample Output
//1 2
//HINT
//Area Calculate
//
//Source
//Medium

public class M48CalculateProbability {
	public static void main(String[] args) {
		int re[] = new M48CalculateProbability().calculate(4, 4, 5);
		for (int i : re)
			System.out.println(i);
	}

	public int[] calculate(int a, int b, int c) {
		int[] re = new int[2];
		if (c >= a + b) {
			re[0] = 1;
			re[1] = 1;
			return re;
		}
		if (a > b)
			return calculate(b, a, c);
		if (c <= a && c <= b) {
			int div = gcd(c * c, a * b * 2);
			re[0] = c * c / div;
			re[1] = a * b * 2 / div;
		} else if (c > a && c <= b) {
			int div = gcd(a * (c - a) * 2 + a * a, a * b * 2);
			re[0] = (a * (c - a) * 2 + a * a) / div;
			re[1] = a * b * 2 / div;
		}
		// c>a && c>b
		else {
			int div = gcd(a * b * 2 - (a + b - c) * (a + b - c), a * b * 2);
			re[0] = (a * b * 2 - (a + b - c) * (a + b - c)) / div;
			re[1] = a * b * 2 / div;
		}
		return re;
	}

	private int gcd(int m, int n) {
		int next = 0;
		if (n == 0)
			return m;
		else {
			next = m % n;
			return gcd(n, next);
		}
	}
}
