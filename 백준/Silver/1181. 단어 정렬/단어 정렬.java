import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Map<String, Integer> words = new HashMap<>();
		
		int N = Integer.parseInt(br.readLine());
		
		for(int n=0; n<N; n++) {
			String str = br.readLine();
			words.put(str, str.length());
		}
		
		List<Map.Entry<String,Integer>> list = new LinkedList<>(words.entrySet());
		
		Collections.sort(list, new Comparator<Map.Entry<String, Integer>>(){

			@Override
			public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
				if(o1.getValue()==o2.getValue()) {
					return o1.getKey().compareTo(o2.getKey());
					
				}else
				return o1.getValue()-o2.getValue();
			}
			
		});
		
		for(Entry<String, Integer> word : list){
			System.out.println(word.getKey());
		}
	}

}
