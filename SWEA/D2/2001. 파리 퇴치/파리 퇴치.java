import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n,m;
    static int[][] arr;
    static int ans;
    public static void main(String[] args) throws NumberFormatException, IOException {
    	int t = Integer.parseInt(br.readLine());
    	
    	for(int s = 1; s<=t; s++) {
    		st = new StringTokenizer(br.readLine());
    		n = Integer.parseInt(st.nextToken());
    		m = Integer.parseInt(st.nextToken());
    		arr = new int[n][n];
    		ans = 0;
    		for(int i = 0; i<n; i++) {
    			st = new StringTokenizer(br.readLine());
    			for(int j = 0; j<n; j++) {
    				arr[i][j] = Integer.parseInt(st.nextToken());
    			}
    		}
    		ans = 0;
    		for(int i = 0; i<n-m+1; i++) {
    			for(int j = 0; j<n-m+1; j++) {
    				int cnt = 0;
    				for(int k = i; k<i+m; k++) {
    					for(int z = j; z<j+m; z++) {
    						cnt += arr[k][z];
    					}
    				}
    				ans = Math.max(ans, cnt);
    			}
    		}
    		
    		System.out.printf("#%d %d\n", s,ans);
    	}
    	
    	
    }
}

//1
//5 2
//1 3 3 6 7
//8 13 9 12 8
//4 16 11 12 6
//2 4 1 23 2
//9 13 4 7 3

