import java.util.*;

class Solution {
    static int[] dr = new int[] {-1, 0, 1, 0};
    static int[] dc = new int[] {0, -1, 0, 1};
    
    static int answer;
    static boolean[][] visited;
    static int N,M;
    static boolean flag;
    
    public static class Node{
        int r;
        int c;
        int cnt;
        
        Node(int r, int c, int cnt){
            this.r = r;
            this.c = c;
            this.cnt = cnt;
        }
    }
    
    public int solution(int[][] maps) {
        
        int INF = Integer.MAX_VALUE ;
        answer = INF;
        N = maps.length;
        M = maps[0].length;
        visited = new boolean[N][M];
        
        Queue<Node> queue = new LinkedList<>();
        
        queue.add(new Node(0,0,1));
        while(!queue.isEmpty()){
            Node now = queue.poll();
            if(now.r ==N-1 && now.c==M-1){
                answer = now.cnt;
                break;
            }
            for(int i=0; i<4; i++){
                int du = now.r + dr[i];
                int dv = now.c + dc[i];
                if(du<0 || dv<0 || du>=N || dv>=M) continue;
                if(maps[du][dv]==1 && !visited[du][dv]){
                    visited[du][dv] = true;
                    queue.add(new Node(du, dv, now.cnt+1));
                }
            }
        }
        
        
        return answer ==INF ? -1 : answer;
    }
    
//     public static void dfs(int[][] map,int r, int c, int cnt){
        
        
//         if(r==N-1 && c==M-1) {
//             answer = Math.min(cnt, answer);
//         }
        
//         for(int i=0; i<4; i++){
//             int du = r + dr[i];
//             int dv = c + dc[i];
//             if(du<0 || dv<0 || du>=N || dv>=M) continue;
//             if(map[du][dv]==1 && !visited[du][dv] ){
//                 visited[du][dv]=true;
//                 dfs(map, du, dv, cnt+1);
//                 visited[du][dv]=false;
//             }
            
//         }
     
        
//     }
}