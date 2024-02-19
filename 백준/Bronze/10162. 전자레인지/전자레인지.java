
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	static int n;
	static int[] time = {300,60,10}, ans = new int[time.length];
	
    public static void main(String[] args) throws IOException {
    	//System.setIn(new FileInputStream("src/jiu/Main.txt"));
    	br = new BufferedReader(new InputStreamReader(System.in));
    	n = Integer.parseInt(br.readLine());
    	
    	for (int i = 0; i < time.length; i++) {
			ans[i] += n/time[i];
			n %= time[i];
		}
    	
    	if(n == 0) {
    		for (int i = 0; i < ans.length; i++) {
				System.out.print(ans[i] + " ");
			}
    	}else {
    		System.out.println(-1);
    	}
    }
}