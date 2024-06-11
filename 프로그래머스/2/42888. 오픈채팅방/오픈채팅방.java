import java.util.*;
class Solution {
    public String[] solution(String[] record) {
        
        
        String[] answer;
        
        int n = record.length;
        int cnt =0;
        HashMap<String, String> map = new HashMap<>();
        
        //이름 세팅
        for(int i=0; i<n; i++){
            String[] order = record[i].split(" ");
            if(order[0].equals("Enter") || order[0].equals("Change")){
                map.put(order[1], order[2]);
            }
            
            if(order[0].equals("Enter")||order[0].equals("Leave")) cnt++;
        }
        
        answer = new String[cnt];
        
        int idx =0;

        for(int i=0; i<n; i++){
            StringBuilder sb = new StringBuilder();
            String[] order = record[i].split(" ");
            String nick = map.get(order[1]);
            

            if(order[0].equals("Change")) continue;
            if(order[0].equals("Enter")){
                sb.append(nick).append("님이 들어왔습니다.");

            }else if(order[0].equals("Leave")){
                sb.append(nick).append("님이 나갔습니다.");
            }
                answer[idx] = sb.toString();
                idx++;
        }
        
        return answer;
    }
}