import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int r = 0;
	static int c = 0;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String word = br.readLine();
		int n = word.length();
		int idx = 0;
		StringBuilder sb = new StringBuilder(word);
		sb.reverse();
		getRC(n);

		String[][] arr = new String[r][c];		
		
		for(int i = 0; i<c; i++) {
			for(int j = 0; j<r; j++) {
				arr[j][i] = String.valueOf(word.charAt(idx++)) ;
				if(idx == word.length()) {
					break;
				}
			}
		}
		
		for(int i = 0; i<r; i++) {
			for(int j = 0; j<c; j++) {
				System.out.print(arr[i][j]);
			}
		}
		
		
	}

	private static void getRC(int n) {
		for(int i = n; i>0; i--) {
			for(int j = n; j>0; j--) {
				if(i<=j && i*j == n) {
					r = i;
					c = j;
					return;
				}
			}
		}
	}
}
