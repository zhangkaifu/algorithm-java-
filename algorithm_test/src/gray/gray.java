package gray;

public class gray {
	
	public static void Gray( String[] sGray ,int n) {
		if(0==n) {
			sGray[0]="0";
		}
		else if(1==n) {
			sGray[0]="0";
			sGray[1]="1";
		}
       else{

           /* 先算出n-1位所有的Gray码 */

           Gray(sGray,n-1);

           /* n位Gray码的后半部分是n-1位Gray码倒序再加上一个"1" */

           for(int j = 1<<(n-1);j < 1<<n;j++)

                  sGray[j] = sGray[(1<<n)-j-1]+"1";

           /* n位Gray码的前半部份是n-1位Gray码末尾加"0" */

           for(int j = 0;j < 1<<(n-1);j++)

                  sGray[j] = sGray[j]+"0";

        }		
	}

	public static void main(String[] args) {
		int n = 3;
		String[] sGray = new String[1<<n] ;
		
		Gray(sGray,n);
		for(int i = 0;i <(1<<n); i++) {
			System.out.print(sGray[i]+" ");
		}

	}

}
