
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	static int cnt, n, m, ans;
	static int[][] arr;
	static Queue<int[]> q = new LinkedList<>();;
	public static void main(String[] args) throws NumberFormatException, IOException {
		//System.setIn(new FileInputStream("src/jiu/Solution.txt"));
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		List<List<Integer>> v = new ArrayList<>();
		Queue<Integer> q = new LinkedList<>();
		int[] cnt = new int[n+1];
		for (int i = 0; i < n+1; i++) {
			v.add(i, new ArrayList<>());
		}
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			v.get(a).add(b);
			cnt[b]++;
		}
		
		for (int i = 1; i <= n; i++) {
			if(cnt[i] == 0) {
				q.add(i);
			}
		}
		
		ArrayList<Integer> result = new ArrayList<>();
		while(!q.isEmpty()) {
			int current = q.poll();
			result.add(current);
			for (int i = 0; i < v.get(current).size(); i++) {
				int temp = v.get(current).get(i);
				
				cnt[temp]--;
				
				if(cnt[temp] == 0) {
					q.add(temp);
				}
			}
		}
		
		for (Integer integer : result) {
			System.out.print(integer + " ");
		}
		
	}
}

