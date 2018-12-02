package algorithm;

public class Test {
	/*
	 *求最大子序列和算法 
	 */
	public static int maxSubSum(int [] a)
	{
		int maxSum = 0, thisSum = 0;
		
		for(int j = 0;j < a.length;j++)
		{
			thisSum += a[j];
			if(thisSum > maxSum)
				maxSum = thisSum;
			else if(thisSum < 0)
				thisSum =0;
		}
		return maxSum;
	}
	
	/*
	 * 求最大公因数gcd
	 */
	public static long gcd(long m, long n) {
		while(n != 0) {
			long rem = m % n;
			m = n;
			n = rem;
		}
		return m;
	}
	
}
