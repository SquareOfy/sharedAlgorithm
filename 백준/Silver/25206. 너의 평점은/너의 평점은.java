import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		Map<String, Double> Grades = new HashMap<String, Double>();

		Grades.put("A+", 4.5);
		Grades.put("A0", 4.0);
		Grades.put("B+", 3.5);
		Grades.put("B0", 3.0);
		Grades.put("C+", 2.5);
		Grades.put("C0", 2.0);
		Grades.put("D+", 1.5);
		Grades.put("D0", 1.0);
		Grades.put("F", (double) 0);

		double sum = 0;
		int creditSum = 0;
		for (int t = 1; t <= 20; t++) {
			st = new StringTokenizer(br.readLine());
			String title = st.nextToken();
			double credit = Double.parseDouble(st.nextToken());
			String grade = st.nextToken();
			if (!grade.equals("P")) {
				creditSum += credit;
				sum += credit * Grades.get(grade);
			}
		}
		
		System.out.printf("%6f",sum / creditSum);

	}

}