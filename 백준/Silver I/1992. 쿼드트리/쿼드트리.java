//package jiu;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.StringTokenizer;


public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	static StringBuilder sb;
	static int n, ans;
	static int[][] arr;
	static boolean[][] v;
	public static void main(String[] args) throws NumberFormatException, IOException {
		//System.setIn(new FileInputStream("src/jiu/Main.txt"));
		br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		v = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			String line = br.readLine();
			for (int j = 0; j < n; j++) {
				arr[i][j] = line.charAt(j) -'0';
			}
		}
		
//		print();
		
		rc(0,0,n);
	}
	
	


	private static void rc(int x, int y, int k) {
		if(check(x,y,k)) {
			System.out.print(arr[x][y]);
			return;
		}
		
		k = k/2;	// 8 -> 4 -> 2 -> 1
		System.out.print("(");
		
		rc(x,y,k);	// 왼 위
		rc(x,y+k,k);	// 오 위
		rc(x+k, y,k);	// 왼 아
		rc(x+k,y+k,k);	// 오 아
		
		System.out.print(")");
	}




	private static boolean check(int x, int y, int k) {
		
		for (int i = x; i < x+k; i++) {
			for (int j = y; j < y+k; j++) {
				if(arr[x][y] != arr[i][j]) {
					return false;
				}
			}
		}
		
		return true;
	}




	private static void print() {
		for (int[] lst : arr) {
			System.out.println(Arrays.toString(lst));
		}
		
	}
	
}
