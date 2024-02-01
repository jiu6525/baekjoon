import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n;
    static int[] nomat1,nomat2;
    static int ans = Integer.MAX_VALUE;
    public static void main(String[] args) throws NumberFormatException, IOException {
    	n = Integer.parseInt(br.readLine());
    	nomat1 = new int[n];
    	nomat2 = new int[n];
    	
    	for(int i = 0; i<n; i++) {
    		st = new StringTokenizer(br.readLine());
			nomat1[i] = Integer.parseInt(st.nextToken());
			nomat2[i] = Integer.parseInt(st.nextToken());

    	}
		
    	// 깊이, 신맛 *, 쓴맛 +, select
    	getSolv(0,1,0,0);
    	System.out.println(ans);
    }
    
	private static void getSolv(int idx, int nmat, int ymat, int sel) {
		if(n==idx) {
			if(sel != 0 && Math.abs(nmat-ymat) < ans) {
				ans = Math.abs(nmat-ymat);
			}
			return;
		}
		getSolv(idx+1, nmat*nomat1[idx], ymat+nomat2[idx], sel+1);
		getSolv(idx+1, nmat, ymat, sel);
	}	
}

