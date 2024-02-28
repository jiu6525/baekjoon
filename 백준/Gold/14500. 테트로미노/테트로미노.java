//package jiu;

import java.io.*;
import java.util.*;

public class Main {
	    static BufferedReader br;
	    static StringTokenizer st;
	    static int n,m,nm;
	    static int[][] arr;
	    static int ans;
	    public static void main(String[] args) throws IOException {
	    	//System.setIn(new FileInputStream("src/jiu/Main.txt"));
	        br = new BufferedReader(new InputStreamReader(System.in));
	        st = new StringTokenizer(br.readLine());
	        n = Integer.parseInt(st.nextToken());
	        m = Integer.parseInt(st.nextToken());
	        nm = Math.max(n, m);
	        arr = new int[nm][nm];
	
	    for (int i = 0; i < n; i++) {
	        st = new StringTokenizer(br.readLine());
	        for (int j = 0; j < m; j++) {
	            arr[i][j] = Integer.parseInt(st.nextToken());
	        }
	    }
	
	    up();
        down();
	    wh_cal();
	    d_cal();
	    ans = Collections.max(Arrays.asList(up(),down(),wh_cal(),d_cal()));
	    System.out.println(ans);
//	    print();
	}

		private static int down() {
			int ans = 0;
			for (int i = 0; i < nm-2; i++) {
	            for (int j = 0; j < nm-1; j++) {
		        	int cnt = 0;
		            int r1 = 0,r2=0,r3=0,r4=0;
		            int f1 = 0,f2=0;
		            int h1=0,h2=0;
	                for (int si = i; si < i+3; si++) {
	                    for (int sj = j; sj < j+2; sj++) {
	                    	cnt += arr[si][sj];
		                    if(si != i && sj != j) {
		                    	r1 += arr[si][sj];
		                    }
		                    if(si != i && sj == j) {
		                    	r2 += arr[si][sj];
		                    }
		                    if(si < i+2 && sj != j) {
		                    	r3 += arr[si][sj];
		                    }
		                    if(si < i+2 && sj == j) {
		                    	r4 += arr[si][sj];
		                    }
		                    if((si == i && sj == j) || (si == i+2 && sj != j)) {
		                    	f1 += arr[si][sj];
		                    }
		                    if((si == i && sj != j) || (si == i+2 && sj == j)) {
		                    	f2 += arr[si][sj];
		                    }
		                    if(si != i+1 && sj != j) {
		                    	h1 += arr[si][sj];
		                    }
		                    if(si != i+1 && sj == j) {
		                    	h2 += arr[si][sj];
		                    }
	                    }
	                }
		            Integer min = Collections.min(Arrays.asList(r1,r2,r3,r4,f1,f2,h1,h2));
		            cnt -= min;
		            if(cnt>ans) {
		            	ans = cnt;
		            }
	            }
	        }
			return ans;
		}

		private static int up() {
			int ans = 0;
			for (int i = 0; i < nm-1; i++) {
			    for (int j = 0; j < nm-2; j++) {
			    	int cnt = 0;
			        int r1 = 0,r2=0,r3=0,r4=0;
			        int f1 = 0,f2=0;
			        int h1=0,h2=0;
			        for (int si = i; si < i+2; si++) {
			            for (int sj = j; sj < j+3; sj++) {
			            	cnt += arr[si][sj];
			                if(si != i && sj != j) {
			                	r1 += arr[si][sj];
			                }
			                if(si == i && sj != j) {
			                	r2 += arr[si][sj];
			                }
			                if(si != i && sj < j+2) {
			                	r3 += arr[si][sj];
			                }
			                if(si == i && sj < j+2) {
			                	r4 += arr[si][sj];
			                }
			                if((si == i && j+2 == sj) || i != si && j == sj) {
			                	f1 += arr[si][sj];
			                }
			                if((si == i && j == sj) || i != si && j+2 == sj) {
			                	f2 += arr[si][sj];
			            	}
			                if(si == i && sj != j+1) {
			                	h1 += arr[si][sj];
			                }
			                if(si != i && sj != j+1) {
			                	h2 += arr[si][sj];
			                }
			            }
			        }
			        Integer min = Collections.min(Arrays.asList(r1,r2,r3,r4,f1,f2,h1,h2));
		            cnt -= min;
		            if(cnt>ans) {
		            	ans = cnt;
		            }
			        }
			    }
			return ans;
		}
	
    private static int d_cal() {
    	int sum = 0;
        for (int i = 0; i < nm-1; i++) {
	        for (int j = 0; j < nm-1; j++) {
	        	int cnt = 0;
	            for (int si = i; si < i+2; si++) {
	                for (int sj = j; sj < j+2; sj++) {
	                	cnt += arr[si][sj];
	                }
	                
	            }
	            if(cnt > sum) {
	            	sum = cnt;
	            }
	        }
        }
        return sum;
	}

	private static int wh_cal() {
		int w_sum = 0;
		int h_sum = 0;
		for (int i = 0; i < nm; i++) {
			for (int j = 0; j < nm-3; j++) {
				int w_cnt = 0;
				int h_cnt = 0;
				for (int k = j; k < j+4; k++) {
//					System.out.println(i + " " + k);
					w_cnt += arr[i][k];
					h_cnt += arr[k][i];
//					System.out.println(k + " " + i);
				}
	            if(w_cnt > w_sum) {
	            	w_sum = w_cnt;
	            }
	            if(h_cnt > h_sum) {
	            	h_sum = h_cnt;
	            }
			}
		}
		return Math.max(w_sum, h_sum);
	}

	private static void print() {
	    for (int[] lst : arr) {
	        System.out.println(Arrays.toString(lst));
	    }
	}
}

