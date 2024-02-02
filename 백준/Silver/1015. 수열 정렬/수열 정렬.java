import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;

        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] sortedArr = new int[N];
        st= new StringTokenizer(br.readLine());

        for(int n=0; n<N; n++){

            arr[n] = Integer.parseInt(st.nextToken());
            sortedArr[n] = arr[n];
        }





        Arrays.sort(sortedArr);



        for(int n=0; n<N; n++){
            for(int j=0; j<N; j++){
                if(arr[n]==sortedArr[j]){
                    sb.append(j).append(" ");
                    sortedArr[j] = -1;
                    break;
                }
            }
        }


        System.out.println(sb.toString());




    }
}