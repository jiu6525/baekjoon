//package jiu;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
현재 칸이 아직 청소되지 않은 경우, 현재 칸을 청소한다.
현재 칸의 주변 
4칸 중 청소되지 않은 빈 칸이 없는 경우,  					4방 탐색
바라보는 방향을 유지한 채로 한 칸 후진할 수 있다면 한 칸 후진하고 1번으로 돌아간다.		현재방향에서 2 더한뒤 4로 나눈 나머지
바라보는 방향의 뒤쪽 칸이 벽이라 후진할 수 없다면 작동을 멈춘다.		벽을 만날때 까지
현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 있는 경우,
반시계 방향으로 
90^ 회전한다.
바라보는 방향을 기준으로 앞쪽 칸이 청소되지 않은 빈 칸인 경우 한 칸 전진한다.
1번으로 돌아간다.
*/

// 0 1 2 3
// -1 해서 0보다 작은경우 dir.length
// 0 북, 1 동, 2 남, 3 서
// 0 빈칸 1 벽
public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	static int  n, m, r, c, ans;
	static int[][] arr;
	static boolean[][] v;
//							우	  하		좌		상
	static int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};
	static int d;
	public static void main(String[] args) throws NumberFormatException, IOException {
		//System.setIn(new FileInputStream("src/jiu/Main.txt"));
		br = new BufferedReader(new InputStreamReader(System.in));
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		d = (d + 3)%4 ;
		
		arr = new int[n][m];
		v = new boolean[n][m];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
//		print(arr);
		
		while(true) {
			if(arr[r][c] == 0 && !v[r][c]) {

				v[r][c] = true;
				ans++;
				
//				print(arr);
//				print(v);
			}
			
			if(check(r,c)) {		// 주변에 이동할수 있는 칸이 있을때
				d -= 1;		// 반시계 회전
				if(d<0) {
					d = dir.length-1;
				}
				int ex = r + dir[d][0];
				int ey = c + dir[d][1];
				if(ex<0 || ex>=n || ey<0 || ey>=m) {
					continue;
				}
				if(arr[ex][ey] == 0 && !v[ex][ey]) {
					r = ex;
					c = ey;
				}
			}else {	// 청소가능한 빈칸이 없는 경우
				int back = (d + 2)%4;
				int nx = r + dir[back][0];
				int ny = c + dir[back][1];
				if(nx<0 || nx>=n || ny < 0 || ny >= m) {	// 빈칸이 없는경우 정지
					break;
				}else if(arr[nx][ny] == 1){
					break;
				}else {			// 로봇 위치 뒤로 이동
					r = nx;
					c = ny;
				}
			}
		}
		System.out.println(ans);
		
	}
	private static void print(boolean[][] v2) {
		for (boolean[] bs : v2) {
			System.out.println(Arrays.toString(bs));
		}
		
	}
	private static boolean check(int x, int y) {
		int dx = x;
		int dy = y;
		for (int[] d : dir) {
			int nx = dx + d[0];
			int ny = dy + d[1];
			
			if(nx<0 || nx>=n || ny<0 || ny>=m) {
				continue;
			}
			if(arr[nx][ny] == 0 && !v[nx][ny]) {
				return true;
			}
		}
		return false;
		
	}
	private static void print(int[][] map) {
		System.out.printf("%d %d %d\n",r,c,d);
		for (int[] lst : map) {
			System.out.println(Arrays.toString(lst));
		}
		System.out.println();
		
	}
	
}