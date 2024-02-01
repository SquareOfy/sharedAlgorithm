import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Main {

    //class로 하려다가 방법 수정.
    //전체를 정렬할 필요 없으므로,,
//    public static class Card implements Comparable<Card> {
//
//        long num;
//        int cnt;
//
//        public Card(long num, int cnt){
//            this.cnt= cnt;
//            this.num=num;
//        }
//        @Override
//        public int compareTo(Card o) {
//            if(this.cnt != o.cnt){
//                return o.cnt - this.cnt;
//
//            }else{
//                if(o.num - this.num >0) return -1;
//                else if(o.num == this.num) return 0;
//                else return 1;
//            }
//        }
//    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        HashMap<Long, Integer> map = new HashMap<>();

        int max = 0;
        Long maxNum = Long.MAX_VALUE;

        for(int n=0; n<N; n++){


            long num = Long.parseLong(br.readLine());
            if(map.containsKey(num)) {
                map.put(num, map.get(num) +1);
                //num이 더 크면 comparison 양수


                //위 if문에서 compareTo가 아니라 - 를 처음에 사용했다가 23%에서 틀림
                //아마 long 범위 벗어난듯
            }
            else map.put(num, 1);

        }

        for(Long key : map.keySet()){
            int comparison = map.get(key).compareTo(max);
            if(comparison>0) { //num이 더 크면 max와 maxNum 교체
                max = map.get(key);
                maxNum = key;
                //두 cnt가 같으면 두 수 중 작은 수를 maxNum으로
            }else if(comparison==0){
                if(maxNum.compareTo(key)>0){//maxNum이 더 크면 maxNum을 num으로 교체
                    maxNum = key;
                }
            }
        }

        System.out.println(maxNum);


//        List<Card> list = new ArrayList<>();
//        List<Long> keySet = new ArrayList<>(map.keySet());
//        for(long num : keySet){
//            list.add(new Card( num, map.get(num)));
//        }


    }
}