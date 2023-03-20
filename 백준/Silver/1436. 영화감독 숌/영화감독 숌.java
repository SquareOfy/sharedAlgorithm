

import java.util.Scanner;

public class Main {
		public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();

		int cnt =1;
		int num = 666;
		
		while(cnt != n) {
			num++;
			int temp = num;
			while(temp >0) {
				if(temp % 1000 == 666) {
					cnt ++;
					break;
				}else {
					temp /= 10;
				}
			}
		}
		
		System.out.println(num);

	}

}
