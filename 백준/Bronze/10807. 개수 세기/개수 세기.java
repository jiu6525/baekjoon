import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int ans = 0;
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		int num = Integer.parseInt(br.readLine());
		for(int i = 0;i<n; i++) {
			if(Integer.parseInt(st.nextToken()) == num) {
				ans += 1;
			}
		}
		
		System.out.println(ans);

	}

}
