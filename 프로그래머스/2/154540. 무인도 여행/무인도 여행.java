import java.util.*;


class Solution {
    static boolean[][] visited;
    static int[][] map;

    static int[] dr = new int[] {-1, 0, 1, 0};
    static int[] dc = new int[] {0, -1, 0, 1};
    static int cnt;
    public List<Integer> solution(String[] maps) {
        List<Integer> answer = new ArrayList<>();
        
        
        int N = maps.length;
        int M = maps[0].length();
        
        map = new int[N][M];
        visited = new boolean[N][M];
        for(int n=0; n<N; n++){
            for(int m=0; m<M; m++){
                if(maps[n].charAt(m)!='X'){
                    map[n][m] = maps[n].charAt(m)-'0';
                }
            }
        }
        
        for(int n=0; n<N; n++){
            for(int m=0; m<M; m++){
                if(!visited[n][m] && map[n][m]!=0){
                    cnt = 0;
                    dfs(n,m);
                    if(cnt!=0) answer.add(cnt);
                }
            }
        }
        
        if(answer.size()==0) answer.add(-1);
        Collections.sort(answer);
        
        
        
        return answer;
    }
    
    public static void dfs(int n, int m){
        visited[n][m] = true;
        cnt += map[n][m];
        
        for(int i=0; i<4; i++){
            int du = n + dr[i];
            int dv = m + dc[i];
            if(du<0 || dv<0 || du>=map.length || dv>=map[0].length) continue;
            if(!visited[du][dv] && map[du][dv]!=0){
                dfs(du, dv);
            }
        }
        
    }
}