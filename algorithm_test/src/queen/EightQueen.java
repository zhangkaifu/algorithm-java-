package queen;
public class EightQueen {
	public static int iNum = 0; // �ۼƷ�������
	public static final int MAXQUEEN = 8;// �ʺ������ͬʱҲ��������������
	public static int[] iCols = new int[MAXQUEEN]; // ����iCols���飬��ʾn�����Ӱڷ����
 
	public EightQueen() {
		// ���ĺ���,�ӵ�0�п�ʼ
		getArrangement(0);
		System.out.println(MAXQUEEN + "�ʺ�������" + iNum + "�ְڷŷ�����");
	}
 
	public void getArrangement(int n) {
		// �����������в��Ϸ����У�����rows�����¼�����Ϸ���rows[i]=true
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
			// �жϸ����Ƿ�Ϸ�
			if (rows[k])
				continue;
			// ���õ�ǰ�кϷ�������������
			iCols[n] = k;
			// ��ǰ�в�Ϊ���һ��ʱ,�ݹ�
			if (n < MAXQUEEN - 1) {
				getArrangement(n + 1);
			} else {
				// �ۼƷ�������
				iNum++;
				// ��ӡ������Ϣ
				printChessBoard();
			}
		}
	}
	//��ӡ����
	public void printChessBoard() {
		System.out.println("��" + iNum + "���߷�");
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
