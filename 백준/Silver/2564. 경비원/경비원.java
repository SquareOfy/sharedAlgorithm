import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int w = sc.nextInt(); int h = sc.nextInt();
		int n = sc.nextInt();
		int[] direction = new int[n];
		int[] distance = new int[n];
			for(int i=0; i<n; i++) {
				direction[i] = sc.nextInt();
				distance[i] = sc.nextInt();
			}
		int myDirection = sc.nextInt();
		int myDistance = sc.nextInt();
		
		int sum = 0;
		for(int i=0; i<n; i++) {
			if(myDirection == direction[i]) {
				sum+= Math.abs(myDistance-distance[i]);
			}else {
				if(myDirection ==1 ) {
					if(direction[i] == 2) {
						sum += h+Math.min(distance[i]+myDistance, Math.abs(w-distance[i]+w-myDistance));
						
					}else if (direction[i]==3) {
						sum+= distance[i]+myDistance;
					}else {//4
						sum+=distance[i]+w-myDistance;
					}
					
				}else if(myDirection == 2) {
					if(direction[i] == 1) {
						sum += h+Math.min(distance[i]+myDistance, w-distance[i]+w-myDistance);
					}else if (direction[i]==3) {
						sum+= h-distance[i]+myDistance;
					}else {
						sum+=h-distance[i]+w-myDistance;
					}
				}else if(myDirection ==3) {
					if(direction[i] == 4) {
						sum += w+Math.min(distance[i]+myDistance, h-distance[i]+h-myDistance);
						
					}else if (direction[i]==1) {
						sum+= distance[i]+myDistance;
					}else {//2
						sum+=w-distance[i]+myDistance;
					}
				}else { //4
					if(direction[i] == 3) {
						sum += w+Math.min(distance[i]+myDistance, h-distance[i]+h-myDistance);
						
					}else if (direction[i]==1) {
						sum+= w-distance[i]+myDistance;
					}else {//2
						sum+=w-distance[i]+myDistance;
					}
				}
			}
		
		}
		System.out.println(sum);
	}

}
