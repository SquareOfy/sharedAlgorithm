import java.io.*;
import java.util.*;

class Solution {
    static int[] selected;
    static boolean[] visited;
    static int answer;
    public int solution(int k, int[][] dungeons) {
        
        answer = 0;
        
        int len = dungeons.length;
        selected = new int[len];
        visited = new boolean[len];
        
        perm(len,k, dungeons, 0);
        return answer;
    }
    
    public static void perm(int len, int k, int[][] arr, int cnt){
        
        if(cnt==len){
            //고른 순서대로 탐험해서 answer에 최대개수 갱신하기
            int health = k;
            int result =0;
            for(int i=0; i<len; i++){
                //뽑은 순서에서 최소 필요 피로도가 부족하면 for문 탈출
                int turn = selected[i];
                if(arr[turn][0]>health) break;
                health -= arr[turn][1]; //던전 탐험 후 소모 필요도만큼 피로도 감소
                result ++;
            }

            answer = Math.max(answer, result);
            
            
        }
        
        for(int i=0; i<len; i++){
            if(!visited[i]){
                selected[cnt] = i;
                visited[i] = true;
                perm(len, k, arr, cnt+1);
                visited[i] = false;
            }
        }
    }
}