import java.io.*;
class Solution {
    static int[] sales = {10, 20, 30, 40};
    static int[] pickedSales;
   
    static int[] answer;
 
    
    public int[] solution(int[][] users, int[] emoticons) {
        answer = new int[2];
        pickedSales = new int[emoticons.length];
       
        perm(users, emoticons, 0);
        return answer;
    }
    
    public static void perm(int[][] users, int[] emoticons, int idx){
            int N = emoticons.length;
          
            if(idx == N){
                int cnt =0;
                int sellPrice = 0;
                
                for(int i=0; i<users.length; i++){
                    int price = 0;
                    for(int j=0; j<N; j++){
                         if(users[i][0]<=pickedSales[j]){
                             price += emoticons[j]*((double)(100-pickedSales[j])/100);
                         }
                    }
                    if(price>=users[i][1]) cnt++;
                    else{
                        sellPrice += price;
                    }
                   
                }
                if(answer[0]<cnt){
                    answer[0] = cnt;
                    answer[1] = sellPrice;
                }else if(answer[0]==cnt && answer[1]<sellPrice){
                    answer[1] = sellPrice;
                }
              return;
            }
        
            for(int j=0; j<4; j++){
                 pickedSales[idx] = sales[j];
                 perm(users, emoticons, idx+1);
            }
          
        }
    
}