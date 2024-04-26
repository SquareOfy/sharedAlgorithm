import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int[] line = new int[3];
        while (true) {
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 3; i++) {
                line[i] = Integer.parseInt(st.nextToken());
            }

            if (line[0]== 0 && line[1] == 0 && line[2] == 0) break;


            Arrays.sort(line);
            if(line[2]>=line[0]+line[1]) sb.append("Invalid\n");
            else {
                if (line[0] == line[1] && line[1] == line[2]) sb.append("Equilateral\n");
                else if (line[0] == line[1] || line[1] == line[2] || line[0] == line[2]) sb.append("Isosceles\n");
                else sb.append("Scalene\n");
            }
        }

        System.out.println(sb.toString());
    }
}