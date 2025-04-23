import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution{
	static int[][] decodeArr = new int[][] {{3, 2, 1, 1}, {2, 2, 2, 1}, {2, 1, 2, 2},
			{1, 4, 1, 1}, {1, 1, 3, 2}, {1, 2, 3, 1}, {1, 1, 1, 4}, 
			{1, 3, 1, 2}, {1, 2, 1, 3}, {3, 1, 1, 2}
	};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int T = sc.nextInt();
		int N = 0;
		int M = 0;
		for(int tc =1; tc<=T; tc++) {
			N = sc.nextInt();
			M = sc.nextInt();
			
			int[][] code = new int[N][M];
			for(int i=0; i<N; i++) {
				String input = sc.next();
				for(int j =0; j<M; j++) {
					code[i][j] = input.charAt(j)-'0';
				}
			}
			
			int zeroCnt = 0;
			int oneCnt = 0;
			
			int[] cntArr = new int[4];
			int cntIdx = 3;
			boolean startFlag = false;
			boolean zeroFlag = false;
			int decodeIdx = 7;
			int[] decode = new int[8];
			
			for(int i=0; i<N; i++) {
				for(int j=M-1; j>=7; j--) {
					
					//시작하자
					if(code[i][j]==1) {
						startFlag=true;
						for(int k=0; k<7; k++) {
							if(code[i][j-k]==0) {
								zeroCnt++;
								if(!zeroFlag) {
									cntArr[cntIdx--] = oneCnt;
									zeroFlag = true;
								}
								oneCnt=0;
							}else {
								oneCnt++;
								startFlag = true;
								if(zeroFlag) {		
									cntArr[cntIdx--] = zeroCnt;
									zeroFlag = false;
								}
								zeroCnt=0;
							}
						}
						cntArr[0] = 7-(cntArr[1]+cntArr[2]+cntArr[3]);
						cntIdx = 3;
						zeroCnt = 0;
						zeroFlag =false;
						oneCnt = 0;
						decode[decodeIdx--]= decode(cntArr);
						j -=6;
					}
					
				}
				if(startFlag) break;
			}
			

			int odd = 0;
			int even = 0;
			//옳은 암호인지 판독하기
			for(int i=0; i<8; i++) {
				if(i%2==0) {
					odd += decode[i];
				}else {
					even +=decode[i];
				}
			}
			int answer = odd*3 + even;
			sb.append("#").append(tc).append(" ");
			if(answer%10==0) {
				sb.append(odd+even);
			}else {
				sb.append(0);
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
		
	}
	
	static int decode(int[] cntArr) {
		for(int i=0; i<10; i++) {
			for(int j=0; j<4; j++) {
				if(cntArr[j]!=decodeArr[i][j]) break;
				if(j==3) return i;
			}
		}
		return -1;
	}
}