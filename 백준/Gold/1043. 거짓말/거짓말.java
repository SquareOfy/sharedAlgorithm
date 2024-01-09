import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static List<Integer> truthList;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        int N = Integer.parseInt(st.nextToken());//사람 수
        int M = Integer.parseInt(st.nextToken());//파티 수


        //부모노드 배열 세팅
        int[] p = new int[N + 1];
        for (int n = 1; n <= N; n++) {
            p[n] = n;
        }


        //진실을 들은 사람들
         truthList = new ArrayList<>();


        st = new StringTokenizer(br.readLine());
        //진실을 아는 사람 수
        int peopleCnt = Integer.parseInt(st.nextToken());

        //진실을 아는 사람 수가 0 이면 모든 파티 참석 가능
        if (peopleCnt == 0) {
            System.out.println(M);

        }else {
            for (int k = 0; k < peopleCnt; k++) {
                int num = Integer.parseInt(st.nextToken());
                truthList.add(num);
            }

            List<Integer>[] list = new ArrayList[M];
            for (int i = 0; i < M; i++) {
                list[i] = new ArrayList<>();
            }
            //파티 수만큼 입력 받기
            for (int m = 0; m < M; m++) {
                st = new StringTokenizer(br.readLine());
                //몇명이 오는가
                int num = Integer.parseInt(st.nextToken());

                int first = Integer.parseInt(st.nextToken());
                list[m].add(first);
                for (int n = 1; n < num; n++) {
                    int next = Integer.parseInt(st.nextToken());
                    list[m].add(next);
                    unionParent(p, first, next);
                }

            }


            int cnt = M;
            outer:
            for (int m = 0; m < M; m++) {
                for (int n = 0; n < list[m].size(); n++) {
                    if (truthList.contains(getParent(p, list[m].get(n)))) {
                        cnt--;
                        continue outer;
                    }
                }
            }
            System.out.println(cnt);
        }


    }

    public static int getParent(int[] p, int a){
        if(p[a]==a) return a;
        return getParent(p, p[a]);
    }

    public static void unionParent(int[] p, int a, int b){
        int n = getParent(p, a);
        int m = getParent(p, b);
        if(truthList.contains(m)){
            int tmp = n;
            n = m;
            m = tmp;
        }
        p[m] = n;


    }


    public static boolean findParent(int[] p, int a, int b){
        a = getParent(p, a);
        b = getParent(p, b);
        if(a==b) return true;
        else return false;
    }
}