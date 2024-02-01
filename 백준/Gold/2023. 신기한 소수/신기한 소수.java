import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		int n = Integer.parseInt(br.readLine());
		getSolv(0,n);

//		System.out.println(sb.substring(0,sb.length()));
		System.out.println(sb);
	}

	private static void getSolv(int t, int n) {
		if(n==0) {
			if (isPrime(t)) {
				sb.append(t).append("\n");
			}
		}
		for(int i = 0; i<10; i++) {
			int num = t * 10 + i;
//			System.out.println(num);
			if(isPrime(num)) {
				getSolv(num,n-1);
			}
		}
	}
	
	private static boolean isPrime(int n) {
		if(n<2) {
			return false;
		}
		
		for(int i = 2; i<=Math.sqrt(n); i++) {
			if(n%i==0) {
				return false;
			}
		}
		
		return true;
	}
}
