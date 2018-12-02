package algorithm;

import java.util.Scanner;

public class MainTest {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int[] a = {-2, 11, -4, 13, -5, -2};
		System.out.println("数组中最的数 = " + Test.maxSubSum(a));
		
		System.out.println("\n请输入两个数:");
		int m = in.nextInt();
		int n = in.nextInt();
		System.out.println(m + " 与 " + n + " 的最大公因数 = " + Test.gcd(m, n));
	}
}
