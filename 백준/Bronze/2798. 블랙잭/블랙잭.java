import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


//5 21
//5 6 7 8 9

public class Main {
    public static void main(String[] args) throws IOException {
    	 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         StringTokenizer st = new StringTokenizer(br.readLine());
         int n = Integer.parseInt(st.nextToken());
         int m = Integer.parseInt(st.nextToken());
         int ans = 0;
         
         st = new StringTokenizer(br.readLine());
         int[] arr = new int[n];
         for(int i = 0; i<n; i++) {
         	arr[i] = Integer.parseInt(st.nextToken());
         }

         for(int i = 0; i<n; i++) {
        	 int num = 0;
        	 for(int j = i+1; j<n; j++) {
        		 for(int k = j+1; k<n; k++) {
        			 num = arr[i]+arr[j]+arr[k];
        			 if(num<=m) {
        				 ans = Math.max(ans, num);
        			 }
        		 }
        	 }
         }
         System.out.println(ans);
   	
    }
}