import java.io.*;
import java.util.*;

class Solution {
    public List<Integer> solution(String today, String[] terms, String[] privacies) {
         int N = privacies.length;
        
        String[][] priva = new String[N][2];
        String[][] splitTerms = new String[terms.length][2];
       
        for(int n=0; n<N; n++){
            priva[n] = privacies[n].split(" ");
            
        }
        
        for(int m=0; m<terms.length; m++){
            splitTerms[m] = terms[m].split(" ");
        }
        
        List<Integer> list = new LinkedList<>();
        
        String[] dead = new String[3];
        int[] deadline = new int[3];
        String[] comp = today.split("\\.");
        int[] comparison = new int[3];
        
        for(int n=0; n<N; n++){
            dead = priva[n][0].split("\\.");
            for(int i=0; i<3; i++){
                deadline[i] = Integer.parseInt(dead[i]);
                comparison[i] = Integer.parseInt(comp[i]);
            }
            
            for(int m=0; m<terms.length; m++){
                //약관종류가 같을 때를 찾기
                if(priva[n][1].equals(splitTerms[m][0])){
                    //일 1 빼고 0 이 되면 28로 바꾼 후 월을 1 빼기
                    //월도 0이되면 12로 바꾸고 연도를 1 빼기
                    deadline[2]--;
                    if(deadline[2]==0){
                        deadline[2] = 28;
                        deadline[1] --;
                        if(deadline[1]==0) {
                            deadline[1] = 12;
                            deadline[0]--;
                        }
                    }
                    //하루를 빼놓은 deadline에서 유효기간 더하기.
                    int plus = Integer.parseInt(splitTerms[m][1]);
                    //24 27 
                    //24 
                    //mm  = 12 0
                    //yy = +1  +2
                    int mm = deadline[1]+plus%12;
                    
                    if(mm>12) {
                        deadline[0]+= mm/12;
                        mm %= 12;
                       
                     
                    }
                    deadline[1] = mm;
                    deadline[0] += plus/12;
                    
                    // System.out.println(n + " : " + Arrays.toString(deadline));
                 
                    break;
                }else continue;
            }
           
                //연도 비교
                if(deadline[0]<comparison[0]) list.add(n+1);
                else if(deadline[0]==comparison[0] && deadline[1]<comparison[1]) list.add(n+1);
                else if(deadline[0]==comparison[0] && deadline[1]==comparison[1] && deadline[2]<comparison[2]) list.add(n+1);
                
            
            
        }
        
        
    
        int[] answer = new int[list.size()];
        for(int i=0; i<list.size(); i++){
            answer[i] = list.get(i)+1;
        }
     
        
        return list;
    }
}