import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        
        int[] arr = new int[W];


        st = new StringTokenizer(br.readLine());
        for(int i=0; i<W; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int answer =0;

        for(int i=1; i<W-1; i++){

            int leftHeight = 0;
            int rightHeight =0;
            for(int j=0; j<i; j++){
                if(arr[j]>arr[i]){
                    leftHeight = Math.max(leftHeight, arr[j]);
                }
            }

            for(int j=i+1; j<W; j++){
                if(arr[j]>arr[i]){
                    rightHeight = Math.max(rightHeight, arr[j]);
                }
            }

            if(Math.min(leftHeight, rightHeight)!=0) answer+= Math.min(leftHeight,rightHeight)-arr[i];


        }

        System.out.println(answer);


    }
}