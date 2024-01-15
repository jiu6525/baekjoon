import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution{	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for(int i0=0; i0<t; i0++) {
			int n = Integer.parseInt(br.readLine());
			String[][] arr = new String[n][n];
			
			for(int i = 0; i<n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 0; j<n; j++) {
					arr[i][j] = st.nextToken();
				}
			}
			
			String[][] ans1 = sol(n,arr);
			String[][] ans2 = sol(n,ans1);
			String[][] ans3 = sol(n,ans2);
	
			System.out.printf("#%d\n",i0+1);
			for(int k=0;k<n; k++) {
				System.out.printf("%s %s %s\n",String.join("",ans1[k]),String.join("",ans2[k]),String.join("",ans3[k]));
			}
			
		}
		}
	
	public static String[][] sol(int n,String[][] arr) {
		String[][] anslst = new String[n][n];
		for(int i = 0; i<n; i++) {
			for(int j = n-1; j>=0; j--) {
				anslst[i][n-1-j] = arr[j][i];
			}
		}
		
		return anslst;
	}
	
}