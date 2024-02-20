//package jiu;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 무조건 0이랑 인접해 있어야 함
public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	static int cnt, n, m, ans;
	static int[][] arr;
	static Queue<int[]> q = new LinkedList<>();;
	static int[][] dir = {{0,1},{1,0},{-1,0},{0,-1}};
	public static void main(String[] args) throws NumberFormatException, IOException {
		//System.setIn(new FileInputStream("src/jiu/Solution.txt"));
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		cnt = 0; 
		ans = 0;
		arr = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dfs(0,0);
		
		
//		1. 외부 공기에 대한 처리
//		2. 2와 닫은 부분을 공기처리
//		3. 개수가 0일때까지 반복
		
		while(true) {
			cnt++;
			ans = getCheese();
			air();
			if(getCheese() == 0) {
				break;
			}
		}
		
		System.out.println(cnt);
		System.out.println(ans);
	}

	private static void air() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if(arr[i][j] == 1) {
					rc(i,j);
				}
			}
		}
		while(!q.isEmpty()) {
			int[] p = q.poll();
			int ex = p[0];
			int dy = p[1];
			arr[ex][dy] = 0;
			dfs(ex,dy);
		}
	}
	
	private static int getCheese() {
		int cnt = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if(arr[i][j] == 1) {
					cnt++;
				}
			}
		}
		return cnt;
	}

	private static void rc(int x, int y) {
		int dx = x;
		int dy = y;
		for (int[] d : dir) {
			int nx = dx + d[0];
			int ny = dy + d[1];
			
			if(nx<0 || nx>=n || ny<0 || ny>=m) {
				continue;
			}
			
			if(arr[nx][ny] == 2) {
				q.add(new int[] {dx,dy});
			}
		}
		
	}

	private static void dfs(int x, int y) {
		if(x<0 || x>=n || y<0 || y>= m) {
			return;
		}
		
		if(arr[x][y] == 0) {
			arr[x][y] = 2;
			
			dfs(x,y+1);
			dfs(x-1,y);
			dfs(x+1,y);
			dfs(x,y-1);
			return ;
		}
		return ;
	}

	private static void print(int[][] map) {
		for (int[] lst : map) {
			System.out.println(Arrays.toString(lst));
		}
		System.out.println();
	}
	
}