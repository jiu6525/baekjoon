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
	
    public static void main(String[] args) throws IOException {
    	Queue<Integer> q = new LinkedList<Integer>();
    	int n = Integer.parseInt(br.readLine());
    	int[] lst = new int[n];
    	for(int i = 0; i<n; i++) {
    		q.offer(i+1);
    	}
    	
    	while(q.size()>1) {
    		q.poll();
    		Integer num = q.poll();
    		q.offer(num);
    	}
    	
    	System.out.println(q.peek());
    }
}
