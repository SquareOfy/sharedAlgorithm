import java.util.*;
import java.io.*;
class Solution {
    static HashMap<String, Integer> map;
    public String[] solution(String[] orders, int[] course) {
        List<String> list = new ArrayList<>();
    
        for(int i=0; i<course.length; i++){
            
            map = new HashMap<>();
            
            for(int j=0; j<orders.length; j++){
                if(orders[j].length()<course[i]) continue;
                char[] arr = orders[j].toCharArray();
                Arrays.sort(arr);
                String str = "";
                for(int k=0; k<arr.length; k++){
                    str+= Character.toString(arr[k]);
                }
                pickMenu(str, course[i], 0, "");
                
            }
            
            List<String> menu = new ArrayList<>();
            map.forEach((k,v)->{
                if(v>=2) menu.add(k);
            });
            Collections.sort(menu, new Comparator<String>(){
                @Override
                public int compare(String o1, String o2){
                    return map.get(o2)-map.get(o1);
                }
            });
            
            int max = menu.size()!=0 ? map.get(menu.get(0)) : 0;
            for(String str : menu){
                if(map.get(str)==max) list.add(str);
                else break;
            }
            
            
        }
        
        
        String[] answer = list.toArray(new String[list.size()]);
        Arrays.sort(answer);
        return answer;
    }
    
    static void pickMenu(String str, int k, int idx, String result){
        
        if(result.length()==k){
            map.put(result, map.getOrDefault(result, 0)+1);
            return;
        }
        for(int i=idx; i<str.length(); i++){
            String add = str.substring(i, i+1);
            pickMenu(str, k, i+1, result+add);
        }
    }
}