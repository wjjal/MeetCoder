//Description
// You are given an image represented by an N*N matrix, 
//how would you rotate the image by 90 degrees (clockwise) in place?
//
//Input
// The input should be a two dimension array in Integer.
//
//Output
// The output should be a two dimension array in Integer.
//
//Sample Input
//1,2,3,4
//5,6,7,8
//9,10,11,12
//13,14,15,16
//Sample Output
//13,9,5,1
//14,10,6,2
//15,11,7,3
//16,12,8,4
//HINT
//Swap
//
//Source
//Easy
public class M46RotateImage {
	public void rotate(int[][] matrix, int n) {
		n = matrix.length - 1;
		if (n < 1)
			return;
		for (int i = 0; i <= n / 2; i++) {
			for (int j = i; j < n - i; j++) {
                 int tmp = matrix[i][j];
                 matrix[i][j]=matrix[n-j][i];
                 matrix[n-j][i]=matrix[n-i][n-j];
                 matrix[n-i][n-j]=matrix[j][n-i];
                 matrix[j][n - i] = tmp;
			}
		}
	}
}
