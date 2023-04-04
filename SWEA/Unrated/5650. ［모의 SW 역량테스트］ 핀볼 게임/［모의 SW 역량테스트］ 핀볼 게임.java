
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution {

	    static int[] dr = {-1, 0, 1, 0}; //상, 좌 , 하, 우
	    static int[] dc = {0, -1, 0, 1};
	    static int N;
	    static int[][] map;
	    static int stRow;
	    static int stColumn;
	    static boolean flag;
	    //1번부터 5번 블록을 만났을 때 방향의 변화 시켜주는 배열
	    //상좌하우일 때
	    static int[][] block = {
	            {2,0,3,1}, {3,2,0,1}, {1,3,0,2}, {2,3,1,0}, {2,3,0,1}};    
	    
	    //상하좌우일 때 
//	    static int[][] block = {
//	            {1,3,0,2}, {3,0,1,2}, {2,0,3,1}, {1,2,3,0}, {1,0,3,2}};    
	    
	    static int score;

	    public static void main(String[] args) throws NumberFormatException, IOException {
//	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//	        StringTokenizer st;
	        Scanner sc = new Scanner(System.in);
	        int T = sc.nextInt();
	        
	        for(int t=1; t<=T; t++) {
	            N = sc.nextInt();
	            map = new int[N][N];
	            
	            for(int r=0; r<N; r++) {
	                for(int c=0; c<N; c++) {
	                    map[r][c] = sc.nextInt();
	                }
	            }
	            
	            score = 0;
	            int max = 0;
	            for(int r=0; r<N; r++) {
	              outer: for(int c=0; c<N; c++) {
	                    for(int dir=0; dir<4; dir++) {
	                    	flag = false;
	                    	if(map[r][c]!=0) continue outer;
	                        stRow = r;
	                        stColumn = c;
	                        play(r, c, dir);
	                        if(score > max) max = score;
	                        score = 0;
	                    }
	                }
	            }
	        
	            
	            System.out.println("#"+t+" "+max);
	        
	        

	        }
	    }
	    
	    static void play(int r, int c, int dir) {
	        if(flag && r==stRow && c == stColumn) return;
	        flag = true;
	        //벽에 막히면 반대방향으로 가기
	        if(r >= N || r <0 || c>=N || c<0  ) {
	            dir=(dir+2)%4;
	            score++;
	        }
	        //블록을 만나면 방향 바꾸기
	        else if(map[r][c]>= 1 && map[r][c]<=5) {
	            dir = block[map[r][c]-1][dir];
	            score ++;
	        }
	        
	        else if(map[r][c] >=6 && map[r][c]<=10){
	            int[] hole = findHole(map[r][c], r, c);
	            r = hole[0];
	            c= hole[1];
	            
	        }else if(map[r][c]==-1) return;
	        int du = dr[dir];
	        int dv = dc[dir];
	        play(r+du, c+dv, dir);
	            
	    }
	    

	    static int[] findHole(int num, int r, int c) {
	        int[] result = new int[2];
	        for(int i=0; i<N; i++) {
	            for(int j=0; j<N; j++) {
	                if(map[i][j]==num && (i!=r || j!=c)) {
	                    result[0] = i;
	                    result[1] = j;
	                }
	            }
	        }
	        
	        return result;
	    }
	}
	    

