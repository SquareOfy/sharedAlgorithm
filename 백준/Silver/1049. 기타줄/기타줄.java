import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] setPrice = new int[M];
        int[] itemPrice = new int[M];

        int setMin = Integer.MAX_VALUE;
        int itemMin = Integer.MAX_VALUE;
        int setNum = N/6;

        for(int m=0; m<M; m++){
            st = new StringTokenizer(br.readLine());

            setPrice[m] = Integer.parseInt(st.nextToken());
            if(setPrice[m]<setMin) setMin = setPrice[m];

            itemPrice[m] = Integer.parseInt(st.nextToken());
            if(itemPrice[m] < itemMin) itemMin = itemPrice[m];


        }


        int result = Integer.MAX_VALUE;
        int setCnt = 0;
        int itemCnt = N;

        while((setCnt*6 > N && itemCnt>-6) || itemCnt>=0){


            int price = setCnt*setMin;

            if(itemCnt>=0) price += itemCnt*itemMin;

            result = Math.min(result, price);
            itemCnt -=6;
            setCnt ++;


        }

        System.out.println(result);
    }
}