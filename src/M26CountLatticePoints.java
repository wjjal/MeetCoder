//Description
//You are given a segment on the XY-Plane, count the number of Lattice Points 
//within the given segment. 
//A Lattice Point is a point (x, y) in the 2-dimensional XY-Plane with x and y 
//coordinates are both in form of integer. For example, (2,3) 
//and (100,-90) are Lattice Points since they are the points with integer coordinates. 
//
//Input
//The input should be four non-negative integers that are (x1,y1) and (x2,y2). 
//All the integers should be less than 1018
//
//Output
//The output should be in the format of Integer.
//
//Sample Input
//1 2 3 4
//Sample Output
//3
//HINT
//Math and Number Theory
//
//Source
//Easy

//gcd(y2-y1,x2-x1)+1
public class M26CountLatticePoints {
	public static void main(String[] args) {
		System.out.println(new M26CountLatticePoints().countLatticePoints(1, 2,
				3, 4));
	}

	long countLatticePoints(long x1, long y1, long x2, long y2) {
		long dy = Math.abs(y2 - y1);
		long dx = Math.abs(x2 - x1);
		return gcd(dy, dx) + 1;
	}

	private long gcd(long m, long n) {
		long next = 0;
		if (n == 0)
			return m;
		else {
			next = m % n;
			return gcd(n, next);
		}
	}
}
