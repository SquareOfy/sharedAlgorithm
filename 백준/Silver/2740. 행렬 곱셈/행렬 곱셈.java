import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		int[][] matrix1 = new int[N][M];
		for(int n =0; n<N; n++) {
			for(int m=0; m<M; m++) {
				matrix1[n][m] = sc.nextInt();
			}
		}
		int M2 = sc.nextInt();
		int K = sc.nextInt();
		
		int[][] matrix2 = new int[M2][K];
		int[][] result = new int[N][K];
		
		for(int m =0; m<M2; m++) {
			for(int n=0; n<K; n++) {
				matrix2[m][n] = sc.nextInt();
			}
		}

		
		for(int n=0; n<N; n++) {
			for(int k=0; k<K; k++) {
				for(int i=0; i<M; i++) {
					result[n][k] += matrix1[n][i] * matrix2[i][k];
		
				}
			}
		}
		
		for(int n=0; n<N; n++) {
			for(int k=0; k<K; k++) {
				System.out.print(result[n][k]+" ");
			}
			System.out.println();
		}
		
	}
}
