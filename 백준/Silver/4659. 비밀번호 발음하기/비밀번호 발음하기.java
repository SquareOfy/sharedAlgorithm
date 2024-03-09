import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Set<Character> set = new HashSet<>(Arrays.asList('a','e','i','o','u'));
        Map<Character, Integer> map = new HashMap<>();
        map.put('a', 0);
        map.put('e', 1);
        map.put('i',2);
        map.put('o',3);
        map.put('u', 4);

        int[] vowel = new int[5];

        while(true){
            String str = br.readLine();
            if(str.equals("end")) break;
            boolean isPossible = true;
            Arrays.fill(vowel, 0);


            //모음 나왔는지 여부
            boolean hasVowel = false;
            //같은 글자가 연속으로 나왔는지 여부


            char before ='0';
            int max = 1;

            boolean beforeVowel = false;
            int vowelMax =0;
            int conMax =0;
            for(int i=0; i<str.length(); i++){
                char c = str.charAt(i);
                
                //글자 수 앞에랑 같으면 max ++
                if(i!=0 && before==c) max++;
                else max =1;


                if(set.contains(c)){
                    hasVowel = true;                 //모음 나온거 체크
                    conMax = 0;
                    vowelMax ++;
                }else{
                    vowelMax = 0;
                    conMax ++;
                }

                //같은 글자 2개 연속이면 e이거나 o인 경우 빼고 false
                if(max==2 && !(c=='e' || c=='o')){
                    isPossible = false;
                    break;
                }
                
                //모음 또는 자음 3개 연속이면 false; 
                if(vowelMax==3 || conMax==3) {
                    isPossible = false;
                    break;
                }
                before = c;
                if(set.contains(before)){
                    beforeVowel = true;
                }else{
                    beforeVowel = false;
                }
            }

            if(hasVowel && isPossible) {
                sb.append("<").append(str).append("> is acceptable.\n");
            }else{
                sb.append("<").append(str).append("> is not acceptable.\n");

            }
        }

        System.out.println(sb.toString());


    }
}