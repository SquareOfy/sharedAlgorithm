import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static String str;
    static String bomb;


    public static void main(String[] args) throws IOException {
        input();

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char alpha = str.charAt(i);
            //stack에 넣기
            stack.add(alpha);

            //stack의 size가 bomb보다 크거나 같으면 비교
            int pointer = bomb.length() - 1;
            if (stack.size() >= bomb.length() && alpha==bomb.charAt(bomb.length()-1)) {
                Stack<Character> tmp = new Stack<>();

                for (int k = 0; k < bomb.length(); k++) {
                    char now = stack.pop();
                    tmp.add(now);
                    if (bomb.charAt(pointer) == now) {
                        pointer--;

                    } else {
                        while (!tmp.isEmpty()) {
                            char tmpAlph = tmp.pop();
                            stack.add(tmpAlph);
                        }
                    }
                }
            }


        }
        if (stack.isEmpty()) System.out.println("FRULA");
        else {
            StringBuilder sb = new StringBuilder();
            while (!stack.isEmpty()) {
                char now = stack.pop();
                sb.append(now);
            }

            System.out.println(sb.reverse().toString());
        }
    }

    public static void input() throws IOException {
        str = br.readLine();
        bomb = br.readLine();

    }
}