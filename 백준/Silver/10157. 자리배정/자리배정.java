import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int C = sc.nextInt(), R = sc.nextInt();
		
		int K = sc.nextInt();
		int result = 0;
		if(C*R < K) System.out.println(result);
		else {
			int[][] place = new int[R][C];
			int n =1;
			boolean flagR = false;
			boolean flagL = false;
			boolean flagU = true;
			boolean flagD = false;
			int idxR = 0;
			int idxC = 0;
			outer : while(n<=K) {
				if(flagU==true) { //문제상으로 위로 올라감(편의상 아래로 내려가게 코딩(상하 뒤집어 생각))
					while(idxR<R && place[idxR][idxC]==0) {
						place[idxR++][idxC] = n++;
						if (n==K+1) {
							idxR--;
							System.out.println((idxC+1) + " " + (idxR+1));
							break outer;
						}
					}
					flagU=false;
					flagR = true;
					idxC ++;
					idxR--;
					
				}
				else if(flagR==true) {
					while(idxC<C && place[idxR][idxC]==0) {
						place[idxR][idxC++] = n++;
						if (n==K+1) {
							idxC--;
							System.out.println((idxC+1) + " " + (idxR+1));
							break outer;
						}
					}
					flagD=true;
					flagR =false;
					idxR --;
					idxC --;
					
					
				}
				else if(flagD==true) {
					while(idxR>=0 && place[idxR][idxC]==0) {
						place[idxR--][idxC] = n++;
						if (n==K+1) {
							idxR ++;
							System.out.println((idxC+1) + " " + (idxR+1));
							break outer;
						}
					}
					flagD=false;
					flagL = true;
					idxC--;
					idxR ++;
				}
				else if(flagL==true) {
					while(idxC>=0 && place[idxR][idxC]==0) {
						place[idxR][idxC--] = n++;
						if (n==K+1) {
							idxC++;
							System.out.println((idxC+1) + " " + (idxR+1));
							break outer;
						}
					}
					flagL=false;
					flagU = true;
					idxR ++;
					idxC ++;
					
				}
		
				
			}
			
			
		}
		

	}

}