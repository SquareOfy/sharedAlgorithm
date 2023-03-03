import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N =sc.nextInt();
		
		String result = "long int";
		
		for(int i=1; i<N/4; i++) {
			result = "long "+result;
		}
		
		System.out.println(result);

	}

}