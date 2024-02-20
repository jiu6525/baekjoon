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

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static int n,m,ans;
    static int hp[],weight[];
    static int[][] arr,dot;
    static int[] lst,sel;
    static boolean[] v;
    static List<int[]> empty_area,virus;
    static int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};
    public static void main(String[] args) throws IOException {
    	//System.setIn(new FileInputStream("src/jiu/Main.txt"));
    	br = new BufferedReader(new InputStreamReader(System.in));
    	n = Integer.parseInt(br.readLine());
    	hp = new int[n];
    	weight = new int[n];
    	ans = 0;
    	for (int i = 0; i < n; i++) {
    		st = new StringTokenizer(br.readLine());
    		hp[i] = Integer.parseInt(st.nextToken());
    		weight[i] = Integer.parseInt(st.nextToken());
		}
    	
    	
//    	hp[2] = hp[2]-weight[0] < 0? 0 : hp[2]-weight[0];
//    	hp[0] = hp[0]-weight[2] < 0? 0 : hp[0]-weight[2];
//    	ans++;

    	
    	dfs(0,0);
//    	print(hp);
//    	print(weight);
    	System.out.println(ans);
    }
    
//  a 와 b를 생각해서 a가 깨질경우와 b가 깨질경우를 모두 구해보자
//  (n-1)!
//  0보다 클때만 반복할수 있도록 하자
    
	private static void dfs(int idx, int cnt) {
		ans = Math.max(ans, cnt);
//    	print(hp);
//    	print(weight);
//    	System.out.println();
		if(idx == n) {
			return;
		}
		
//		계란의 피가 없다면 다음으로 ㄱ
		if(hp[idx] <=0 ) {
			dfs(idx+1, cnt);
		}else {
			for (int i = 0; i < n; i++) {
//				idx 가 i 와 같으면 넘김
				if(i == idx) {
					continue;
				}
				
				if(hp[i] > 0) {
//					피가 0보다 많으면 부딪치기
					hp[i] -= weight[idx];
					hp[idx] -= weight[i];
					if(hp[i] <= 0 && hp[idx] <= 0) {
						dfs(idx+1, cnt + 2);
					}else if(hp[i] > 0 && hp[idx] > 0){
						dfs(idx+1,cnt);
					}else {
						dfs(idx+1,cnt+1);
					}
					
					hp[idx] += weight[i];
					hp[i] += weight[idx];
				}
			}
		}
		
		
	}
	private static void print(int[] lst) {
		System.out.println(Arrays.toString(lst));
		
	}
}