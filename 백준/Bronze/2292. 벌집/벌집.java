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

            int count = 1;
            int range = 2;

            if(n == 1){
                System.out.println(1);
            }else{
                while(range <= n){
                    range = range + (count * 6);
                    count++;
                }
                System.out.println(count);
            }
        }
    }