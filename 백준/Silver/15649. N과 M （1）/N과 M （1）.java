import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int m;
	static int[] ans;
	static boolean[] ck;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
//		n = 4;
//		m = 2;
		ans = new int[m+1];
		ck = new boolean[n+1];
		
		
		rc(0);
	}

	private static void rc(int k) {
		if(k==m) {
			for(int i = 0; i < m; i++) {
				System.out.print(ans[i] + " ");
			}
			System.out.println();
			return;
		}
		
		for(int j = 0; j<n; j++) {
			if(!ck[j]) {
				ck[j] = true;
				ans[k] = j + 1;
				rc(k+1);
				ck[j] = false;
			}
		}
	}
}
