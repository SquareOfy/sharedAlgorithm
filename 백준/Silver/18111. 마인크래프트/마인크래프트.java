
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int[][] map;
	static int N;
	static int M;
	static int B;
	static int resultH;
	static int resultT;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); //행
		M = Integer.parseInt(st.nextToken()); //열
		B = Integer.parseInt(st.nextToken()); //인벤토리 블록 개수
		
		
		map = new int[N][M];
		int min = 257;
		int max = -1;
		
		for(int n=0; n<N; n++) {
			st = new StringTokenizer(br.readLine());
			for(int m=0; m<M; m++) {
				map[n][m] = Integer.parseInt(st.nextToken());
				if(map[n][m]>max) max = map[n][m];
				if(map[n][m]<min) min = map[n][m];
			}
		}
		
		
		resultH = -1;
		resultT = Integer.MAX_VALUE;
		
		
		
		
		
		for(int i=min; i<=max; i++) {
			makeGround(i);
		}
		
		System.out.println(resultT + " " + resultH);
		
	}

	
	static void makeGround(int num) {
		int blocks = B;
		int time = 0;
		for(int n=0; n<N; n++) {
			for(int m=0; m<M; m++) {
				int gap = map[n][m]-num;
				if(gap>0) {
					blocks += gap;
					time += 2*gap;
				}else if(gap<0) {
					blocks-=Math.abs(gap);
					time+= Math.abs(gap);
					
					
					
				}
			}
		}
		if(blocks <0 ) return;
		
		if(time<=resultT) {
			resultT = time;
			resultH = Math.max(num, resultH);
		}
		
	}
}
