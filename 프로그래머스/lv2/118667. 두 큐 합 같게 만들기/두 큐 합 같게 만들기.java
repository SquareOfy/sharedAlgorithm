import java.io.*;
import java.util.*;
class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        long total = 0;
        long q1Sum = 0;
        long q2Sum = 0;
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        for(int i=0; i<queue1.length; i++){
            total+= queue1[i];
            q1Sum += queue1[i];
            q1.add(queue1[i]);
        }
         for(int i=0; i<queue2.length; i++){
            total+= queue2[i];
            q2Sum += queue2[i];
            q2.add(queue2[i]);
        }
        
        if(total%2 != 0) return -1;
        
        while(q1Sum != q2Sum){
            if(q1Sum>q2Sum){
                if(!q1.isEmpty()){
                    int tmp = q1.poll();
                    q2.add(tmp);
                    q1Sum -= tmp;
                    q2Sum += tmp;
                    answer++;
                }
            }else{
                if(!q2.isEmpty()){
                    int tmp = q2.poll();
                    q1.add(tmp);
                    q1Sum+=tmp;
                    q2Sum-=tmp;
                    answer++;
                }
            
        }
            if(answer>(queue1.length + queue2.length)*4) {
                return -1;
            }
        
        
        }
        return answer;
    }
}