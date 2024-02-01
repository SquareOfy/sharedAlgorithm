import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        //원래는 class를 선언해서 Comparable을 extends할 생각해봤으나 같은 확장자가 겹칠 수 있으므로 해시맵 활용
        HashMap<String, Integer> map = new HashMap<>();
        for(int n=0; n<N; n++){

            //정규식에서 .은 임의의 한 문자를 의미하므로 [.] 또는 \\. 방식으로 입력
            String[] str = br.readLine().split("[.]");
            String extension = str[1];

            if(map.containsKey(extension)) map.put(extension, map.get(extension)+1);
            else map.put(extension, 1);



        }

        //해시맵의 key들만 list로 모아서 정렬
        List<String> keySet = new ArrayList<>(map.keySet());

        Collections.sort(keySet);

        for(String extension : keySet){
            sb.append(extension).append(" ").append(map.get(extension)).append("\n");
        }

        System.out.println(sb.toString());


    }
}