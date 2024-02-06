import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int N;

    static Node[] arr;
    static int deleteNum;

    public static class Node{
        int parent;
        Set<Integer> children;

        public Node(){
            this.children = new HashSet<>();
        }

        public Node(int parent){
            this.parent = parent;
            this.children = new HashSet<>();

        }


        public void addChildren(int child) {
            this.children.add(child);
        }
    }


    public static void main(String[] args) throws IOException {

        input();


        //부모의 children 목록에서 자기 자신 지우기
        int parent = arr[deleteNum].parent;
        if(parent != -1) arr[parent].children.remove(deleteNum);
        //노드와 그 아래 children 지우기


        dfs(deleteNum);
//        arr[deleteNum] = null;

        int cnt =0;
        for(int i=0; i<N; i++){
            if(arr[i] !=null) {
                if(arr[i].children.size()==0) cnt ++;
            }
        }

        System.out.println(cnt);
    }

    public static void dfs(int i) {
        for(int child : arr[i].children){
            dfs(child);
        }
        arr[i] = null;
    }


    public static void input() throws IOException {

        N = Integer.parseInt(br.readLine());

        arr = new Node[N];
        st = new StringTokenizer(br.readLine());

        for(int i=0; i<N; i++){
            int parent = Integer.parseInt(st.nextToken());
            if(arr[i] ==null) arr[i] = new Node(parent);
            else {
                arr[i].parent = parent;
            }
            if(parent!=-1){
                if(arr[parent]==null) arr[parent] = new Node();
                arr[parent].children.add(i);
            }

        }
        deleteNum = Integer.parseInt(br.readLine());


    }
}