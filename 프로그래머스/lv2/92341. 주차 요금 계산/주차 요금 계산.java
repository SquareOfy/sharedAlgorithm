import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        
        int N = records.length;
        String[][] recordsSplit = new String[records.length][3];
        
        for(int n=0; n<N; n++){
            recordsSplit[n] = records[n].split(" ");
        }
        
        Map<Integer, String> enterMap = new HashMap<>();
        TreeMap<Integer, Integer> timeMap = new TreeMap<>();
        List<Integer> list = new LinkedList<>();
        
        for(int i=0; i<N; i++){
            int num = Integer.parseInt(recordsSplit[i][1]);
            int min = 0;
            //입차 차량이면 입차 시간 기록
            if(recordsSplit[i][2].equals("IN")){
                enterMap.put(num, recordsSplit[i][0]);
            //출차한 적이 있는 차량의 시간 더하기
            //출차차량이면 기록된 입차시간 가져와서 배열로 만들기
            //출차시간도 배열로 만들기
            //두 시간의 차이 = min
            //min 값을 timeMap에 넣기(있으면 더하고 없으면 넣기)
            }else{
                //들어온 시간과 나간 시간 배열 생성 후 들어온 시간 기록하는 해시맵에서 해당 값 삭제
                String[] inTimeStr = enterMap.get(num).split(":");
                String[] outTimeStr = recordsSplit[i][0].split(":");
                enterMap.remove(num);
                
                int[] inTime = new int[2];
                int[] outTime = new int[2];
                for(int j =0; j<2; j++){
                    inTime[j] = Integer.parseInt(inTimeStr[j]);
                    outTime[j] = Integer.parseInt(outTimeStr[j]);
                }
                
    
                if(outTime[1]>=inTime[1]){
                    min += outTime[1]-inTime[1];
                    min += (outTime[0]-inTime[0])*60;
                }else{
                    min+= outTime[1]+60-inTime[1];
                    min+= (outTime[0]-1-inTime[0])*60;
                }
                if(timeMap.get(num)!=null){
                    timeMap.put(num, timeMap.get(num)+min);
                }else{
                    timeMap.put(num, min);
                }
                
            }
            
           
            }
         if (enterMap.size()!=0){
                
                // System.out.println("n: " +i +"일 때 "+ enterMap.size());
                Iterator<Integer> keys = enterMap.keySet().iterator();
                while(keys.hasNext()){
                    int min = 0;
                int key = keys.next();
                String[] inTimeStr = enterMap.get(key).split(":");
                min += 59 - Integer.parseInt(inTimeStr[1]);
                min += (23 - Integer.parseInt(inTimeStr[0]))*60;
                    
              if(timeMap.get(key)!=null){
                    timeMap.put(key, timeMap.get(key)+min);
                }else{
                    timeMap.put(key, min);
                }
                
}
            
        }
        
        Integer[] minutes = timeMap.values().toArray(new Integer[0]);
  
        
        
         int[] answer = new int[minutes.length];
       
        for(int m=0; m<minutes.length; m++){
            answer[m]+= fees[1];
            minutes[m] -= fees[0];
            
            if(minutes[m]>0){
                 answer[m]+=fees[3]*(minutes[m]/fees[2]);
                if(minutes[m]%fees[2]!=0){
                   answer[m]+= fees[3];
                }
            }
        }
        
       
        return answer;
    }
}