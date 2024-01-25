import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;



public class Main {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	int n = Integer.parseInt(br.readLine());
    	int[] arr = new int[n];
    	int[] result = new int[n+1];
    	st = new StringTokenizer(br.readLine());
    	for(int i = 0; i<n; i++) {
    		arr[i] = Integer.parseInt(st.nextToken());
    	}
    	
    	Arrays.sort(arr);
    	
    	for(int i = 0; i<n; i++) {
    		result[i+1] = arr[i] + result[i]; 
    	}
    	
    	int sum = Arrays.stream(result).sum();
    	System.out.println(sum);
   	
    }
}