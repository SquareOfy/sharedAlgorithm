import java.util.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        Map<String, Integer> map = new HashMap<>();
        
        for(String person : participant){
            map.put(person, map.getOrDefault(person, 0)+1);
        }
        
        for(String person : completion){
            map.put(person, map.get(person)-1);
            if(map.get(person)==0) map.remove(person);
        }
        
        List<String> list = new ArrayList<>(map.keySet());
   
        answer = list.get(0);
        return answer;
    }
}