import java.util.Scanner;

public class Main {

		static int N;
		static int M;
		static int[] result;

		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			
			
			N = sc.nextInt();
			M = sc.nextInt();
			result = new int[M+1];
			sequence(1);
			

		}

		
		static void sequence(int cnt) {
			if(cnt==M+1) {
				for(int i=1; i<M; i++) {
					if(result[i]>result[i+1]) {
						return;
					}
				}
				for(int i=1; i<=M; i++) {
					System.out.print(result[i]+" ");
				}
				System.out.println();
				return;
			}
			
			for(int i=1; i<=N; i++) {
				result[cnt] = i;
				sequence(cnt+1);
			
				
			}
			
		}
	}