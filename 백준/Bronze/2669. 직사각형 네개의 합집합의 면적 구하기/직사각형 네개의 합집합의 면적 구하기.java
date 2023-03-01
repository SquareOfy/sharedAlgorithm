import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		boolean[][] coordinate = new boolean[101][101];
		
		for(int t=0; t<4; t++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken()); //왼쪾 아래 점 열번호
			int y1 = Integer.parseInt(st.nextToken()); //왼쪽 아래 점 행번호
			
			int x2 = Integer.parseInt(st.nextToken()); //왼쪾 아래 점 열번호
			int y2 = Integer.parseInt(st.nextToken()); //왼쪽 아래 점 행번호
		
			
			for(int r=y1; r<y2; r++) {
				for(int c = x1; c<x2; c++) {
					coordinate[r][c] =true;
				}
			}
		}
		
		int area =0;
		for(int r=0; r<101; r++) {
			for(int c=0; c<101; c++) {
				if(coordinate[r][c]) area ++;
			}
		}
	
		
		System.out.println(area);
		
		
		

	}

}