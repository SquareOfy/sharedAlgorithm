import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String str = sc.next();
		
		int N = str.length();
		int r =0;
		for(int i=1; i*i<=N; i++) {
			if(N%i==0) {
				r = i;
			}
		}
		int c = N/r;
		
		char[][] email = new char[r][c];
		int idx =0;
		
		for(int i=0; i<c; i++) {
			for(int j=0; j<r; j++) {
				email[j][i] = str.charAt(idx++);
			}
		}
		for(int i=0; i<r; i++) {
			for(int j=0; j<c; j++) {
				System.out.print(email[i][j]);
			}
		}
		System.out.println();
	}
	

}
