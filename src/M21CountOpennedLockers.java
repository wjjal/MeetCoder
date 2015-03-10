//Description
//You are standing in a school hallway lined with n closed lockers. 
//You then open all n lockers. 
//After this, you then close every 2nd locker (so the 2nd, 4th, 6th¡­are all closed). 
//Then, you go to every third locker and open it 
//if it is closed or close it if it is open 
//(let¡¯s call this toggling the locker for our discussion). 
//You proceed to toggle every ith locker on pass number i. 
//So, for example, on pass number 18 ¨C you will toggle every 18th locker. 
//After your nth pass in the hallway, in which you toggle only locker number n, 
//how many lockers are open?
//
//Input
//The input should be a positive integer n less than 1,000,000,000,000,000,000.
//
//Output
//The output should be the number of openned lockers that in the format of Integer.
//
//Sample Input
//1
//Sample Output
//1
//HINT
//Math
//
//Source
//Easy

public class M21CountOpennedLockers {
	public long locks(long n) {
        return (long) Math.sqrt(n);
    }
}
