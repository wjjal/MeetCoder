import java.util.Arrays;

//Description
//N people wish to cross a bridge at night. 
//It��s so dark around there that they have to cross the bridge 
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

//����A��BΪ�ߵ����ʹο�������ߣ���������ʱ��ֱ�Ϊa��b����Z��YΪ�ߵ������ʹ����������ߣ���������ʱ��ֱ�Ϊz��y��
//ʹ��ģʽһ(A,Z->A->A,Y->A)�ƶ�Z��Y���˰������ʱ��Ϊ��
//z + a + y + a
//ʹ��ģʽ��(A,B->A->Y,Z->B)�ƶ�Z��Y���˰������ʱ��Ϊ��
//b + a + z + b
//���ԣ�
//��2b��a+yʱ��Ӧ��ʹ��ģʽһ��
//��2b��a+yʱ��Ӧ��ʹ��ģʽ����
//��2b��a+yʱ��ʹ��ģʽһ��������ԡ�

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
		// ��ʱ���ٶ���������δ����������������һ��
		if (i == 2) {
			re += v[2] + v[1] + v[0];
		}
		// ��ʱ���ٶ����Ķ���δ����
		else if (i == 1) {
			re += v[1];
		}
		return re;
	}
}
