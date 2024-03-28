import java.io.*;
import java.util.*;

public class Main {
	
	static int T, N;
	static List<int[]> lst;
	public static void main(String[] args) throws Exception {
    	//System.setIn(new FileInputStream("src/jiu/Main.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			int ej = Integer.parseInt(st.nextToken());
			int ei = Integer.parseInt(st.nextToken());
			
			lst = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				int tj = Integer.parseInt(st.nextToken());
				int ti = Integer.parseInt(st.nextToken());
				lst.add(new int[] {tj,ti});
			}
			st = new StringTokenizer(br.readLine());
			int sj = Integer.parseInt(st.nextToken());
			int si = Integer.parseInt(st.nextToken());
			
			String ans = bfs(sj,si,ej,ei);
			System.out.println(ans);
		}
	}

	private static String bfs(int sj, int si, int ej, int ei) {
		Queue<int[]> q = new LinkedList<>();
		boolean[] v = new boolean[N];
		
		q.offer(new int[] {sj,si});
		while(!q.isEmpty()) {
			int[] tmp = q.poll();
			int cj = tmp[0];
			int ci = tmp[1];
			if(Math.abs(cj-ej) + Math.abs(ci-ei) <= 1000) {
				return "happy";
			}
			for (int i = 0; i < N; i++) {
				if(!v[i]) {
					int[] l = lst.get(i);
					int nj = l[0];
					int ni = l[1];
					if(Math.abs(cj-nj) + Math.abs(ci-ni) <= 1000) {
						q.offer(new int[] {nj,ni});
						v[i] = true;
					}
					
				}
			}
		}
		return "sad";
	}

	
}