import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = 10;
		for(int s = 0; s<t; s++) {
			int n = Integer.parseInt(br.readLine());
			int[] lst = new int[100];
			StringTokenizer st;
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i<100; i++) {
				lst[i] = Integer.parseInt(st.nextToken());
			}
			
			while(n>0) {
				n--;
				Arrays.sort(lst);
				lst[0] += 1;
				lst[lst.length-1] -= 1;

			}
			Arrays.sort(lst);
			System.out.printf("#%d %d\n",s+1,lst[lst.length-1] - lst[0]);

		}
		
		
	}

}