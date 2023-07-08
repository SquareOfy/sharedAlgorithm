import java.io.*;
import java.util.*;
class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        Stack<Integer> dStack = new Stack<>();     
        Stack<Integer> pStack = new Stack<>();    
        
        for(int i=0; i<n; i++){
            dStack.push(deliveries[i]);
            pStack.push(pickups[i]);
        }
        
        while(!dStack.isEmpty() || !pStack.isEmpty()){
            
            while(!dStack.isEmpty() && dStack.peek()==0){
                dStack.pop();
            }
              while(!pStack.isEmpty() && pStack.peek()==0){
                pStack.pop();
            }
            
            answer += 2*Math.max(dStack.size(), pStack.size());
            int dtrunk = 0;
            while(!dStack.isEmpty()){
                int now = dStack.pop();
                if(dtrunk+now <=cap){
                    dtrunk += now;   
                }else{
                    dStack.push(dtrunk+now-cap);
                    break;
                }
            }
            int ptrunk = 0;
            while(!pStack.isEmpty()){
                int now = pStack.pop();
                if(ptrunk+now <=cap){
                    ptrunk+=now;
                }else{
                    pStack.push(ptrunk+now-cap);
                    break;
                }
            }
                
        }
        return answer;
    }
}