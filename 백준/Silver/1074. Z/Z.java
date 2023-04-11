import java.util.Scanner;

public class Main {
	static long cnt = 0;
	static int R;
	static int C;
	static boolean flag;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		R = sc.nextInt();
		 
		C = sc.nextInt();
				
		int L = (int) Math.pow(2, N);
		
		find(R, C, L, 0);
		
		
	}
	static void find(int r , int c, int len, int num) {
		
		if(len == 1) {

			if(r==1) {
				System.out.println((int)(num+r+c+1));
				return;
			}
			System.out.println((int)(num+r+c));
			return;
		}
		
		
		if(r>=len/2) {
			num += ((len*len)/4) *2;
			r-=len/2;
		}
		if(c>=len/2) {
			num += (len*len)/4;
			c-=len/2;
		}
		find(r, c, len/2, num);
		
	}
	


}