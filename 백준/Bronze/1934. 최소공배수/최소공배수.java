import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for(int t=0; t<T; t++){

            int a = sc.nextInt();
            int b = sc.nextInt();
            int d = gcd(a,b);

            System.out.println(a*b /d);
        }
    }


    public static int gcd(int a, int b){
        while(b!=0) {
            int r = a%b;

            a= b;
            b = r;

        }

        return a;
    }
}