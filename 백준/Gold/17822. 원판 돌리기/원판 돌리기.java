//package test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

// n m t    크기 , 전체 회전 수 입력
// x d k    배열 인덱스, 회전방향, 회전 수
public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static int n, m, t; // 메인
    static int x,k;   // 서브
    static int save;
    static boolean d;
    static Queue<int[]> q;
    static int[][] arr;
    static List<int[]> chage_lst;
    static boolean flag;
    static int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};
    public static void main(String[] args) throws IOException {
    	//System.setIn(new FileInputStream("src/test/Main.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    t = Integer.parseInt(st.nextToken());

    arr = new int[n][m];

    for (int i = 0; i < n; i++) {
        st = new StringTokenizer(br.readLine());
        for (int j = 0; j < m; j++) {
            arr[i][j] = Integer.parseInt(st.nextToken());
        }
    }

    for (int ti = 0; ti < t; ti++) {
        st = new StringTokenizer(br.readLine());
        x = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken()) == 1 ? true : false;
        k = Integer.parseInt(st.nextToken());
        if(d){
            left();   // 1 반시계
        }else{
            right();  // 0 시계
        }
//        
        check();
        
//        System.out.println((int)getSum());
    	if(!flag) {
    		adjAvg();
    	}
    }
		  
//		  print();
		  System.out.println((int)getSum());
	}

	private static void check() {
		q = new ArrayDeque<>();
		flag = false;
		for (int dx = 0; dx < n; dx++) {
			for (int dy = 0; dy < m; dy++) {
				save = arr[dx][dy];
				for (int[] d : dir) {
					int nx = dx + d[0];
					int ny = dy + d[1];
					
					if(nx<0 || nx>=n) {
						continue;
					}
					if(ny<0) {
						ny = m-1;
					}
					if(ny>=m) {
						ny =0;
					}
					
					if(save != 0 && arr[nx][ny] == save) {
						q.add(new int[] {dx,dy});
						q.offer(new int[] {nx,ny});
					}
				}
			}
		}
		
		if(q.size()>1) {		// 인접한게 있음
			while(!q.isEmpty()) {
				int[] p = q.poll();
				int ex = p[0];
				int ey = p[1];
				arr[ex][ey] = 0;
			}
			flag = true;
		}else {
			return;
		}
//		adjAvg();
	}

	private static void adjAvg() {
		double avg = getSum()/chage_lst.size();
		for (int i = 0; i < chage_lst.size(); i++) {
			int[] lst = chage_lst.get(i);
			int dx = lst[0];
			int dy = lst[1];
			int num = arr[dx][dy];
			arr[dx][dy] = num < avg ? num + 1 : (num > avg ? num - 1 : num);  
		}
		
	}

	private static double getSum() {
		chage_lst = new ArrayList<>();
		double sum = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if(arr[i][j] != 0) {
					sum += arr[i][j];
					chage_lst.add(new int[] {i,j});
				}
			}
		}
		return sum;
	}

	private static void right() {
	    for (int idx = x; idx <= n; idx += x) {
	        for (int circle = 0; circle < k; circle++) {
	            int[] te = arr[idx - 1];
	            int[] tes = new int[arr[idx - 1].length];
	            for (int i = 0, j = m - 1; j < m * 2 - 1; i++, j++) {     //우회전   시계방향 0일때
	                tes[i] = te[j % m];
	            }
	            arr[idx-1] = tes.clone();
	        }
	    }
	}
	
	private static void left() {
	    for (int idx = x; idx <= n; idx+=x) {
	        for (int circle = 0; circle < k; circle++) {
	            int[] te = arr[idx-1];
	            int[] tes = new int[arr[idx-1].length];
	            for (int i = 0, j = 1; j <= m; i++, j++) {      // 좌회전
	                tes[i] = te[j % m];
	            }
	            arr[idx-1] = tes.clone();
	        }
	    }   //end
	}
	
	private static void print() {
	    for (int[] lst : arr) {
	        System.out.println(Arrays.toString(lst));
	    }
	}
}