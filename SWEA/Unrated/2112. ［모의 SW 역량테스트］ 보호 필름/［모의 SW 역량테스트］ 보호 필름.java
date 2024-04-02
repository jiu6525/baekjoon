import java.io.*;
import java.util.*;

public class Solution {
	static BufferedReader br;
	static StringTokenizer st;
	static int t,r,c,k;
	static int[][] arr;
	static int ans;
	static int[] sub;
	//static int[] sel = new int[3];
	public static void main(String[] args) throws Exception {
        //System.setIn(new FileInputStream("src/jiu/Main.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= t; tc++) {
        	st = new StringTokenizer(br.readLine());
    		r = Integer.parseInt(st.nextToken());
    		c = Integer.parseInt(st.nextToken());
    		k = Integer.parseInt(st.nextToken());
    		ans = -1;
    		arr = new int[r][c];
    		sub = new int[r];
    		Arrays.fill(sub, -1);
    		
    		for (int i = 0; i < r; i++) {
    			st = new StringTokenizer(br.readLine());
    			for (int j = 0; j < c; j++) {
    				arr[i][j] = Integer.parseInt(st.nextToken());
    			}
    		}
    		
//    		print(arr);
    		for(int i = 0 ;i <= r; i++){
    			if(ans != -1) {
    				break;
    			}
    			dfs(0,i,0);			// depth , f, start
    		}
    		
    		System.out.printf("#%d %d\n",tc,ans);
		}
        
		
	}
	private static void dfs(int d, int f, int s) {
		if(ans != -1) {
			return;
		}
		
		if(d == f) {
			if(check(copyArr())) {
				ans = f;
			}
			
			return;
		}
		
		
		
		for (int i = s; i < r; i++) {
			for (int j = 0; j < 2; j++) {
				sub[i] = j;
				dfs(d+1, f, i+1);
			}
			sub[i] = -1;
		}
	}

	private static boolean check(int[][] tmp) {
		int cnt = 1;
		L : for (int i = 0; i < c; i++) {
				cnt = 1;
				for (int j = 1; j < r; j++) {
					if(tmp[j][i] == tmp[j-1][i]) {
						cnt++;
					}else {
						cnt = 1;
					}
					if(cnt == k) {
						continue L;
					}
				}
			return false;
		}
		return true;
	}
	private static int[][] copyArr() {
		int[][] tmp = new int[r][c];
		
		for (int i = 0; i < r; i++) {
			if(sub[i] != -1) {
				for (int j = 0; j < c; j++) {
					tmp[i][j] = sub[i];
				}
			}else {
				for (int j = 0; j < c; j++) {
					tmp[i][j] = arr[i][j];
				}
			}
		}
		return tmp;
	}
	
	private static void print(int[][] map) {
		for (int[] lst : map) {
			System.out.println(Arrays.toString(lst));
		}
		
	}
	
//	static int[] arr = {0,1};
//	static int[] sel = new int[2];
//	public static void main(String[] args) {
//		
//		recursive(0);
//	}
//	private static void recursive(int k) {
//		// basis part
//		// 다 골랐어요
//		if(k==sel.length) {
//			System.out.println(Arrays.toString(sel));
//			return;
//		}
//		
//		// inductive part
//		for(int i=0;i<arr.length;i++){
//			sel[k]=i;
//			recursive(k+1);
//		}
//		
//	}

}