import java.util.*;
class Solution {
    static int[] dr = {0, 0, -1, 1}; 
    static int[] dc = {1,-1, 0, 0};

    static boolean result;
    static boolean[][] visited;
    
    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        Arrays.fill(answer, 1);
        outer : for(int t=0; t<5; t++){
            
            int[][] map = new int[5][5];
            
            //map setting
            for(int r=0; r<5; r++){
                String str = places[t][r];
                for(int c=0; c<5; c++){
                    if(str.charAt(c)=='P') map[r][c] =1;
                    else if(str.charAt(c)=='X') map[r][c] = -1;
                }
            }
            
            // System.out.println("t : "+t);

          
            //하나라도 사람 존재하면 종료 시키기 
            for(int r=0; r<5; r++){
                for(int c=0; c<5; c++){
                    if(map[r][c]==-1||map[r][c]==0) continue;
                    visited = new boolean[5][5];
                    result = true;
                    // System.out.println("r ; "+ r+ " c : "+ c + " dfs 호출");
                    visited[r][c] =true;
                    dfs(map, r, c, 0, false);
                    // System.out.println("result : " + result);
                    if(!result) {
                        answer[t] = 0;
                        continue outer;
                    }
                    
                }
            } 
            
        }
        return answer;
    }
    
    static void dfs(int[][] map,  int r, int c, int cnt, boolean hasPartition){
    
        
        if(!result) return;
        if(cnt==2){
            return;
        }
        
        for(int i=0; i<4; i++){
            int du = r+dr[i];
            int dv = c+dc[i];
            
            if(du<0 || dv<0 || du>=5 || dv>=5 || visited[du][dv]) continue;
            if(map[du][dv]==1 && !hasPartition){
                result=false;
                return;
            }
            
    

            if(map[du][dv]==-1){
                visited[du][dv] = true;
                dfs(map, du, dv, cnt+1, true);
                visited[du][dv] = false;
            }else{
                visited[du][dv] = true;
                dfs(map, du, dv, cnt+1, hasPartition);
                visited[du][dv] = false;
            }
    
            
        }
    }
}