import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		char[][] map = new char[N][N];
		
		for(int r=0; r<N; r++) {
			String str= br.readLine();
			for(int c=0; c<N; c++) {
				map[r][c] = str.charAt(c); 
			}
		}
		int max =0;
		for(int r=0; r<N; r++) {
			char temp;
			for(int c=0; c<N; c++) {
				//오른쪽이 있으면 오른쪽이랑 자리 바꾸기
				if(c!=N-1) {
					temp = map[r][c];
					map[r][c] = map[r][c+1];
					map[r][c+1] = temp;
					max = Math.max(checkLongest(map),max);

					
					map[r][c+1] = map[r][c];
					map[r][c] = temp;
					}
					
				
				
				//아래가 있으면 아래랑 자리 바꾸기
				if(r!=N-1) {
					temp = map[r][c];
					map[r][c] = map[r+1][c];
					map[r+1][c] = temp;
					max = Math.max(checkLongest(map),max);
					
					map[r+1][c] = map[r][c];
					map[r][c] = temp;
				}
			}
		}
	
		System.out.println(max);
	}
	
	static int checkLongest(char[][] map) {
		int N = map.length;
		int max =0;
		int[][] result = new int[N][N];
		for(int r=0; r<N; r++) {
			for(int c=0; c<N; c++) {
				//세로로 연속된 동일 문자 길이 체크
				int len1 = 1;
				int len2 = 1;
				for(int k=1; k<N-r; k++) {
					if(map[r][c]==map[r+k][c])  len1 ++;
					else break;
				}
				for(int k=1; k<N-c; k++) {
					if(map[r][c]==map[r][c+k])  len2 ++;
					else break;
				}
				
				result[r][c] = Math.max(len1, len2);
				
			
			
			}
			max = Math.max(Arrays.stream(result[r]).max().getAsInt(), max);
		}
		return max;
	}
	

}