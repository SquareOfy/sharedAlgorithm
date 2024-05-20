class Solution
{
    public int solution(int n, int a, int b)
    {
        int answer = 1;

        if(a>b){
            int tmp = b;
            b = a;
            a = tmp;
        }
   
        while(n>0){
            if(b-a==1 && b%2==0) break;
             answer++;
            
            if(a%2==0) a/=2;
            else a=(a/2)+1;
        
            if(b%2==0) b/=2;
            else b=(b/2)+1;

            
            n/=2;
        }
        

        return answer;
    }
}