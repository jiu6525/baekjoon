import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

/*
 * 					2						//2134567
 * 			1				3
 * 		4		5		6		7
 * 
 * 
 * 
 * 		0추가 후 힙정렬
 * 
 * 
 * 					0						//01325674
 * 			1				3
 * 		2		5		6		7
 * 4
 * 

 * 
 */

public class Main {
	
//	절대값이 가장 작은 값이 여러개 일때 -> 그중 가장 작은수
//	배열에서 절댓값이 가장 작은 값
//	가장 작은수
	static PriorityQueue<Integer> pq = new PriorityQueue<Integer>(new Comparator<Integer>() {

		@Override
		public int compare(Integer o1, Integer o2) {
			if(Math.abs(o1) > Math.abs(o2)) {
				return Math.abs(o1) - Math.abs(o2);
			}else if(Math.abs(o1) == Math.abs(o2)) {
				return o1 - o2;
			}else {
				return -1;
			}
		}
		
	});
	
	public static void main(String[] args) throws NumberFormatException, IOException {
//		System.setIn(new FileInputStream("src/jiu/Solution.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

//		pq 가 비었을때는 0 출력, 아닐경우 pq.poll
		for(int i = 0; i<n; i++) {
			int num = Integer.parseInt(br.readLine());
			if(num == 0) {
				if(pq.isEmpty()) {
					System.out.println("0");
				}else {
					System.out.println(pq.poll());
				}
			}else {
				pq.offer(num);
			}
		}

	}

}
