import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[]loop  = new int[N];
		for(int i=0; i<N; i++) {
			loop[i] = sc.nextInt();		
		}
		
		Arrays.sort(loop);
		int max = 0;
		int sum =0;
		for(int i=0; i<N; i++) {
			sum =0;
			sum +=  loop[i]*(N-i);
			
		
		if(max<sum) max = sum;
		}
		
		System.out.println(max);
		
		
		
	}

}