//package jiu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

//1
//3 2 4
//1 3
//3 2
//3 1
//2 3
public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	static int t,n,x,k;
	static int[] cup;
	static int[] sel;
	static List<int[]> selList;
	public static void main(String[] args) throws NumberFormatException, IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			x = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			cup = new int[n];
			sel = new int[2];
			selList = new ArrayList<>();
			
			for (int j = 0; j < n; j++) {
				cup[j] = j+1;
			}
			
//			rc(0,0);
//			swap();
			for (int j = 0; j < k; j++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken())-1;
				int b = Integer.parseInt(st.nextToken())-1;
				
				int tmp = cup[a];
				cup[a] = cup[b];
				cup[b] = tmp;
			}
			
			
			int ans = 0;
			for (int j = 0; j < cup.length; j++) {
				if(cup[j] == x) {
					ans = j;
					break;
				}
			}
			
			System.out.println(ans+1);
	}
}