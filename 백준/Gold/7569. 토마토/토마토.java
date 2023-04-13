import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
	
static int[] dr = {0,0,-1,1,0,0};
static int[] dc = {0,0,0,0,-1,1};
static int[] dh = {-1,1,0,0,0,0};

static int[][][] map;


static int H,N,M;

static Queue<Node> queue = new LinkedList<>();

static class Node{
	int r;
	int c;
	int h;
	int rank;
	
	Node(int h, int r, int c, int rank){
		this.h = h;
		this.r = r;
		this.c = c;
		this.rank = rank;
	}
}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st;
		
		st= new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		map = new int[H][N][M];
		
		for(int h=0; h<H; h++) {
			for(int n=0; n<N; n++) {
				st = new StringTokenizer(br.readLine());
				for(int m=0; m<M; m++) {
					map[h][n][m] = Integer.parseInt(st.nextToken());
					if(map[h][n][m]==1) {
						queue.add(new Node(h,n,m,0));
					}
				}
			}
		}
		
		System.out.println(BFS());


	}

	static int BFS() {
		int result =0;
		while(!queue.isEmpty()) {
			Node now = queue.poll();
			result = now.rank;
			for(int i=0; i<6; i++) {
				int dk = now.h + dh[i];
				int du = now.r + dr[i];
				int dv = now.c + dc[i];
				
				if(dk<0 || dk>=H || du <0 || du>=N || dv <0 || dv>=M ) continue;
				
				if(map[dk][du][dv]==0) {
					map[dk][du][dv]=1;
					queue.add(new Node(dk, du, dv, now.rank+1));
				}
			}
		}
		if(checkTomato()) return result;
		else return -1;
		
		
	}
	static boolean checkTomato() {
		for(int h=0; h<H; h++) {
			for(int r=0; r<N; r++) {
				for(int c=0; c<M; c++) {
					if(map[h][r][c] == 0) return false;
				}
			}
		}
		return true;
	}
}