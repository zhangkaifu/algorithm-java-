package sort;
/**
 * date 2018/12/4
 * @author qingfeng
 * 算法步骤：
 *初始化：构造一个10*n的二维数组，一个长度为n的数组用于存储每次位排序时每个桶子里有多少个元素。
 *循环操作：从低位开始（我们采用LSD的方式），将所有元素对应该位的数字存到相应的桶子里去（对应二维数组的那一列）。
 *然后将所有桶子里的元素按照桶子标号从小到大取出，对于同一个桶子里的元素，先放进去的先取出，后放进去的后取出（保证排序稳定性）。
 *这样原数组就按该位排序完毕了，继续下一位操作，直到最高位排序完成。
 */
public class RadixSort {
	public static int[] radixSort(int[] array,int d){
	    int n=1;//代表位数对应的数：1,10,100...
	    int k=0;//保存每一位排序后的结果用于下一位的排序输入
	    int length=array.length;
	    int[][] bucket=new int[10][length];//排序桶用于保存每次排序后的结果，这一位上排序结果相同的数字放在同一个桶里
	    int[] order=new int[length];//用于保存每个桶里有多少个数字
	    while(n<d)
	    {
	        for(int num:array) //将数组array里的每个数字放在相应的桶里
	        {
	            int digit=(num/n)%10;
	            bucket[digit][order[digit]]=num;
	            order[digit]++;
	        }
	        for(int i=0;i<length;i++)//将前一个循环生成的桶里的数据覆盖到原数组中用于保存这一位的排序结果
	        {
	            if(order[i]!=0)//这个桶里有数据，从上到下遍历这个桶并将数据保存到原数组中
	            {
	                for(int j=0;j<order[i];j++)
	                {
	                    array[k]=bucket[i][j];
	                    k++;
	                }
	            }
	            order[i]=0;//将桶里计数器置0，用于下一次位排序
	        }
	        n*=10;
	        k=0;//将k置0，用于下一轮保存位排序结果
	    }
	    return array;
	}
	public static void main(String[] args) {
		double iBegingTime;
		double iEndTime;
		int M = 10000;//元素最大值
		int N = 10000;//元素个数
		int[] array = new int[N];
		for (int i = 0; i < N; i++)
		    array[i] = (int) (Math.random() * M);
		System.out.print("*******数组基数排序*******\n排序前:\t");
		print(array);
		
		iBegingTime = System.currentTimeMillis(); 
		
		array = RadixSort.radixSort(array, M);
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