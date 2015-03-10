//Description
//A Super Candy Jump (Candy Jump II) is an endless jump that a cute candy 
//picks up powers to jump up 1 or 2 or 3 or ... or N levels at each jump to 
//complete the exciting journey. 
//A cute candy is starting to jump up. It takes n steps to reach to the top. 
//In how many distinct ways can it jump to the top?
//
//Input
//The input should be a positive integer N that less than or equal to 60.
//
//Output
//The output should be in form of Integer.
//
//Sample Input
//6
//Sample Output
//32
//HINT
// Bit Operation
//
//Source
//Easy

//斐波那契数列求和
public class M28CandyJumpII {
	public static void main(String[] args) {
		System.out.println(new M28CandyJumpII().countJumps(6));
	}

	long countJumps(int n) {
		if (n == 0)
			return 1;
		return 1L << (n - 1);
	}
}
