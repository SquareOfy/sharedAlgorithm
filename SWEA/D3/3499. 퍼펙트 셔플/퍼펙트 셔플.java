import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
 
public class Solution {
    static String[] queue;
    static int front;
    static int rear;
     
            public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         
        int T = Integer.parseInt(br.readLine().trim());
         
        for(int t=1; t<=T; t++) {
            int N = Integer.parseInt(br.readLine());
            create(N);
            String[] card = br.readLine().split(" "); 
             
            if(N%2 ==0) {
                for(int i=0; i<N/2; i++) {
                    enQueue(card[i]);
                    enQueue(card[N/2+i]);
                }
                System.out.print("#"+t+" ");
                print();
                System.out.println();
                 
                 
        }else if(N%2 != 0) {
                for(int i=0; i<N/2+1; i++) {
                    enQueue(card[i]);
                    if(N/2+1+i<N) enQueue(card[N/2+1+i]);
                }
                System.out.print("#"+t+" ");
                print();
                System.out.println();
            }
        }
    }
             
    static void create(int n) {
        queue = new String[n];
        front = -1;
        rear = -1;
         
    }
     
    static void enQueue(String s) {
        if(isFull()) {
            System.out.println("큐가 가득 찼습니다.");
        }else queue[++rear] = s;
    }
    static String deQueue() {
        if(isEmpty()) {
            return "-1";
        }else {
            return queue[++front];
        }
    }
     
    static boolean isFull() {
        if(rear == queue.length-1) {
            return true;
        }else return false;
    }
     
    static boolean isEmpty() {
        if(rear == front) return true;
        return false;
    }
     
    static int size() {
        return rear-front;
    }
     
    static void print() {
        int k = size();
        for(int i=0; i<k; i++) {
            System.out.print(deQueue()+" ");
        }
    }
     
 
     
}