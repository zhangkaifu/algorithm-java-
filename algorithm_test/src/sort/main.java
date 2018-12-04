package sort;

public class main {

	public static void main(String[] args) {
		int L = 100;//数据组数
		//存放快速排序运行时间的数组
		long[] QSTime = new long[L];
		
		//存放归并排序运行时间的数组
		long[] MSTime = new long[L];
		
		//存放基数排序运行时间的数组
		long[] RSTime = new long[L];
		
		int M = 50000;//元素最大值
		int N = 10000;//元素个数
		
		for(int i = 0;i < L;i++) {
			//三个算法的开始时间和结束时间
			long iStartTimeQS ,iStartTimeMS, iStartTimeRS, iEndTimeQS, iEndTimeMS, iEndTimeRS;
			//初始化数组
			int[] array = new int[N];
			int[] array1 = new int[N], array2 = new int[N], array3 = new int[N];
			for (int J = 0; J < N; J++) {
				array[J] = (int) (Math.random() * M);
			}
			
			//System.out.println("\n第 "+(i+1)+"组排序\n");
			
			//复制数组
			for(int k =0; k < N; k++) {
				array1[k] = array[k];
				array2[k] = array[k];
				array3[k] = array[k];
			}
			//System.currentTimeMillis()获取当前时间戳，毫秒为单位
			//调用快速排序
			iStartTimeQS = System.currentTimeMillis(); 
			array1 = QuickSort.quickSort(array1,0,array1.length-1);
			iEndTimeQS = System.currentTimeMillis(); 
			QSTime[i] = (iEndTimeQS - iStartTimeQS);
			
			//调用归并排序
			iStartTimeMS = System.currentTimeMillis(); 
			array2 = MergeSort.mergeSort(array2,array2.length-1);
			iEndTimeMS = System.currentTimeMillis(); 
			MSTime[i] = (iEndTimeMS - iStartTimeMS);
			
			//调用基数排序
			iStartTimeRS = System.currentTimeMillis(); 
			array3 = RadixSort.radixSort(array,M);
			iEndTimeRS = System.currentTimeMillis(); 
			RSTime[i] = (iEndTimeRS - iStartTimeRS);
		}
		//求三种算法的平均运行时间
		System.out.println("####### 快速排序、归并排序、基数排序算法 "+L+" 组数据 "+N+" 个元素,元素最大值"+M+" 的运行平均时间 ########");
		System.out.println("快速排序：\t"+avg(QSTime)+" ms");
		System.out.println("归并排序：\t"+avg(MSTime)+" ms");
		System.out.println("基数排序：\t"+avg(RSTime)+" ms");
	}
	
	private static double avg(long[] a) {
		double avg;
		long sum=0;
		for(long m:a) {
			sum += m;
		}
		avg = (sum*1.00)/a.length;
		return avg;
	}
}
