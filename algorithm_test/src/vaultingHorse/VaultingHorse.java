package vaultingHorse;

public class VaultingHorse {
	public static int[] iRow= {1,2,2,1,-1,-2,-2,-1};//标记方向的横轴
	public static int[] iRank= {-2,-1,1,2,2,1,-1,-2};//标记方向的竖轴
	
	//chessBoardfull判断棋盘是否已经走满，若走满return true,否则return false;
	public static boolean chessBoardfull(int[][] iChessBoard) {
		for(int i=1;i<iChessBoard.length;i++) {
			for(int j=1;j<iChessBoard[i].length;j++) {
				if(iChessBoard[i][j]==0) {
					return false;
				}
			}
		}
		return true;
	}
	//inChessBoard判断当前格子是否已经走过,若走过return false,否则return true	
	public static boolean inChessBoard(int x,int y,int[][] iChessBoard) {
		return (((x>=0)&&(x<iChessBoard.length))&&((y>=0)&&(y<iChessBoard[0].length)));
	}
	
	public static int findSuccessor(int i,int j, int[][] iChessBoard) {
		int m,n,count=0;
		for(int k=0;k<iRow.length;k++) {
			m=i+iRow[k];
			n=j+iRank[k];
			if(inChessBoard(m,n,iChessBoard)) {
				if(iChessBoard[m][n]==0) {
					count++;
				}
			}
		}
		return count;	
	}
	
	public static void Warnsdorff(int m,int n,int[][] iChessBoard) {
		int i,j,iCount,iSubCount,iok=0,jok=0;
		int iStep=2;//记录步数
		boolean bFind = false;
		i=m;
		j=n;
		while(!chessBoardfull(iChessBoard)) {
			bFind=false;
			iCount=8;
			for(int k=0;k<iRow.length;k++) {
				//判断当前格子是否已经走过，若走过continue跳出当次循环
				if(!inChessBoard(i+iRow[k],j+iRank[k],iChessBoard)) {
					continue;
				}
				if(iChessBoard[i+iRow[k]][j+iRank[k]] !=0) {
					continue;
				}
				iSubCount=findSuccessor(i+iRow[k],j+iRank[k],iChessBoard);
				if(iCount>iSubCount) {
					iCount =iSubCount;
					iok=i+iRow[k];
					jok=j+iRank[k];
					bFind=true;
				}
			}
			if(!bFind) {
				break;
			}
			else {
				iChessBoard[iok][jok]=iStep;//给棋盘标记跳马步数
				i=iok;
				j=jok;
				iStep++;
			}
		}
	}
	
	public static void main(String[] args) {
		int[][] iChessBoard = new int[8][8];//棋盘初始化
		int i,j,none=0;//记录未跳到的格子数
		iChessBoard[0][0]=1;//定义棋盘开始的位置
		Warnsdorff(0,0, iChessBoard);
		System.out.println("*************跳马算法****************\n");
		//打印棋盘
		for(i=0;i<iChessBoard.length;i++) {
			for(j=0;j<iChessBoard[i].length;j++) {
				if(iChessBoard[i][j]==0) {
					none++;
				}
				else {
					System.out.print(iChessBoard[i][j]>=10?(iChessBoard[i][j]+"\t"):(iChessBoard[i][j]+"\t"));
				}
				System.out.print("");
			}
			System.out.println("");
		}
		System.out.println("未跳到的格数；"+none);
	}
	

}
