class Solution {
    
    static long cnt;
    static int[] selected;
    static boolean[] visited;
    static int[] answer;
    static long[] factorial;
    public int[] solution(int n, long k) {
        
        
        factorial = new long[n+1];
        factorial[0] = 1;
        factorial[1] = 1;
        
        for(int i=2; i<=n; i++){
            factorial[i] = factorial[i-1]*i;
        }
        
        // n 3 
        
        // 1 : (n-1)! 2: + (n-1)! ... 
        
        //첫번째 자리 찾기 
        //k가 (n-1)! * i 중 어느 값 사이인지 찾아서 k보다 처음으로 커진 지점의 직전 수가 첫번째 자리 
        //두번째 자리 찾기 
        //n-2! ...
        
        
        selected = new int[n];
        visited = new boolean[n+1];
        dfs(n,k, 0);
        return selected;
    }
    public static void dfs(int n, long k, int idx){
        
        if(idx==n-1){
            for(int i=1; i<=n; i++){
                if(!visited[i]) {
                    selected[n-1] = i;
                    break;
                }
            }
            return;
        }
        
        //현재 cnt를 기준으로 idx번째에 들어갈 숫자를 찾자
        int j = 1;
        for(int i=1; i<=n; i++){
            //찾아야할 factorial = n-idx-1
            if(visited[i]) continue;
            long fac = factorial[n-idx-1];
     
            
            if( cnt+fac*(j-1)<k && k<=cnt+fac*j){
 
                
                selected[idx] = i;
                visited[i] = true;
                cnt+=fac*(j-1);
                dfs(n, k, idx+1);
                break;
            }
            j++;
        }
        
    }
    
    
//     public static void dfs(int n, long k, int last){
//         if(cnt==k) return;
//         if(last==n){
//             cnt ++;
//             return;
//         }
        
//         for(int i=1; i<=n; i++){
        
//             if(cnt==k) return;
//             if(visited[i]) continue;
//             selected[last] = i;
//             visited[i] = true;
//             dfs(n, k, last+1);
//             visited[i] = false;
//         }
        
//     }
}