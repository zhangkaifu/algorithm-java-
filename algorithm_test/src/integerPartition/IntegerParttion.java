package integerPartition;

import java.util.Scanner;

public class IntegerParttion {
	
	static int iCount=0;//计数器，记录种数
	public static int q(int n, int m) {
		if((n < 1) || (m < 1)) { 
			return 0;
		}
		if((n == 1) || (m == 1)) {
			return 1;
		}
		if(n < m) {
			return q(n,n);
		}
		if(n == m) {
			return q(n, m-1) + 1;
		}
		return q(n, m-1) + q(n-m,m);
	}
	
	//有输出划分结果函数
	public static void DFS(int[] iMark,int iSum,int k, int iPrio,int n) {
		if(iSum > n) {
			return;
		} else if(iSum == n) {
			int i;
			iCount++;
			System.out.print("\n第"+iCount+"种=");
			for( i = 0; i < k-1; i++) {
				System.out.print("+"+iMark[i]);
			}
			System.out.print("+"+iMark[i]);
		} else {
			for(int j = iPrio; j > 0; j--) {
				iMark[k] = j;
				iSum += j;
				DFS(iMark,iSum,k+1,j,n);
				iSum -= j;  //恢复现场
			}
		}
	}
	public static void main(String[] args) {
	
		int[] iMark=new int[100];
		Scanner in = new Scanner(System.in);
		System.out.println("请输入要划分的整数：");
		int n = in.nextInt();
		
		System.out.println(n+"的划分结果为：");
		DFS(iMark,0,0,n,n);
			
		//q=q(n,n);
		//System.out.println(q);
		
	}

}
