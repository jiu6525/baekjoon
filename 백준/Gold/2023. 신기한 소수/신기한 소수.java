import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int ans;
	static int N;
    public static void main(String[] args) throws IOException {
    	N = Integer.parseInt(br.readLine());
    	
    	recursive(0,N);
    }
	private static void recursive(int val, int n) {
		// basis part
		if(n==0) {
			System.out.println(val);
			return;
		}
		
		// inductive part
		for (int i = 1; i < 10; i++) {
			int num = val*10+i;
			// 만약에 num 이 소수라면 num 의 값을 확정하고
			if(isPrime(num)) {
				recursive(num, n-1);
			}
		}
		
	}
	private static boolean isPrime(int num) {
		if(num<2) {
			return false;
		}
		
		for(int i = 2; i<=Math.sqrt(num);i++) {
			if(num%i==0) {
				return false;
			}
		}
		return true;
	}
}
