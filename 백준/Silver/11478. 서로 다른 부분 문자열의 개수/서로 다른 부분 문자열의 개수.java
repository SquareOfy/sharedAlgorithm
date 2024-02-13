import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String str = br.readLine();

        HashMap<String, Boolean> map = new HashMap<>();

        for(int i=0; i<str.length(); i++){
            for(int j=i+1; j<=str.length(); j++){
                map.put(str.substring(i, j), true);
            }
        }

        System.out.println(map.size());
    }
}