package sort;
/**
 * date 2018/12/3
 * @author qingfeng
 * 归并排序的一般步骤为：
*将待排序数组（链表）取中点并一分为二；	*递归地对左半部分进行归并排序；
*递归地对右半部分进行归并排序；
*将两个半部分进行合并（merge）,得到结果。
*首先用快慢指针(快慢指针思路，快指针一次走两步，慢指针一次走一步，快指针在链表末尾时，
*慢指针恰好在链表中点)的方法找到链表中间节点，然后递归的对两个子链表排序，
*把两个排好序的子链表合并成一条有序的链表。
 */
public class MergeSort{
	
	 public static void main(String[] args) {

		double iBegingTime;
		double iEndTime;
		int n = 10000;
		int[] a = new int[n];
		for (int i = 0; i < n; i++)
		    a[i] = (int) (Math.random() * 10000);
		System.out.print("*******数组归并排序*******\n排序前:\t");
		print(a);
		
		//MergeSort MS = new MergeSort();
		iBegingTime = System.currentTimeMillis(); 
		a = MergeSort.mergeSort(a, a.length);
		iEndTime = System.currentTimeMillis(); 
		System.out.printf("运行时间：%.3f ms\n排序后：\t",(iEndTime-iBegingTime));
		print(a);
		}
	 
	 public static void print(int[] a) {
		 for(int i : a) {
			 System.out.print(i + "\t");
		 }
		 System.out.println();
	 }
	
	public static int[] mergeSort(int[] array, int n) {
		int[] b = new int[n];
		int s = 1;
		while(s < n) {
			mergePass(array,b,s,n);//合并到数组b
			s += s;
			mergePass(b,array,s,n);//合并到数组a
			s += s;
		}
		return array;
	}
	
	public static void mergePass(int[] x,int[] y,int s,int n) {
		//合并大小为s的相邻子数组
		int i = 0;
		while(i <= n-2*s) {
			//合并大小为s的相邻2段子数组
			merge(x,y,i,i+s-1,i+2*s-1);
			i = i+2 * s;
		}
		//剩下的元素个数小于2s
		if(i+s < n) {
			merge(x,y,i,i+s-1,n-1);
		}
		else {
			for(int j = i; j <=n-1;j++) {
				y[j] = x[j];
			}
		}
		
	}

	private static void merge(int[] c, int[] d, int l, int m, int r) {
		// 合并c[l:m] 和 c[m+1:r]到d[l:r]
		int i = l, j = m + 1, k = l;
		while((i <= m)&&(j <= r)) {
			if(c[i] <= c[j]) {
				d[k++] = c[i++];
			}
			else {
				d[k++] = c[j++];
			}
		}
		if(i > m) {
			for(int q = j;q <= r;q++) {
				d[k++] = c[q];
			}
		}
		else {
			for(int q= i;q <= m;q++) {
				d[k++] = c[q];
			}
		}
		
	}
}