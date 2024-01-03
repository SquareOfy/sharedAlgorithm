import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] seq = new int[N];
        boolean[] visited = new boolean[N];
        int negative = 0;
        int positive = 0;
        long sum = 0;
        for(int n=0; n<N; n++){
            seq[n] = Integer.parseInt(br.readLine());
            sum += seq[n];
            if(seq[n]>0) positive++;
            else if(seq[n]<=0) negative++;
        }

        Arrays.sort(seq);

        long tieSum = 0;
        if(N>1){
            if(negative%2==0){
                for(int i=0; i<negative; i+=2){
                    tieSum += ((long) seq[i] *seq[i+1]);
                }
            }else{
                for(int i=0; i<negative-1; i+=2){
                    tieSum += ((long) seq[i] * seq[i+1]);
                }
                tieSum+= seq[negative-1];
            }

            if(positive%2==0){
                for(int i=N-1; i>negative; i-=2){
                    if(seq[i]==1 || seq[i-1]==1){
                        tieSum +=(seq[i]+seq[i-1]);

                    }else{
                        tieSum+= ((long) seq[i] *seq[i-1]);
                    }
                }
            }else{
                for(int i=N-1; i>negative+1; i-=2){
                    if(seq[i]==1 || seq[i-1]==1){
                        tieSum +=(seq[i]+seq[i-1]);

                    }else{
                        tieSum+= ((long) seq[i] *seq[i-1]);
                    }
                }
                tieSum+=seq[negative];
            }

            System.out.println(Math.max(tieSum, sum));
        }else{
            System.out.println(sum);
        }




    }
}