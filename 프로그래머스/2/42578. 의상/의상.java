import java.util.*;
class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        
        Map<String, Integer> map = new HashMap<>();
        
        for(int i=0; i<clothes.length; i++){
            map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 0)+1);
        }
        
        List<Integer> list = new ArrayList<>(map.values());
        for(int i : list){
            answer *=(i+1);
        }
        answer--;
        return answer;
    }
}