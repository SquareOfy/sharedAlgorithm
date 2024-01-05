import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {


    static Map<Integer, Integer> map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T=Integer.parseInt(br.readLine());


        for(int t=0; t<T; t++){
            PriorityQueue<Integer> asc = new PriorityQueue<>();
            PriorityQueue<Integer> desc = new PriorityQueue<>(Collections.reverseOrder());
            map = new HashMap<>();


            int N = Integer.parseInt(br.readLine());
            for(int i=0; i<N; i++){
                st = new StringTokenizer(br.readLine());

                String order = st.nextToken();

                int num = Integer.parseInt(st.nextToken());


                if(order.charAt(0) == 'I'){
                    asc.add(num);
                    desc.add(num);
                    map.put(num, map.getOrDefault(num, 0)+1);


                }else{
                    if(map.size()==0 || asc.isEmpty() || desc.isEmpty()) continue;
                    if(num == -1){

                        delete(asc);


                    }else{
                        delete(desc);

                    }
                }




            }

            if(map.isEmpty()||desc.isEmpty() || asc.isEmpty()){
                sb.append("EMPTY").append("\n");
            }else{
                int res = delete(desc);
                sb.append(res).append(" ");
                if(!map.isEmpty()) res = delete(asc);
                sb.append(res).append("\n");
            }






        }

        System.out.println(sb.toString());

    }

    public static int delete(PriorityQueue<Integer> pq){

        int num = 0;
        while(true){
            num = pq.poll();
            int cnt = map.getOrDefault(num, 0);
            if(cnt == 0) continue;
            if(cnt==1) map.remove(num);
            else map.put(num, cnt-1);
            break;
        }

        return num;




    }


}