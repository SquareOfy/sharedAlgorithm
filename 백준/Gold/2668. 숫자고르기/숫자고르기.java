import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();


    static int N;
    static int[] arr;
    static List<Integer> answer = new ArrayList<>();
    static List<Integer>[] idxList;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {

        input();

        for(int n=1; n<=N; n++){
            if(!visited[n]) {
                Set<Integer> set = new HashSet<>();

                dfs(n, set);
            }

        }


        Collections.sort(answer);

        sb.append(answer.size()).append("\n");

        for(int i=0; i<answer.size(); i++){
            sb.append(answer.get(i)).append("\n");
        }

        System.out.println(sb.toString());

    }
    public static void dfs(int i, Set<Integer> list){
        visited[i] = true;
        Set<Integer> newList = new HashSet<>(list); // 복사
        newList.add(i);
//        list.add(i);

        for(int num : idxList[i]){
            if(list.contains(num)){
                answer.addAll(newList);
                return;
            }else{
                dfs(num, newList);
            }
        }

    }

    public static void input() throws IOException {
        N = Integer.parseInt(br.readLine());

        arr = new int[N+1];

        visited = new boolean[N+1];
        idxList = new List[N+1];
        for(int n=1; n<=N; n++){
            idxList[n] = new ArrayList<>();
        }

        for(int n=1; n<=N; n++){
            arr[n] = Integer.parseInt(br.readLine());
            idxList[arr[n]].add(n);

        }
    }

}