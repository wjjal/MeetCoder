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

//诀窍就在于这题目对LIS有了新的定义，我们暂且叫他Special-LIS。一般来说求LIS我们只要求元素单调性：
//即在LIS中，array[y] > array[x] (y > x)  
//
//可这一题Special-LIS要满足如下条件：: 
//若在array里存在两个元素array[x], array[y]且x < y1 
//那么这两个元素必须满足: array[y] - array[x] >= y - x它们才有可能同时存在于Special-LIS里面
//
//理由很简单，如果array[y] - array[x] < y - x那么它们之间的元素array(x...y)不管怎么替换都不可能使得
//array[x...y]严格递增。
//生动一点的例子 arr = [1 2 9 3], 那么2和3就不可能同时存在于Special-LIS中
//
//换句话说Special-LIS里所有的元素都满足 array[y] - array[x] >= y - x
//
//这也是这题的解法所在了，我们对这个关键的式子进行移项，得到 array[y] - y >= array[x] - x 
//我们把array[i] - i看做一个整体，那么我们如果把array的每一项减去它的index，得到Special-array，
//再对Special-array求普通的LIS。就是我们想要的答案了。
//
//edge case就是bs函数里面先会考虑key和1之间的大小关系，如果key小于1那么直接返回。原因是如果array[i] - i < 1
//那就根本不能考虑这个数存在于Special-LIS里面的可能性，因为如果他存在Speical-LIS中，
//那么他之前的数无论怎么replace都不可能构成一个严格递增序列。
//
//总之，这题最关键的地方，就是想清楚不等书关系，然后向LIS问题reduce。

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
