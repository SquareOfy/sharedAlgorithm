import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        
        //보조 컨테이너 벨트는 스택이냐 ~! !!?> !! 
        
        int idx = 1;
        
        Stack<Integer> stack = new Stack<>();
        
        for(int i=0; i<order.length; i++){
            
            int target = order[i];
            
            if(!stack.isEmpty()){
                if(stack.peek()==target){
                    stack.pop();
                    answer++;
                    continue;
                }
            }else if(idx>order.length) break;
            
            while(idx!=target){
                stack.push(idx);
                idx++;
                if(idx>order.length){
                    break;
                }
            }
            
            if(idx==target) answer++;
            idx++;
          
            if(answer == order.length) break;
            
        }
        
        
        return answer;
    }
}