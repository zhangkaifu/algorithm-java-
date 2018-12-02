package queen;
public class EightQueen {
	public static int[][] iChessBoard = new int[8][8];//8*8棋盘
	public static int[][] iIfAvailable = new int[8][8];//标记棋盘上的格子是否可落子
	public static int iCount = 0;//记录已确定位置的皇后数量
	public static int iCountNumber=0;
	public static void main(String[] args){
		//初始化
		for(int m=0; m<8; m++){
			for(int n=0; n<8; n++){
				iChessBoard[m][n] = 0;
				iIfAvailable[m][n] = 0;
			}
		}
		arrange(1,3);//开始落子，可以从棋盘上任意位置开始
	}
	public static void arrange(int i, int j){
		iCount++;
		iChessBoard[i][j] = iCount;
		int[][] changed = new int[8][8];
		for(int m=0; m<8; m++){
			for(int n=0; n<8; n++){
				changed[m][n] = 0;
			}
		}
		for(int m=-7; m<8; m++){
			if(m>=0&&iIfAvailable[i][m]==0){//与皇后同行的格子不可落子
				iIfAvailable[i][m] = 1;
				changed[i][m] = 1;//
			}
			if(m>=0&&iIfAvailable[m][j]==0){//与皇后同列的格子不可落子
				iIfAvailable[m][j] = 1;
				changed[m][j] = 1;
			}
			//与皇后同斜线的格子不可落子
			if(i+m>=0&&i+m<8&j+m>=0&&j+m<8&&iIfAvailable[i+m][j+m]==0){
				iIfAvailable[i+m][j+m] = 1;
				changed[i+m][j+m] = 1;
			}
			if(i+m>=0&&i+m<8&j-m>=0&&j-m<8&&iIfAvailable[i+m][j-m]==0){
				iIfAvailable[i+m][j-m] = 1;
				changed[i+m][j-m] = 1;
			}
		}
		if(iCount==8){//一旦第八个皇后已经确定位置，则打印方案，结束程序
			iCountNumber++;
			System.out.println("八皇后第 "+iCountNumber+"种摆法：");
			for(int m=0; m<8; m++){
				for(int n=0; n<8; n++){
					
					System.out.print(iChessBoard[m][n]+" ");
				}
				System.out.println();
			}
			//System.exit(0);//若删除该行，则可打印出所有的方案，因方案数量庞大造成输出过多，故不作此处理
		}
		else{//如果还没有将所有皇后的位置确定，则继续寻找
			for(int m=0; m<8; m++){
				for(int n=0; n<8; n++){
					if(iIfAvailable[m][n]==0){
						arrange(m,n);
					}
				}
			}
		}
		//在回溯之前，应将本轮改变过的状态恢复为原样
		iCount--;
		iChessBoard[i][j] = 0;
		for(int m=-7; m<8; m++){
			if(m>=0&&changed[i][m]==1){
				iIfAvailable[i][m] = 0;
			}
			if(m>=0&&changed[m][j]==1){
				iIfAvailable[m][j] = 0;
			}
			if(i+m>=0&&i+m<8&j+m>=0&&j+m<8&&changed[i+m][j+m]==1){
				iIfAvailable[i+m][j+m] = 0;
			}
			if(i+m>=0&&i+m<8&j-m>=0&&j-m<8&&changed[i+m][j-m]==1){
				iIfAvailable[i+m][j-m] = 0;
			}
		}
	}
}
