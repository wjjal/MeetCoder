//Description
// A Candy Jump is an endless jump that a cute candy picks up powers to jump up 1 or 2 
//levels at each jump to complete the exciting journey. 
//A cute candy is starting to jump up. 
//It takes n steps to reach to the top. 
//In how many distinct ways can it jump to the top?
//
//Input
// The input should be a positive integer N that less than or equal to 88.
//
//Output
// The output should be in the format of Integer.
//
//Sample Input
//1
//Sample Output
//1
//HINT
//Just do it.
//
//Source
//Easy

public class M27CandyJumpI {
	public static void main(String[] args) {
		System.out.println(new M27CandyJumpI().countJumps(88));
	}

	public int countJumps(int n) {
		if (n == 0)
			return 1;
		if (n == 1 || n == 2)
			return n;
		int[] dp = new int[n + 1];
		dp[1] = 1;
		dp[2] = 2;
		for (int i = 3; i <= n; i++)
			dp[i] = dp[i - 1] + dp[i - 2];
		return dp[n];
	}
}
