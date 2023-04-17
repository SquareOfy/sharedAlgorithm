import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int result = 0;
		for(int i=1; i<=N; i++) {
			int num = i;
			result = i;
			while(num>0) {
				result += num%10;
				num/=10;
			}
			if(result==N) {
				result = i;
				break;
			}else {
				result =0;
			}
		}
		
		System.out.println(result);

	}

}