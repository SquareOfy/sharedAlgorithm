import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N;
    static List<Integer> primeList;

    public static void main(String[] args) throws IOException {
        input();
        primeList = new ArrayList<>();

        fillPrimeList();

        int cnt =0;
        if(primeList.size()==0){
            System.out.println(cnt);
        }else {
            int left = 0;
            int right = 0;
            int sum = primeList.get(0);

            while (left<primeList.size()) {

                if(sum<N){
                    right++;
                    if(right==primeList.size()) break;
                    sum+=primeList.get(right);
                }else{
                    if(sum==N) {
                        cnt++;
                    }
                    sum-=primeList.get(left);
                    left++;
                }

            }

            System.out.println(cnt);
        }


    }

    public static void fillPrimeList(){
        for(int n=1; n<=N; n++){
            if(isPrime(n)){
                primeList.add(n);
            }
        }
    }

    public static boolean isPrime(int n){

        if(n==1) return false;
        if(n==2) return true;

        for(int i=2; i<=Math.ceil(Math.sqrt(n)); i++){
            if(n%i==0) return false;
        }
        return true;
    }
    public static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
    }
}