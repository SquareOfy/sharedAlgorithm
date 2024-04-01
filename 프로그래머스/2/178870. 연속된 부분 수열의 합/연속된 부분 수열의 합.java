import java.util.*;
class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        int n = sequence.length;

        int left = 0;
        int right = 0; 
        long sum = sequence[0];
        
        int min = Integer.MAX_VALUE;
        
        while(true){
            if(sum<k){
                right ++;
                if(right>=n) break;
                sum+=sequence[right];
            }else if(sum>k){
                sum-=sequence[left]; 
                left++;
                if(left>=n) break;
            }else {
                if(right-left+1 < min){
                    min = right-left+1;
                    answer[0] = left;
                    answer[1] = right;
                }
                    sum -=sequence[left];
                    left++;
                    right++;
                    if(right>=n) break;
                    sum += sequence[right];
                
            }
        }
        
        
    
        
        return answer;
    }
}