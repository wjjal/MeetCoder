import java.math.*;

//Description
//We have a country containing N cities with no road between any two cities 
//(what a poor country). Each day we choose two cities such that there is no road 
//between them and build a road between them. 
//We choose each pair of non-connected cities with equal probability. 
//What is the expected number of days until we obtain a connected country?
//
//Input
//The input should be a positive integer n less than or equal to 30.
//
//Output
//The output should be in the format of Integer.
//
//Sample Input
//2
//Sample Output
//1
//HINT
//Dynamic Programming & Math & Graph Theory
//
//
//Source
//Hard
public class M38ConnectedGraph {
	public static void main(String[] args) {
		int n = 3;
		System.out.println(new M38ConnectedGraph().lookup(n));
		System.out.println(new M38ConnectedGraph().connectThem(n));
		// for(int i =1;i<=30;i++){
		// if(new M38ConnectedGraph().lookup(i)!=new
		// M38ConnectedGraph().connectThem(i))
		// System.out.println(i);
		// }
	}

	public int lookup(int n) {
		double[] s_lookup = { 0.0, 0.0, 1.0, 2.0, 3.19978, 4.5459, 6.008007,
				7.559594, 9.182976, 10.888991, 12.6469, 14.460199, 16.332187,
				18.244103, 20.213585, 22.200205, 24.231776, 26.309512,
				28.443352, 30.579131, 32.727322, 34.95471, 37.167871, 39.42982,
				41.692041, 44.033256, 46.337433, 48.69478, 51.073046,
				53.427112, 55.861313 };
		return (int) s_lookup[n];
	}

	final int maxN = 30;
	final int maxS = maxN * (maxN - 1) / 2;

	int N, S;

	BigDecimal[][] D = new BigDecimal[maxN + 1][maxS + 1];
	BigDecimal[][] T = new BigDecimal[maxN + 1][maxS + 1];
	BigDecimal[][] C = new BigDecimal[maxS + 1][maxS + 1];
	BigDecimal[][] E = new BigDecimal[maxN + 1][maxS + 1];

	public int connectThem(int n) {
		MathContext mc = new MathContext(5, RoundingMode.HALF_UP);
		N = n;
		S = N * (N - 1) / 2;
		BigDecimal sum = BigDecimal.ZERO;
		calc_C();
		calc_E();
		calc_D();
		for (int i = 0; i <= S; ++i)
			sum = sum.add(D[n][i].multiply(BigDecimal.valueOf(i)));
		return sum.round(mc).intValue();
	}

	// C[i][j]表示从i个元素中选取j个作为一组的方法数，组合数
	void calc_C() {
		C[0][0] = BigDecimal.ONE;
		int t = Math.max(N, S);
		for (int i = 1; i <= t; ++i) {
			C[i][0] = C[i][i] = BigDecimal.ONE;
			for (int j = 1; j < i; ++j)
				C[i][j] = C[i - 1][j - 1].add(C[i - 1][j]);
		}
	}

	// E[i][j]表示从i个元素中选取j个排为一列的方法数，排列数
	void calc_E() {
		for (int i = 1; i <= N; ++i) {
			int e = i * (i - 1) / 2;
			E[i][0] = BigDecimal.ONE;
			for (int j = 1; j <= e; ++j)
				E[i][j] = E[i][j - 1].multiply(BigDecimal.valueOf(e - j + 1));
		}
	}

	// T[i][j]表示i个点在j条边时已经连通的概率，T[i][j]=T[i][j-1]+D[i][j]
	// D[i][j]表示i个点在j条边时才连通的概率(j-1条边不连通,第j条边连接起两个连通分量)
	void calc_D() {
		MathContext mc = new MathContext(5, RoundingMode.HALF_UP);
		D[1][0] = BigDecimal.ONE;
		T[1][0] = BigDecimal.ONE;

		for (int i = 2; i <= N; ++i) {
			int e = i * (i - 1) / 2;
			D[i][0] = BigDecimal.ZERO;
			T[i][0] = BigDecimal.ZERO;
			for (int j = 1; j <= e; ++j) {
				D[i][j] = BigDecimal.ZERO;
				for (int k1 = 1; k1 <= i / 2; ++k1) {
					int k2 = i - k1;
					int e1 = k1 * (k1 - 1) / 2;
					int e2 = k2 * (k2 - 1) / 2;
					BigDecimal t = BigDecimal.ZERO;
					for (int u1 = 0; u1 <= j - 1; ++u1) {
						int u2 = j - 1 - u1;
						if (u1 <= e1 && u2 <= e2) {
							t = t.add(T[k1][u1].multiply(T[k2][u2])
									.multiply(E[k1][u1]).multiply(E[k2][u2])
									.multiply(BigDecimal.valueOf(k1 * k2))
									.divide(E[i][j], mc).multiply(C[j - 1][u1]));
						}
					}
					t = t.multiply(C[i][k1]);
					if (k1 == k2)
						t = t.divide(BigDecimal.valueOf(2));
					D[i][j] = D[i][j].add(t);
				}
				T[i][j] = T[i][j - 1].add(D[i][j]);
			}
		}
	}
}
