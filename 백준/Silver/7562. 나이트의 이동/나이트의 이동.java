
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
	static int I;
	static boolean[][] map;
	
 
	static int edR;
	static int edC;
	
	static int[] dr = {-1, -2, -2, -1, 1, 2, 2, 1};
	static int[] dc = {-2, -1, 1, 2, 2, 1, -1, -2};

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=0; t<T; t++) {
			I = Integer.parseInt(br.readLine());
			map = new boolean[I][I];
			
			st = new StringTokenizer(br.readLine());
			int stR = Integer.parseInt(st.nextToken());
			int stC = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			edR = Integer.parseInt(st.nextToken());
			edC = Integer.parseInt(st.nextToken());
			
			System.out.println(BFS(stR, stC));
		}
	}
	
	static int BFS(int stR, int stC) {
		Queue<int[]> queue = new LinkedList<int[]>();
		
		queue.add(new int[]{stR, stC, 0});
		map[stR][stC] = true;
		
		while(!queue.isEmpty()) {
			int[] now = queue.poll();
			if(now[0]==edR && now[1] ==edC) return now[2];
			for(int i=0; i<8; i++) {
				int du = now[0]+dr[i];
				int dv = now[1]+dc[i];
				if(du>=0 && dv>=0 && du<I && dv<I) {
					
					if(!map[du][dv]) {
						queue.add(new int[] {du,dv,now[2]+1});
						map[du][dv]= true;
					}
				}
			}
		}
		return -1;
	}

}
