import java.util.*;
class Solution {
    public int[] solution(String s) {
        int[] answer = {};
        
        String str = s.substring(1,s.length()-1);
        String[] arr = str.split("}");
        
        for(int i=0; i<arr.length; i++){
            if(arr[i].charAt(0)==','){
                arr[i] = arr[i].substring(2);
                if(arr[i].charAt(arr[i].length()-1)==','){
                    arr[i] = arr[i].substring(0, arr[i].length()-1);
                }
            }else{
                arr[i] = arr[i].substring(1, arr[i].length());
            }
        }
        
        Arrays.sort(arr, new Comparator<String>(){
            @Override
            public int compare(String o1, String o2){
                return o1.length()-o2.length();
            }
        });
        
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<arr.length; i++){
            String[] arr2 = arr[i].split(",");
            for(String v : arr2){
                int num = Integer.parseInt(v);
                if(list.contains(num)) continue;
                list.add(num);
            }
        }
        
        answer = list.stream().mapToInt(i ->i).toArray();

        return answer;
    }
}