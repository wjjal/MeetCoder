//Description
// Given two strings, check if one string is permutation of another string. 
//You may assume both strings contain English characters only.
//
//Input
// The input should be two strings. The length of each string should be 
//less than or equal to 1,000,000.
//
//Output
// The output should be true if one string is permutation of other string. 
//Otherwise it should be false.
//
//Sample Input
//abc bca
//Sample Output
//true
//HINT
// Sort & HashTable
//
//Source
//Easy

public class M42CheckIfOneStringIsPermutationOfAnotherString {
	public static void main(String[] args) {
		System.out
				.println(new M42CheckIfOneStringIsPermutationOfAnotherString()
						.isPermutation("abc", "bca"));
	}

	public boolean isPermutation(String s, String t) {
		int[] hash = new int[256];
		int sl = s.length(), tl = t.length();
		if (sl != tl)
			return false;
		for (int i = 0; i < sl; i++)
			hash[s.charAt(i)]++;
		for (int i = 0; i < tl; i++)
			hash[t.charAt(i)]--;
		for (int i = 0; i < 256; i++) {
			if (hash[i] != 0)
				return false;
		}
		return true;
	}
}
