import java.util.Scanner;

public class Solution{
	static int N, P;
	static int[] selected;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			N = sc.nextInt();
			P = sc.nextInt();
			int q = N/P;
			int r = N%P;
			
			
			long answer = (long) Math.pow(q, P);
			for(int i=0; i<r; i++) {
				answer/=q;
				answer*=(q+1);
			}
			
			
			sb.append("#").append(tc).append(" ").append(answer).append("\n");
		}
		System.out.println(sb.toString());
	}
	
	
}