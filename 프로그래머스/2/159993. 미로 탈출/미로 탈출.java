import java.util.*;
class Solution {
    static int[] start;
    static int[] end;
    static int[] lever;
    static int answer1;
    static int answer2;
    static boolean[][] visited;
    static int[][] map;        
    static int[] dr = new int[] {-1, 0, 1, 0};
    static int[] dc = new int[] {0, -1, 0, 1};
    static int rowSize;
    static int columnSize;
    
    public static class Node{
        int r;
        int c;
        int rank;
        
        Node(int r, int c, int rank){
            this.r = r;
            this.c = c;
            this.rank = rank;
        }
    }
    
    
    public int solution(String[] maps) {
        answer1 = 0;
        answer2 = 0;
        columnSize = maps[0].length();
        rowSize = maps.length;
        map = new int[rowSize][columnSize];
        visited = new boolean[rowSize][columnSize];
        
        for(int i=0; i<rowSize; i++){
            for(int j=0; j<columnSize; j++){
                //시작지점
                if(maps[i].charAt(j)=='S'){
                    start = new int[] {i,j};
                //출구
                }else if(maps[i].charAt(j)=='E'){
                    end = new int[] {i,j};
                //레버
                }else if(maps[i].charAt(j)=='L'){
                    lever = new int[] {i,j};
                //벽
                }else if(maps[i].charAt(j) =='X'){
                    map[i][j] = 1;
                }
            }
        }

        
        //시작지점부터 레버까지 bfs
        answer1 = bfs(start, lever);
        if(answer1==-1) return -1;
        
        //visited reset
        for(int i=0; i<rowSize; i++){
            Arrays.fill(visited[i], false);
        }

        
        //레버부터 출구까지 bfs
        answer2 = bfs(lever, end);
        if(answer2==-1) return -1;
        return answer1 + answer2;
    }
    
    public static int bfs(int[] from, int[] to){
        
        Queue<Node> queue = new LinkedList<>();
        visited[from[0]][from[1]] = true;
        queue.add(new Node(from[0], from[1], 0));
        
        

        while(!queue.isEmpty()){
            Node now = queue.poll();

            
            
            if(now.r==to[0] && now.c==to[1]){
                return now.rank;
            }
            
            for(int i=0; i<4; i++){
                int du = now.r + dr[i];
                int dv = now.c + dc[i];
                if(du<0 || dv<0 || du>=rowSize || dv>=columnSize) continue;
                if(map[du][dv]==0 && !visited[du][dv]){
                    visited[du][dv] = true;
                    queue.add(new Node(du, dv, now.rank+1));
                }
                
            }
        }
        return -1;
        
    }
}