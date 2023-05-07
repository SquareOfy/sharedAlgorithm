
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, -1, 0, 1};
    static int dir;
    static int[][] map;
    static boolean[][] visited;
    static int cnt;
    static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st;

        
        int[] findD = new int[] {0, 3, 2, 1};
        st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        
        int sR = Integer.parseInt(st.nextToken());
        int sC = Integer.parseInt(st.nextToken());
        
        dir = findD[Integer.parseInt(st.nextToken())];
        cnt =0;
        
        map = new int[N][M];
        visited = new boolean[N][M];
        for(int n=0;n <N; n++) {
            st = new StringTokenizer(br.readLine());
            for(int m=0; m<M; m++) {
                map[n][m] =Integer.parseInt(st.nextToken());
            }
        }
        if(map[sR][sC] ==0) {
        	visited[sR][sC] = true;
        	cnt ++;
        }
        clean(sR, sC);
    
        System.out.println(cnt);
        
     
        
    }
    
    static void clean(int r, int c) {
   
    	//사방 탐색
        	boolean flag = false;
            for(int i=0; i<4; i++) {
                int du = r+dr[i];
                int dv = c+dc[i];
                if(du>=0 && du<N && dv>=0 && dv<M && map[du][dv]==0 && !visited[du][dv]) {
                	flag=true;
                	break;
                }
            }
            //사방 중에 하나라도 있다면 
            if(flag) {
            	//90도 회전(앞 쪽이 청소되지 않은 칸일 때까지)
            	while(true) {
            		dir= (dir+1)%4;
            		int du = r + dr[dir];
            		int dv = c + dc[dir];
            		if(du>=0 && du<N && dv>=0 && dv<M && map[du][dv]==0 && !visited[du][dv]) {
            			visited[du][dv]=true;
            			cnt ++;
            			clean(du,dv);
            			break;
            		}
            			
            	}
            
            	//사방 중 청소할 곳이 없다면
            }else {
            	//후진할 수 있는지 확인 후 후진
            	int d = (dir+2)%4; //후진 방향
            	int du = r+dr[d];
            	int dv= c+dc[d];
            	if(du<0 || du>=N || dv<0 || dv>=M || map[du][dv]==1) {
            		
            		return;
            	}
            	
            	clean(du,dv);
            }
        }
    
    
    
   
}


