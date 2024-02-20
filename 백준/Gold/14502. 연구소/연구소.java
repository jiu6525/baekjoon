//package jiu;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

// 빈공간 0 일때의 좌표를 저장하기
// 빈공간에 대한 nC3 조합 구하기
// 배열에 표시 후 바이러스 영역과 안전영역 구한뒤 값 최신화 하기
// 바이러스 영역도 좌표에 저장해야 편할듯,,

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static int n,m,ans;
    static int[][] arr,dot;
    static int[] lst,sel;
    static boolean[] v;
    static List<int[]> empty_area,virus;
    static int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};
    public static void main(String[] args) throws IOException {
    	//System.setIn(new FileInputStream("src/jiu/Main.txt"));
    	br = new BufferedReader(new InputStreamReader(System.in));
    	st = new StringTokenizer(br.readLine());
    	n = Integer.parseInt(st.nextToken());
    	m = Integer.parseInt(st.nextToken());
    	ans = 0;
    	arr = new int[n][m];
    	empty_area = new ArrayList<>();
    	virus = new ArrayList<>();
    	for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j] == 0) {
					empty_area.add(new int[] {i,j});
				}
				
				if(arr[i][j] == 2) {
					virus.add(new int[] {i,j});
				}
			}
		}

    	dot = new int[3][2];
    	rc(0,0);
    	
    	
    	System.out.println(ans);
    }

	private static void rc(int idx, int k) {
		if(k == dot.length) {
//			for (int[] lst : dot) {
//				System.out.print(Arrays.toString(lst));	
//			}
//			System.out.println();
			mark(dot);
			return;
		}
		
		if(idx == empty_area.size()) {
			return;
		}
		
		dot[k][0] = empty_area.get(idx)[0];
		dot[k][1] = empty_area.get(idx)[1];
		rc(idx+1, k+1);
		rc(idx+1, k);
		
		
	}

	
	
	
	private static void mark(int[][] dot2) {
		int[][] tmp = new int[n][m];
		for (int i = 0; i < n; i++) {
			tmp[i] = arr[i].clone();
		}
		
		for (int i = 0; i < dot2.length; i++) {
			int x = dot2[i][0];
			int y = dot2[i][1];
			tmp[x][y] = 1;
		}
		
//		print(tmp);
		
		bfs(tmp);
		
		
	}

	private static void bfs(int[][] tmp) {
		for (int[] v : virus) {
			int x = v[0];
			int y = v[1];
			
			Queue<int[]> q = new LinkedList<>();
			q.offer(new int[] {x,y});
			
			while(!q.isEmpty()) {
				int[] p = q.poll();
				int dx = p[0];
				int dy = p[1];
				for (int[] d : dir) {
					int nx = dx + d[0];
					int ny = dy + d[1];
					if(nx<0 || nx>=n || ny < 0 || ny >=m) {
						continue;
					}
//					if(tmp[nx][ny] == 1) {
//						continue;
//					}
					if(tmp[nx][ny] == 0) {
						tmp[nx][ny] = 2;
						q.offer(new int[] {nx,ny});

					}
					
					
				}
			}
		}
		
		checkSafeArea(tmp);
		
//		for (int[] is : tmp) {
//			System.out.println(Arrays.toString(is));
//		}
//		
		
	}

	private static void checkSafeArea(int[][] tmp) {
		int cnt = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if(tmp[i][j] == 0) {
					cnt++;
				}
			}
		}
		
		ans = Math.max(cnt, ans);
		
	}

	private static void print(int[][] t) {
		for (int[] lst : t) {
			System.out.println(Arrays.toString(lst));
		}
		System.out.println();
		
	}
}