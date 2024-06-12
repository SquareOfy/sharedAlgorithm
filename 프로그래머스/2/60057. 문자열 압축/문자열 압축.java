class Solution {
    public int solution(String s) {
        int answer = Integer.MAX_VALUE;
        
        int n = s.length();
    
        
        for(int i=1; i<=n ; i++ ){ 

            String before = s.substring(0, i);

            int cnt =1;
        
            int len =0;
            for(int j=i; j<=n-i; j+=i){
                String next = s.substring(j, j+i);

                if(before.equals(next)){
                    cnt++;
                }else{
                    
                    if(cnt==1){
                        len += i;  
                    }else{
                        len +=i;
                        len += String.valueOf(cnt).length();
                        
    
                    }
                    before = next;
                    cnt = 1;
                }
            }
            
            len += i;
            if(cnt>1) len += String.valueOf(cnt).length();
            len+= n%i;
            
            if(len==0) len = n;
            answer = Math.min(len, answer);
            
        
        
        }
        return answer;
    }
}