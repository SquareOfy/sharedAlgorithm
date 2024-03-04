import java.util.*;
class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        
        Arrays.sort(phone_book);
   
        int len = phone_book.length;
        
        for(int i=0; i<len-1; i++){
            String target = phone_book[i];
            if(target.length()>phone_book[i+1].length()) continue;
            if(phone_book[i+1].substring(0, target.length()).equals(target)) return false;
        }
        
        
//         for(int i=0; i<len-1; i++){
//             String target = phone_book[i];
            
//             outer : for(int j=0; j<len; j++){
//                 if(i!=j){
//                     //number
//                     String number = phone_book[j];
//                     if(number.length()<target.length()) continue;
//                     for(int k=0; k<target.length(); k++){
//                         if(target.charAt(k) != number.charAt(k)) continue outer;
//                         if(k==target.length()-1) return false;
//                     }
//                     // String number_front = number.substring(0, target.length());
//                     // if(number_front.equals(target)) return false;
//                 }
//             }
//         }
        
        
        return true;
    }
}