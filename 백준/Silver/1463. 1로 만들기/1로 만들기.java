import java.io.*;
import java.util.*;
public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	static int n;
	public static void main(String[] args) throws Exception {
    	//System.setIn(new FileInputStream("src/jiu/main.txt"));
    	br = new BufferedReader(new InputStreamReader(System.in));
    	n = Integer.parseInt(br.readLine());
    	
        int[] d = new int[1000001];
        
        for (int i = 2; i <= n; i++) {
            d[i] = d[i - 1] + 1;

            if (i % 3 == 0)
                d[i] = Math.min(d[i], d[i / 3] + 1);
            if (i % 2 == 0)
                d[i] = Math.min(d[i], d[i / 2] + 1);
        }
        
        System.out.println(d[n]);
	    }
}