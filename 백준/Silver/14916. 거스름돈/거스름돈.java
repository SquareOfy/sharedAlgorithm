import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int cnt = 0;
		if(N%5==0) cnt+= N/5;
		
		else if((N%5)%2==0) cnt+= N/5 + (N%5)/2;
		
		else if ((N%5)%2==1 && N/5 != 0) cnt+= N/5 -1 + ((N%5)+5)/2;
		
		else cnt = -1;
		
		System.out.println(cnt);
	}

}