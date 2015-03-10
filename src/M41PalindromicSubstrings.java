//Description
//You are given a string, count number of Palindromic Substrings 
//within the given string.
//
//Input
//The input should be a string consists of lower case letters. 
//The length of the given string should be less than or equal to 1,000,000.
//
//Output
//The output should be the number of Palindromic Substrings within 
//the given input string.
//
//Sample Input
//aba
//Sample Output
//4
//HINT
//Manacher & Count
//
//Source
//Hard

public class M41PalindromicSubstrings {
	public static void main(String[] args) {
		System.out.println(new M41PalindromicSubstrings()
				.countPalindromicSubstrings("aba"));
	}

	public long countPalindromicSubstrings(String S) {
		long re = 0;
		int len = S.length();
		int n = 2 * len + 3;
		char[] cs = new char[n];
		cs[0] = '$';
		cs[1] = '#';
		for (int i = 0; i < len; i++) {
			cs[2 * i + 2] = S.charAt(i);
			cs[2 * i + 3] = '#';
		}
		cs[2 * len + 2] = '!';
		// id表示最大回文子串中心的位置，mx则为id+P[id]，也就是最大回文子串的边界
		// 记j = 2 * id - i，也就是说 j 是 i 关于 id 的对称点。
		// if (mx - i > P[j])
		// P[i] = P[j];
		// else /* P[j] >= mx - i */
		// P[i] = mx - i; // P[i] >= mx - i，取最小值，之后再匹配更新。
		int mx = 0;
		int id = 0;
		int p[] = new int[n];
		for (int i = 1; i < n - 1; i++) {
			if (mx > i)
				p[i] = Math.min(p[2 * id - i], p[id] + id - i);
			else
				p[i] = 1;
			while (cs[i + p[i]] == cs[i - p[i]])
				p[i]++;
			if (p[i] + i > mx) {
				mx = p[i] + i;
				id = i;
			}
		}
		for (int i = 1; i < n - 1; i++) {
				re += p[i] / 2;
		}
		return re;
	}
}
