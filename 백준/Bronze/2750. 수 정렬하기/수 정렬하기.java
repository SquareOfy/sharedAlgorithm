

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        int[] input = new int[N];

        for(int i=0; i<N; i++){
            input[i] = Integer.parseInt(br.readLine());
        }


        insertionSort(input);

        //출력
        for(int i=0; i<N; i++){
            sb.append(input[i]).append("\n");
        }

        System.out.println(sb.toString());
    }



    public static void insertionSort(int[] input){
        for(int i=1; i<input.length; i++){
            int key = input[i];

            int j= i-1;
            while(j>=0 && key <input[j]){
                input[j+1]=input[j];
                j--;
            }

            input[j+1] = key;

        }
    }


}
