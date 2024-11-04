import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

    public class Main {
        static BufferedReader br;
        static StringTokenizer st;
        static int n,m;
        static int[] arr;
        static long min = 0,max = Integer.MIN_VALUE;
        public static void main(String[] args) throws IOException {
            //System.setIn(new FileInputStream("src/input.txt"));
            br = new BufferedReader(new InputStreamReader(System.in));
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(br.readLine());
                max = Math.max(max, arr[i]);
            }


            max++;

            while(min < max) {
                long mid = (max + min)/2;

                long count = 0;

                for (int i = 0; i < n; i++) {
                    count += arr[i]/mid;
                }

                if(count < m){
                    max = mid;
                }else{
                    min = mid + 1;
                }
            }

            System.out.println(min - 1);
        }
    }