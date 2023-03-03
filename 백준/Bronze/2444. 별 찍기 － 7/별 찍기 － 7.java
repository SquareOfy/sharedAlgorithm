import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		for(int i=1; i<=2*n-1; i++) {
			for(int j=0; j<Math.abs(i-2*n/2); j++) {
				System.out.print(" ");
			}
			for(int j=0; j<2*(n-Math.abs(i-2*n/2))-1; j++) {
				System.out.print("*");
			}
			System.out.println();
		}

		
	}

}