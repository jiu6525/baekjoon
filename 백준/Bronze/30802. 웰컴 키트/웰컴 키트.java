import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

    public class Main {
        static BufferedReader br;
        static StringTokenizer st;
        static int n;
        static int t,p;
        static int[] arr = new int[6];
        static int Tans;
        public static void main(String[] args) throws IOException {
            //System.setIn(new FileInputStream("src/input.txt"));
            br = new BufferedReader(new InputStreamReader(System.in));
            n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 6; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            t = Integer.parseInt(st.nextToken());
            p = Integer.parseInt(st.nextToken());

            for (int i = 0; i < 6; i++) {
                if(arr[i] != 0){
                    if(arr[i] % t == 0){
                        Tans += arr[i]/t;
                    }else{
                        Tans += arr[i]/t + 1;
                    }
                }
            }

            System.out.println(Tans);
            System.out.println(n/p + " " + n%p);
        }
    }