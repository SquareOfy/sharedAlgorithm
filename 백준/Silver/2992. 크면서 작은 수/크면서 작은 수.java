import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int N;
    static boolean[] visited;
    static int[] arr;
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        N = Integer.parseInt(str);

        arr = new int[str.length()];

        for(int i=0; i<str.length(); i++){
            arr[i] = str.charAt(i)-'0';
        }
        visited = new boolean[str.length()];

        answer = Integer.MAX_VALUE;


        perm(0, "");
        System.out.println(answer==Integer.MAX_VALUE? 0 :answer);

    }

    public static void perm(int cnt, String number){
        if(cnt==arr.length){
            if(number.charAt(0)-'0'==0) return;
            int result = Integer.parseInt(number);
            if(result>N){
                answer=Math.min(answer, result);
            }
        }

        for(int i=0; i<arr.length; i++){
            if(!visited[i]){
                visited[i] = true;
                perm(cnt+1, number+arr[i]);
                visited[i]= false;
            }
        }
    }
}