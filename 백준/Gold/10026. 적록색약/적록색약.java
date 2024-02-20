//package jiu;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 빨파초 각자 구하는 dfs를 작성해야 하나
// 방문처리를 해줘야 겠지
public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	static int  n, m, rgcnt, cnt;
	static char[][] arr,rgarr;
	static boolean[][] v,rgv;
	static int[][] dir = {{0,1},{1,0},{-1,0},{0,-1}};
	public static void main(String[] args) throws NumberFormatException, IOException {
		//System.setIn(new FileInputStream("src/jiu/Main.txt"));
		br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new char[n][n];
		rgarr = new char[n][n];
		v = new boolean[n][n];
		rgv = new boolean[n][n];
		
		for (int i = 0; i < n; i++) {
			String line = br.readLine();
			for (int j = 0; j < n; j++) {
				char word = line.charAt(j);
				arr[i][j] = word;
				if(word == 'R' || word == 'G') {
					rgarr[i][j] = 'R';
				}else {
					rgarr[i][j] = word;
				}
			}
		}
		
		cnt = 0;
		rgcnt = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(!v[i][j]) {
					if(dfs(i,j,arr[i][j],arr, v)) {
						cnt++;
					}
				}
				if(!rgv[i][j]) {
					if(dfs(i,j,rgarr[i][j],rgarr, rgv)) {
						rgcnt++;
					}
				}
			}
		}
		
		System.out.printf("%d %d",cnt,rgcnt);
	}
	
	private static boolean dfs(int x, int y,char w, char[][] map, boolean[][] v) {
		if(x<0 || x>=n || y<0 || y>=n) {
			return false;
		}
		
		if(map[x][y] != w) {
			return false;
		}else {
			if(!v[x][y]) {
				v[x][y] = true;
				
				dfs(x-1,y,w,map,v);
				dfs(x+1,y,w,map,v);
				dfs(x,y-1,w,map,v);
				dfs(x,y+1,w,map,v);
				return true;
			}
		}
		return false;
	}
	
	private static void print(char[][] map) {
		for (char[] cs : map) {
			System.out.println(Arrays.toString(cs));
		}
		System.out.println();
	}
}