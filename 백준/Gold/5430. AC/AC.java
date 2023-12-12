import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T =Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int t=1; t<=T; t++){
            String order = br.readLine();
            int len = Integer.parseInt(br.readLine());
            String input = br.readLine();

            String arrString = input.substring(1, input.length()-1);

            String[] arr = arrString.split(",");

//            System.out.println(Arrays.toString(arr));

            int idx = 0;
            int finishIdx = len-1;

            boolean isFront = true;
            boolean flag = true;
            for(int i=0; i<order.length(); i++){
                if(order.charAt(i)=='R'){
                    int tmp = idx;
                    idx = finishIdx;
                    finishIdx = tmp;
                    if(isFront) isFront = false;
                    else isFront = true;
                }else{
//                    System.out.println("idx in D : " + idx);
//                    System.out.println("finishIdx in D " + finishIdx);
                    if(isFront) idx++;
                    else idx --;
                    len --;
                    if(len<0){
                        flag = false;
//                        System.out.println("ERROR");
                        sb.append("error").append("\n");
                        break;
                    }

                }
            }
            if(flag){
                sb.append("[");

                if(isFront){

                    for(int i=idx; i<=finishIdx; i++){
                        sb.append(arr[i]);
                        if(i!=finishIdx) sb.append(",");

                    }
                }else{

                    for(int i=idx; i>=finishIdx; i--){
                        sb.append(arr[i]);
                        if(i!=finishIdx) sb.append(",");
                    }
                }

                sb.append("]").append("\n");
            }



        }
        System.out.println(sb.toString());
    }
}