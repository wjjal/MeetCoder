//Description
//You are given a string that consists of character 0 and 1 only. 
//You are only allowed to DELETE character from the string. 
//The goal is to change the original string into a new string with alternate 0 and 1, 
//meaning no duplicated characters next to each other. 
//Find the minimum number of characters you need to delete to reach this goal.
//
//Input
//The input should be a string consists of character 0 and 1 only, 
//where the length of the given string should be less than or equal to 100,000.
//
//Output
//The goal is to change the original string into a new string with alternate 0 and 1, 
//meaning no duplicated characters next to each other. 
//So the output should be the minimum number of characters 
//you need to delete to reach this goal.
//
//Sample Input
//1011
//Sample Output
//1
//HINT
//Linear Scan
//
//
//Source
//Easy

public class M06StringWithAlternate0And1 {
	public int leastDeletion(String s) {
		int len = s.length();
		if (len <= 1)
			return len;
		char last = s.charAt(0);
		int re = 0;
		for (int i = 1; i < len; i++) {
			if (s.charAt(i) == last)
				re++;
			else
				last = s.charAt(i);
		}
		return re;
	}
}
