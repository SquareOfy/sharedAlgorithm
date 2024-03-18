import java.io.*;
import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        
        //discount의 i일째부터 10일 보기
        outer : for(int i=0; i<discount.length; i++){
            Map<String, Integer> map = new HashMap<>();

            for(int j=0; j<10; j++){
                if(i+j >= discount.length) break;
                //할인 품목 나온 횟수를 map에 저장
                String item = discount[i+j];
                map.put(item,map.getOrDefault(item, 0)+1);
            }
            
            //want를 돌며 map에 그 개수 이상이 있는지 체크.
            //하나라도 없다면 continue;
            for(int j=0; j<want.length; j++){
                String item = want[j];
                int cnt = number[j];
                if(map.getOrDefault(item, 0)<cnt) continue outer;
                if(j==want.length -1) answer ++;
            }
            
            
        }
        
        return answer;
    }
}