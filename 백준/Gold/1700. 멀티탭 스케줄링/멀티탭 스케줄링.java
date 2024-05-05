import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N,K;
    static int[] arr;
    static int[] multi;
    static int[] memo;
    public static void main(String[] args) throws IOException {
        input();

        int notBlank =0;
        int answer =0;
       outer : for(int i=0; i<K; i++){
           int item = arr[i];
           memo[item] --;

           //이미 멀티탭에 꽂혀있는지 확인하고 있으면 continue;
           for(int n=0; n<N; n++){
               if(multi[n]== item){
                    continue outer;
               }
           }

           //없으면 콘센트 빈칸 있으면 넣고 빈칸 없으면 뽑을거 찾기
            if(notBlank<N){
                multi[notBlank]=arr[i];
                notBlank++;
            }else{
                //지금 콘센트에 꽂혀있는 물건들 중 남은 사용횟수가 0인 아이템 찾기
                answer ++;
                for(int n=0; n<N; n++){
                    int num = multi[n];
                    if(memo[num]==0){
                        multi[n] = item;
                        continue outer;
                    }
                }

                // 없으면 뒤에 가장 늦게 나오는 애를 뽑기
                int target =0;
                int max = 0;
                for(int j=0; j<N; j++){
                    int num = multi[j];
                    for(int k=i+1; k<K; k++){
                        if(arr[k]== num){
                            if(max < k){
                                max = k;
                                target = j;
                            }
                            break;
                        }
                    }
                }

                multi[target] = item;

            }
        }

        System.out.println(answer);

    }

    public static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[K];
        memo = new int[K+1];
        multi = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int n=0; n<K; n++){
            arr[n] = Integer.parseInt(st.nextToken());
            memo[arr[n]] ++;
        }
    }

}