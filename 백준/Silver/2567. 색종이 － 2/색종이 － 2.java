import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[][] place = new int[102][102];

		int T = Integer.parseInt(br.readLine());
		
		for(int t=0; t<T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			for(int i=0; i<10; i++) {
				for(int j=0; j<10; j++) {
					place[x+i][y+j] = 1;
				}
			}		
		}
		int len = 0;
		for(int i=1; i<101; i++) {
			for(int j=1; j<101; j++) {
				if(place[i][j]==1) {
					if(place[i][j+1]==0) len++;
					if(place[i][j-1]==0) len++;
					if(place[i-1][j]==0) len++;
					if(place[i+1][j]==0) len++;
				}
			}
		}
		System.out.println(len);
	}
}
