import java.util.Scanner;

public class Main {
	static int gcd = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		findGcd(N, M);
		System.out.println(gcd);
		System.out.println((N/gcd)*(M/gcd)*gcd);
	}
	
	static void findGcd(int n, int m) {
		if(n%m ==0) {
			gcd =m;
			return;
		}else if(m%n ==0) {
			gcd = n;
			return;
		}
		
		if(m-n>0) findGcd(m-n, n);
		else findGcd(n-m, m);
	
	}

}