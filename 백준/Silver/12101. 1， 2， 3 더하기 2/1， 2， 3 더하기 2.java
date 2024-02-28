import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        List<String> list = new LinkedList<>();


        sort("",0, n, list);
        if(list.size()<k) System.out.println(-1);
        else System.out.println(list.get(k-1));

    }


    public static void sort(String str, int now, int n, List<String> list){

        if(now==n){
            list.add(str);
            return;
        }
        for(int i=1; i<=3; i++){
            String tmp = str;
            if(now+i <n){

                tmp += i+"+";
                sort(tmp, now+i, n, list);
            }else if(now+i ==n){
                tmp += i;
                sort(tmp, now+i, n, list);
            }else{
                break;
            }

        }
    }
}