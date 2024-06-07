import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int r, c, k;
    static int[][] map;


    public static void main(String[] args) throws IOException {

        input();

        int rowLen = 3;
        int colLen = 3;

        int time = 0;

        Map<Integer, Integer> cntMap = new HashMap<>();
        while(time<100){

            if(map[r][c]==k) {
                break;
            }

            if(rowLen>=colLen){

                //map에 넣기

                int max= 0;
                for(int i=0; i<rowLen; i++){
                    cntMap.clear();
                    for(int j=0; j<colLen; j++){
                        if(map[i][j]!=0) cntMap.put(map[i][j], cntMap.getOrDefault(map[i][j],0)+1);
                    }

                    //map을 value 순으로 정렬

                    List<Integer> list = sort(cntMap);


                    int idx =0;
                    Arrays.fill(map[i], 0);
                    for(int j=0; j<Math.min(100, list.size()); j++){
                        map[i][idx++] = list.get(j);
                        map[i][idx] = cntMap.get(map[i][idx-1]);
                        idx++;
                    }

                    max = Math.max(Math.min(100, list.size()*2), max);
               }

                colLen = max;

            }else{

                int max =0;
                for(int c =0; c<colLen; c++){
                    cntMap.clear();
                    for(int r=0; r<rowLen; r++){
//                        if(map[r][c]==0) break;
                        if(map[r][c]!=0) cntMap.put(map[r][c], cntMap.getOrDefault(map[r][c],0)+1);
                    }

                    //map을 value 순으로 정렬

                    List<Integer> list = sort(cntMap);


                    int idx =0;

                    for(int j=0; j<100; j++){
                        map[j][c] = 0;
                    }
                    for(int j=0; j<Math.min(100, list.size()); j++){
                        map[idx++][c] = list.get(j);
                        map[idx][c] = cntMap.get(map[idx-1][c]);
                        idx++;
                    }

                    max = Math.max(Math.min(list.size()*2, 100), max);
                }

                rowLen = max;

            }

            time++;


        }

        System.out.println(map[r][c]==k ? time : -1);



    }

    static List<Integer> sort(Map<Integer, Integer> cntMap){
        //map을 value 순으로 정렬

        List<Integer> list = new ArrayList<>(cntMap.keySet());
        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(cntMap.get(o1)-cntMap.get(o2)==0){
                    return o1-o2;
                }
                return cntMap.get(o1)-cntMap.get(o2);
            }
        });

        return list;
    }

    static void input() throws IOException {
        st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken())-1;
        c = Integer.parseInt(st.nextToken())-1;
        k = Integer.parseInt(st.nextToken());

        map = new int[100][100];


        for(int i=0; i<3; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<3; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }
}