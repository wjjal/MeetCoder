import java.util.Arrays;

//Description
//N people wish to cross a bridge at night. 
//It’s so dark around there that they have to cross the bridge 
//under the help of a little lamp. Only one little lamp is available (Oh, Men...) 
//and they have to have the little lamp walking with them. 
//The bridge is of a width such that a maximum of 2 people may cross at a time.
//
//Each person walks at his/her fixed speed. If two people cross the bridge together, 
//they must walk at the pace of the slower one. How fast can you get all N people over the bridge?
//
//Input
//The input should be a list of N positive integers, where N is less than or equal to 
//1,000. And each integer of the list should be less than or equal to 100.
//
//Output
//The output should be the minimum time that all the people can cross the bridge.
//
//Sample Input
//1 2
//Sample Output
//2
//HINT
//Greedy
//
//
//Source
//Medium

//假设A、B为走得最快和次快的旅行者，过桥所需时间分别为a、b；而Z、Y为走得最慢和次慢的旅行者，过桥所需时间分别为z、y。
//使用模式一(A,Z->A->A,Y->A)移动Z和Y到彼岸所需的时间为：
//z + a + y + a
//使用模式二(A,B->A->Y,Z->B)移动Z和Y到彼岸所需的时间为：
//b + a + z + b
//所以，
//当2b＞a+y时，应该使用模式一；
//当2b＜a+y时，应该使用模式二；
//当2b＝a+y时，使用模式一或二都可以。

public class M45CrossingBridge {
	public int bridge(int[] v) {
		int len = v.length;
		if (len == 0)
			return 0;
		if (len == 1)
			return v[0];
		Arrays.sort(v);
		int re = 0;
		int a = v[0];
		int b = v[1];
		int i = len - 1;
		while (i > 2) {
			int z = v[i];
			int y = v[i - 1];
			re += Math.min(z + a + y + a, b + a + z + b);
			i -= 2;
		}
		// 此时有速度最快的三人未过岸，最快的人往返一次
		if (i == 2) {
			re += v[2] + v[1] + v[0];
		}
		// 此时仅速度最快的二人未过岸
		else if (i == 1) {
			re += v[1];
		}
		return re;
	}
}
