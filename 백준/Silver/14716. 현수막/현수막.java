import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	static int t,r,c,k;
	static int[][] arr;
	static boolean[][] v;
	static int ans,cnt;
	static int[][] dir = {{0,1},{1,0},{0,-1},{-1,0},{-1,-1},{-1,1},{1,1},{1,-1}};
	public static void main(String[] args) throws Exception {
        //System.setIn(new FileInputStream("src/jiu/Main.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        
        arr = new int[r][c];
        v = new boolean[r][c];
        
        for (int i = 0; i < r; i++) {
        	st = new StringTokenizer(br.readLine());
			for (int j = 0; j < c; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
        
        for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if(!v[i][j] && arr[i][j] == 1) {
					ans++;
					dfs(i,j);
				}
			}
		}
        
        System.out.println(ans);
	}
	private static void dfs(int x, int y) {
		v[x][y] = true;
		
		for (int[] d : dir) {
			int nx = x + d[0];
			int ny = y + d[1];
			
			if(check(nx,ny) && arr[nx][ny] == 1 && !v[nx][ny]) {
				dfs(nx,ny);
			}
		}
		
	}
	private static boolean check(int nx, int ny) {
		if(nx >= 0 && nx < r && ny >= 0 && ny <c) {
			return true;
		}
		return false;
	}
}