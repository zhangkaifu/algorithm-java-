package queen;
public class EightQueen {
	public static int iNum = 0; // 累计方案总数
	public static final int MAXQUEEN = 8;// 皇后个数，同时也是棋盘行列总数
	public static int[] iCols = new int[MAXQUEEN]; // 定义iCols数组，表示n列棋子摆放情况
 
	public EightQueen() {
		// 核心函数,从第0列开始
		getArrangement(0);
		System.out.println(MAXQUEEN + "皇后问题有" + iNum + "种摆放方法。");
	}
 
	public void getArrangement(int n) {
		// 遍历该列所有不合法的行，并用rows数组记录，不合法即rows[i]=true
		boolean[] rows = new boolean[MAXQUEEN];
		for (int i = 0; i < n; i++) {
			rows[iCols[i]] = true;
			int d = n - i;
			if (iCols[i] - d >= 0)
				rows[iCols[i] - d] = true;
			if (iCols[i] + d <= MAXQUEEN - 1)
				rows[iCols[i] + d] = true;
 
		}
		
		for (int k = 0; k < MAXQUEEN; k++) {
			// 判断该行是否合法
			if (rows[k])
				continue;
			// 设置当前列合法棋子所在行数
			iCols[n] = k;
			// 当前列不为最后一列时,递归
			if (n < MAXQUEEN - 1) {
				getArrangement(n + 1);
			} else {
				// 累计方案个数
				iNum++;
				// 打印棋盘信息
				printChessBoard();
			}
		}
	}
	//打印方案
	public void printChessBoard() {
		System.out.println("第" + iNum + "种走法");
		for (int i = 0; i < MAXQUEEN; i++) {
			for (int j = 0; j < MAXQUEEN; j++) {
				if (i == iCols[j]) {
					System.out.print("0 ");
				} else
					System.out.print("+ ");
			}
			System.out.println();
		}
 
	}
 
	public static void main(String args[]) {
		EightQueen queen = new EightQueen();
	}
}
