import java.util.*;
class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;
        
        //문제 이해부터 안됨 ;
        Arrays.sort(data, new Comparator<int[]>(){
            public int compare(int[] o1, int[] o2){
                //col번째 컬럼값이 같으면 
                if(o1[col-1]-o2[col-1]==0){
                    
                    return o2[0]-o1[0];
                }
                
                return o1[col-1]-o2[col-1];
            }
        });

        
        
        for(int i=row_begin-1; i<=row_end-1; i++){
            int sum =0;
            for(int j=0; j<data[0].length; j++){
                sum += (data[i][j]%(i+1));
            }
            
            answer ^= sum;
        }
        
        return answer;
    }
}