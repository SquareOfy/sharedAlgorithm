import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class Main {


    static List<String> list;
    static int[] selected;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        int len = str.length();
        selected =new int[2];
        list = new ArrayList<>();
        //1 ~ N-2
        pickSlicePoint(str, len, 1, 0);
        Collections.sort(list);

        System.out.println(list.get(0));





    }

    public static void pickSlicePoint(String str,int len, int idx, int cnt){
        if(cnt==2){
            String str1 = str.substring(0, selected[0]);
            String str2 = str.substring(selected[0], selected[1]);
            String str3 = str.substring(selected[1],len);
            StringBuilder sb1 = new StringBuilder(str1);
            StringBuilder sb2 = new StringBuilder(str2);
            StringBuilder sb3 = new StringBuilder(str3);
            String result = sb1.reverse().toString() + sb2.reverse().toString() + sb3.reverse().toString();
            list.add(result);
            return;
        }

        for(int i=idx; i<len; i++){
            selected[cnt] = i;
            pickSlicePoint(str, len, i+1, cnt+1);
        }


    }
}