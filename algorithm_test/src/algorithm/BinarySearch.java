package algorithm;

import java.util.Scanner;

/*
 ***折半算法***
 *给定一个整数 X 和整数A0,A1,...,A(n-1),后者已经预先排序并在内存中，
 *求下标Ai=X,如果X不在数据中，则返回i=-1。 
 */

public class BinarySearch {
	/**
	 * perform the standard binary search
	 * @return 
	 * @return index where item is found, or -1 if not found.
	 */
 	public static <AnyType extends Comparable < ? super AnyType>>
	int binarySeach(AnyType [] a, AnyType x)
	{
		int low = 0, high = a.length - 1;
		
		while(low <= high)
		{
			int mid = (low + high)/2;
			if(a[mid].compareTo(x) < 0)
				low = mid + 1;
			else if(a[mid].compareTo(x) >0)
				high = mid -1;
			else
				return mid; //Found
		}
		
		return -1;  //-1 is defined asNOT_FOUND
	}

}
