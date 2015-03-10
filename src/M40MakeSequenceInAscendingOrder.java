//Description
//You are given a sequence of integers, you are allowed to replace any element with 
//any positive number. Find the minimum number of replacements to make the 
//sequence of integers in strictly ascending order.
//
//Input
//The input should be a list of positive integers less than 1,000,000,000.
//
//Output
//The output should be the minimum number of replacements to make the 
//sequence in strictly ascending order.
//
//Sample Input
//1 1 3 1 
//Sample Output
//2
//HINT
//Dynamic Programming
//
//Source
//Hard

//���Ͼ���������Ŀ��LIS�����µĶ��壬�������ҽ���Special-LIS��һ����˵��LIS����ֻҪ��Ԫ�ص����ԣ�
//����LIS�У�array[y] > array[x] (y > x)  
//
//����һ��Special-LISҪ��������������: 
//����array���������Ԫ��array[x], array[y]��x < y1 
//��ô������Ԫ�ر�������: array[y] - array[x] >= y - x���ǲ��п���ͬʱ������Special-LIS����
//
//���ɺܼ򵥣����array[y] - array[x] < y - x��ô����֮���Ԫ��array(x...y)������ô�滻��������ʹ��
//array[x...y]�ϸ������
//����һ������� arr = [1 2 9 3], ��ô2��3�Ͳ�����ͬʱ������Special-LIS��
//
//���仰˵Special-LIS�����е�Ԫ�ض����� array[y] - array[x] >= y - x
//
//��Ҳ������Ľⷨ�����ˣ����Ƕ�����ؼ���ʽ�ӽ�������õ� array[y] - y >= array[x] - x 
//���ǰ�array[i] - i����һ�����壬��ô���������array��ÿһ���ȥ����index���õ�Special-array��
//�ٶ�Special-array����ͨ��LIS������������Ҫ�Ĵ��ˡ�
//
//edge case����bs���������Ȼῼ��key��1֮��Ĵ�С��ϵ�����keyС��1��ôֱ�ӷ��ء�ԭ�������array[i] - i < 1
//�Ǿ͸������ܿ��������������Special-LIS����Ŀ����ԣ���Ϊ���������Speical-LIS�У�
//��ô��֮ǰ����������ôreplace�������ܹ���һ���ϸ�������С�
//
//��֮��������ؼ��ĵط�������������������ϵ��Ȼ����LIS����reduce��

public class M40MakeSequenceInAscendingOrder {
	public static void main(String[] args) {
		int[] a = { 1, 2, 8, 9, 7 };
		System.out.println(new M40MakeSequenceInAscendingOrder()
				.makeSequence1(a));
	}

	public int makeSequence1(int[] a) {
		int len = a.length;
		int[] b = new int[len];
		int maxsorted = 0;
		for (int i = 0; i < len; i++)
			b[i] = a[i] - i;
		maxsorted = dp_LIS(b);
		return len - maxsorted;
	}

	private int dp_LIS(int[] arr) {
		int len = arr.length;
		int[] dp = new int[len + 1];
		int i = 0;
		while (i < len && arr[i] < 1)
			i++;
		if (i == len)
			return 0;
		else
			dp[1] = arr[i++];
		int max = 1;
		for (; i < len; i++) {
			if (arr[i] < 1)
				continue;
			int low = 1, high = max, mid = 0;
			while (low <= high) {
				mid = low + (high - low) / 2;
				if (mid == 1 && dp[mid] > arr[i])
					break;
				if (dp[mid] < arr[i])
					low = mid + 1;
				else if (dp[mid] == arr[i]) {
					low = mid + 1;
				} else
					high = mid - 1;
			}
			dp[low] = arr[i];
			max = Math.max(max, low);
		}
		return max;
	}

	public int makeSequence2(int[] a) {
		int len = a.length;
		int[] dp = new int[len];
		int maxsorted = 0;
		for (int i = 0; i < len; i++) {
			maxsorted += binarySearch(dp, maxsorted, a, i);
		}
		return len - maxsorted;
	}

	private int binarySearch(int[] dp, int len, int[] a, int idx) {
		int key = a[idx] - idx;
		if (key < 1)
			return 0;
		int begin = 0, end = len - 1;
		while (begin <= end) {
			int mid = begin + (end - begin) / 2;
			if ((mid == 0 && key < dp[mid])
					|| (mid > 0 && dp[mid - 1] <= key && dp[mid] > key)) {
				dp[mid] = key;
				return 0;
			} else if (dp[mid] > key) {
				end = mid - 1;
			} else
				begin = mid + 1;
		}
		dp[len] = key;
		return 1;
	}
}
