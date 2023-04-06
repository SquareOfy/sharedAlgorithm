import java.util.Scanner;

public class Main{
	static char[][] map ;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int N = sc.nextInt();
		map = new char[N][N];
		
		fillStar(0,0,N);
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				sb.append(map[i][j] == 0 ? ' ' : map[i][j]);
			}
			if(i!=N-1) sb.append("\n");
					
		}
		
		System.out.println(sb.toString());
	}
	static void fillStar(int r, int c, int len) {
		if(len==3) {
			for(int i=0; i<len; i++) {
				for(int j=0; j<len; j++) {
					map[r+i][c+j] = '*';
					if(i==1 && j==1) map[r+i][c+j] = ' ';
				}
			}
			return;
		}
		
		len = len/3;
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				if(i==1 && j==1) continue;
				fillStar(r+len*i, c+len*j, len);
			}
		}
	}
}
