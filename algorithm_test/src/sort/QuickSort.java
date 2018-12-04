package sort;
/**
 * date 2018/12/4
 * @author qingfeng
 *一趟快速排序的算法是：
 *1）设置两个变量i、j，排序开始的时候：i=0，j=N-1；
 *2）以第一个数组元素作为关键数据，赋值给key，即key=A[0]；
 *3）从j开始向前搜索，即由后开始向前搜索(j--)，找到第一个小于key的值A[j]，将A[j]和A[i]互换；
 *4）从i开始向后搜索，即由前开始向后搜索(i++)，找到第一个大于key的A[i]，将A[i]和A[j]互换；
 *5）重复第3、4步，直到i=j； (3,4步中，没找到符合条件的值，即3中A[j]不小于key,4中A[i]不大于key的时候改变j、i的值，
 *使得j=j-1，i=i+1，直至找到为止。找到符合条件的值，进行交换的时候i， j指针位置不变。
 *另外，i==j这一过程一定正好是i+或j-完成的时候，此时令循环结束）。
 */

public class QuickSort {

	public static int[] quickSort(int[] array, int low, int high) {
		//1,找到递归算法的出口
		if( low > high) {
			return array;
		}
		int i = Partition(array, low, high);
		//对key左边的数快排
		quickSort(array, low, i-1 );
		// 对key右边的数快排
		quickSort(array, i+1, high);
		return array;
	}
	private static int Partition(int[] array, int low, int high) {
		int i = low;
		int j = high;
		//key
		int key = array[ low ];
		//完成一趟排序
		while( i< j) {
			//从右往左找到第一个小于key的数
			while(i<j && array[j] > key){
				j--;
			}
			// 从左往右找到第一个大于key的数
			while( i<j && array[i] <= key) {
				i++;
			}
			//交换
			if(i<j) {
				int p = array[i];
				array[i] = array[j];
				array[j] = p;
			}
		}
		// 调整key的位置
		int p = array[i];
		array[i] = array[low];
		array[low] = p;
		return i;// 返回中轴的位置
	}
	public static void main(String[] args) {
		double iBegingTime;
		double iEndTime;
		int n = 10000;
		int[] array = new int[n];
		
		for (int i = 0; i < n; i++) {
			array[i] = (int) (Math.random() * 10000);
		}
		System.out.print("*******数组快速排序*******\n排序前:\t");
		print(array);
		
		iBegingTime = System.currentTimeMillis(); 
		
		array = QuickSort.quickSort(array,0,array.length-1);
		iEndTime = System.currentTimeMillis(); 
		System.out.printf("\n运行时间：%.3f ms\n排序后：\t",(iEndTime-iBegingTime));
		print(array);
		}
	private static void print(int[] a) {
		for(int i:a) {
			System.out.print(i+"\t");
		
	}

	}

}
