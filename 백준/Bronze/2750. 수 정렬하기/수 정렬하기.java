import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] input = new int[N];

        for(int i=0; i<N; i++){
            input[i] = Integer.parseInt(br.readLine());
        }


        heapSort(input);
        for(int i=0; i<N; i++){
            sb.append(input[i]).append("\n");
        }

        System.out.println(sb.toString());
    }



    public static void heapSort(int[] input){


        //트리구조를 최대 힙 구조로 바꾸기
        for(int i=1; i<input.length; i++){
            int c = i;



            do{
                int root = (c-1) /2;

                if(input[root]<input[c]){
                    swap(input, root, c);

                }
                c = root;
            }while(c!=0);




        }


        //크기를 줄여가며 반복적으로 힙을 구성
        for(int i= input.length -1; i>=0; i--){


            //가장 큰 값을 맨 뒤로 보내기
            swap(input, 0, i);
            int root = 0;
            int c=1;

            //힙 구조 만들기
            do{
                c = 2*root+1;

                if(c<i-1 && input[c] < input[c+1] ){
                    c++;
                }

                if(c<i && input[root] < input[c]){
                    swap(input, root, c);
                }

                root =c;
            }while(c<i);


        }

    }

    public static void swap(int[] input, int idx1, int idx2){
        int tmp = input[idx1];

        input[idx1] = input[idx2];
        input[idx2] = tmp;
    }


}