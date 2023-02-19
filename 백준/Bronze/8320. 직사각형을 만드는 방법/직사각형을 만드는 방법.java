import java.util.Scanner;

public class Main{

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		System.out.println(rectangleCnt(n));
		
		

	}
	
	static int rectangleCnt(int n) {
		if (n==1) {
			return 1;
		}else {
			int cnt = 0;
			for(int i=1; i*i<=n; i++) {
				if(n%i==0) {
					cnt++;
				}
			}
			return rectangleCnt(n-1) + cnt;
		}
	}

}
