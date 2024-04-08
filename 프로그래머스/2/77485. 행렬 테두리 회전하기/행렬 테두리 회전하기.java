import java.util.*;

class Solution {
    static int[][] map;
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        map = new int[rows+1][columns+1];
        int idx =1 ;
        for(int i=1; i<=rows; i++){
            for(int j=1; j<=columns; j++){
                map[i][j] = idx++;
            }
        }
        for(int i=0; i<queries.length; i++){
            int min = rotate(queries[i]);
            answer[i] = min;
        }
        
        return answer;
    }
    public static int rotate(int[] arr){
        
        int startR = arr[0];
        int startC = arr[1];
        int endR = arr[2];
        int endC = arr[3];
        
        //시작지점 tmp로 기억
        int tmp = map[startR][startC];
        int result = tmp;
        //위로 밀기
        for(int r=startR; r<endR; r++){
            map[r][startC] = map[r+1][startC];
            result = Math.min(map[r][startC], result);
        }
        
        //왼쪽으로 밀기
        for(int c=startC; c<endC; c++){
            map[endR][c] = map[endR][c+1];
            result = Math.min(map[endR][c], result);
        }
        
        //아래로 밀기
        for(int r=endR; r>startR; r--){
            map[r][endC] = map[r-1][endC];
            result = Math.min(map[r][endC], result);
        }
        
        //오른쪽으로 밀기
        for(int c=endC; c>startC+1; c--){
            map[startR][c] = map[startR][c-1];
            result = Math.min(map[startR][c], result);
        }
        
        
        
        map[startR][startC+1] = tmp;
        
        
        return result;
    }
}