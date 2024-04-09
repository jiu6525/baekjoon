import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	static int t,r,c,k;
	static int[][] arr;
	static boolean[][] v;
	static int ans,cnt;
	static int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};
	public static void main(String[] args) throws Exception {
        //System.setIn(new FileInputStream("src/jiu/Main.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= t; tc++) {
        	st = new StringTokenizer(br.readLine());
    		r = Integer.parseInt(st.nextToken());
    		c = Integer.parseInt(st.nextToken());
    		ans = 0;
    		cnt = 0;
    		arr = new int[r][c];
    		v = new boolean[r][c];
    		for (int i = 0; i < r; i++) {
				String line = br.readLine();
				for (int j = 0; j < c; j++) {
					char w = line.charAt(j);
					arr[i][j] = w == '#' ? 1 : 0;
				}
			}
    		
//    		print();
    		for (int i = 0; i < r; i++) {
				for (int j = 0; j < c; j++) {
					if(arr[i][j] == 1 && !v[i][j]) {
						dfs(i,j);
						cnt++;
					}
				}
			}
    		
    		System.out.println(cnt);
    		
    		
		}
	}
	private static void dfs(int x, int y) {
		v[x][y] = true;
		
		for (int[] d : dir) {
			int dx = x + d[0];
			int dy = y + d[1];
			
			if(check(dx,dy) && arr[dx][dy] == 1 && !v[dx][dy]) {
				dfs(dx,dy);
			}
		}
		
	}
	private static boolean check(int dx, int dy) {
		if(dx >= 0 && dx < r && dy >= 0 && dy < c) {
			return true;
		}
		return false;
	}
	private static void print() {
		for (int[] lst : arr) {
			System.out.println(Arrays.toString(lst));
		}
		System.out.println();
	}
}