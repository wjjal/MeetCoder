//Description
//You are given a magic board A that consists of N rows and M columns. 
//You are only allowed to cover the magic board using the square tiles of 1 * 1 
//and 2 * 2. The tiles cannot overlap each other and any part of the tile cannot 
//be out of the border of the magic board. Find the number of ways that 
//you can cover the whole magic board.
//
// 
//
//Input
//The input should be two positive integers N and M, where N should be 
//within [1...1,000,000] and M should be within [0...7].
//
//Output
//The output should be the number of ways to cover the whole magic board. 
//Since the output result could be very large, please output 
//the answer “modulo 1,000,000,007 (109 + 7)”.
//
//Sample Input
//4 3
//Sample Output
//11
//HINT
//Matrix Power
//
//
//Source
//Hard

public class M39CoverTheMagicBoard {
	public static void main(String[] args) {
		System.out.println(new M39CoverTheMagicBoard().coverBoard(2, 7));
	}

	public int coverBoard(int N, int M) {
		if (M == 0 || N == 0)
			return 0;
		int states = 1 << M;
		int a[][] = new int[states][states];
		int re[][] = new int[states][states];
		// 初始化re[0][i][i]为单位矩阵
		for (int i = 0; i < states; i++)
			re[i][i] = 1;
		for (int j = 0; j < states; j++) {
			cal(a, M, 0, j, 0);
		}
		while (N > 0) {
			if ((N & 1) == 1) {
				re = multiply(re, a);
			}
			a = multiply(a, a);
			N >>= 1;
		}
		return re[0][0];
	}

	private void cal(int[][] a, int n, int col, int laststate, int nowstate) {
		if (col >= n - 1) {
			a[laststate][nowstate]++;
			return;
		}
		// 用1*1的填
		cal(a, n, col + 1, laststate, nowstate);
		if (((laststate >> col) & 1) == 0
				&& ((laststate >> (col + 1)) & 1) == 0) {
			// 用2*2的填
			cal(a, n, col + 2, laststate, nowstate | (3 << col));
		}
	}

	private int[][] multiply(int[][] a, int[][] b) {
		int m = a.length;
		int[][] c = new int[m][m];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < m; j++) {
				c[i][j] = 0;
				for (int k = 0; k < m; k++) {
					c[i][j] += mul(a[i][k], b[k][j]);
					if (c[i][j] >= 10000007)
						c[i][j] -= 10000007;
				}
			}
		}
		return c;
	}

	private int mul(long i, long j) {
		return (int) (i * j % 10000007);
	}
}
