//Description
//You are given a random permutation from all possible permutations of integers 
//from 0 to N - 1, find the minimum number of the 2-Adjacent-Swap to sort the permutation. A 2-Adjacent-Swap means swaping any two adjacent integers at one time.
//
//Input
//The input should be a permutation of integers from 0 to N - 1, 
//where N should be less than or equal to 100,000.
//
//Output
//The output should be the minimum number of 2-Adjacent-Swap to sort the permutation.
//
//Sample Input
//2 1 0
//Sample Output
//3
//HINT
//Count Circle
//
//Source
//Medium

//计算逆序对数量
public class M37SortNumbersWithSwapIII {
	public static void main(String[] args) {
		int[] a = { 1, 4, 0, 2, 3 };
		System.out.println(new M37SortNumbersWithSwapIII().sortWithSwap(a));
	}

	long sortWithSwap(int[] a) {
		int len = a.length;
		int[] tmp = new int[len];
		tmp = a.clone();
		long re = MergeInversion(a,tmp,0,len-1);
		return re;
	}

	private long MergeInversion(int[] arr, int[] tmp, int begin, int end) {
		long inversions = 0; // 记录倒序数
		if (begin < end) {
			int mid = (begin + end) >> 1;
			inversions += MergeInversion(arr, tmp, begin, mid);
			inversions += MergeInversion(arr, tmp, mid + 1, end);
			inversions += MergeSort(arr, tmp, begin, mid, end);
		}
		return inversions;
	}

	private long MergeSort(int[] arr, int[] tmp, int begin, int mid, int end) {
		tmp = arr.clone();
		int i = begin, j = mid + 1, k = begin;
		long inversion = 0;
		while (i <= mid && j <= end) {
			if (tmp[i] <= tmp[j]) {
				arr[k++] = tmp[i++];
			} else {
				arr[k++] = tmp[j++];
				inversion += (mid - i + 1);
			}
		}
		while (i <= mid) {
			arr[k++] = tmp[i++];
		}
		while (j <= end) {
			arr[k++] = tmp[j++];
		}
		return inversion;
	}
}
