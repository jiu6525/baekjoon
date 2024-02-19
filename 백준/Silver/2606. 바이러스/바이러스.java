

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	static int n,m,ans;
	static List<List<Integer>> arr;
	static boolean[] visited;
    public static void main(String[] args) throws IOException {
    	//System.setIn(new FileInputStream("src/jiu/Main.txt"));
    	br = new BufferedReader(new InputStreamReader(System.in));
    	n = Integer.parseInt(br.readLine());
    	m = Integer.parseInt(br.readLine());
    	

    	arr = new ArrayList<>();
    	visited = new boolean[n+1]; 
    	
    	for (int i = 0; i < n+1; i++) {
			arr.add(i, new ArrayList<>());
		}
    	
    	for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			arr.get(a).add(b);
			arr.get(b).add(a);
		}
    	
//    	print(arr);
    	
    	dfs(1);
    	System.out.println(ans-1);
    }

	private static void print(List<List<Integer>> map) {
		for (List<Integer> list : map) {
			System.out.print(list);
		}
		System.out.println();
	}
	
	private static void dfs(int v) {
		visited[v] = true;
		ans += 1;
		for (Integer idx : arr.get(v)) {
			if(!visited[idx]) {
				dfs(idx);
			}
		}
		
	}
}
