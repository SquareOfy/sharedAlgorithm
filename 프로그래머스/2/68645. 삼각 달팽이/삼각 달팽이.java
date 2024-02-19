import java.util.*;

class Solution {
    public List solution(int n) {
        List<Integer> list = new ArrayList<>();
        
        
        int[][] arr = new int[n][n];
        
        int idx = 2;

        arr[0][0] = 1;
        int r = 0;
        int c = 0;
        int max = n * (n+1) /2;
        
        
    while(idx<=max){
        //아래로 가기
        //만약 아래 행 + 같은 열이 0이면 거기로 숫자 채우기
        while(idx<=max){
            if(r+1<n && arr[r+1][c]==0) {
                arr[r+1][c] = idx++;
                r++;
            }else{
                break;
            }
        }        
        
        //0이 아니거나 범위를 넘어가면
        
        
        //오른쪽으로 가기
        //오른쪽으로 이동 같은 행 + 오른쪽 열이 0 이면 거기 숫자 채우기
        while(idx<=max){
        
      
            if(c+1<n && arr[r][c+1]==0){
                arr[r][c+1] = idx++;
                c++;
            }else break;
        }
        
        
        //0이 아니거나 범위 넘어가면 
        
        //위로 가기
        //윗 행 + 같은열-1에 0 아니면 채우기
        while(idx<=max){
            if(r-1>=0 && c-1 >=0 && arr[r-1][c-1]==0){
                arr[r-1][c-1] = idx++;
                r--;
                c--;
            }else break;
        }
    }
    

        
        for(int i=0; i<n; i++){
            for(int j=0; j<=i; j++){
               list.add(arr[i][j]);
            }
        }
        
        
        
        return list;
    }
}