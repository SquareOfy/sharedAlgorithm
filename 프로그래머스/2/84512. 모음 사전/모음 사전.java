
class Solution {
    static String[] alpha = new String[] {"A","E","I","O","U"};
    static int answer;
    static boolean flag;
    static int idx;
    public int solution(String word) {
        answer = Integer.MAX_VALUE;
        
        //???????????????????????????
        //테케부터 이해 안감 ..
        makeDictionary("", word);

        return answer;
    }
    
    public static void makeDictionary(String str, String word){

        if(str.equals(word)){
            answer = idx;
            flag = true;
            return;
        }

        for(int i=0; i<5; i++){
            if(str.length()<5 && !flag){
                idx ++;
                makeDictionary(str+alpha[i], word);
            }
            
        }
    }
}