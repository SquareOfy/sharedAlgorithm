import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
	
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		char[][] map = new char[5][15];
		int max =0;
		for(int i=0; i<5;i++) {
			String str = sc.next();
			max = Math.max(max, str.length());
			for(int j=0; j<str.length(); j++) {
				map[i][j] = str.charAt(j);
			}
		}
		
		for(int i=0; i<max; i++) {
			for(int j=0; j<5; j++) {
				if(map[j][i]!='\u0000') {
					sb.append(map[j][i]);
				}else continue;
			}
		}
		
		System.out.println(sb.toString());
		
	}
}