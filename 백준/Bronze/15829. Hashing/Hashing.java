import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

    public class Main {
        static BufferedReader br;
        static StringTokenizer st;
        static int n;
        static int ans;
        public static void main(String[] args) throws IOException {
            //System.setIn(new FileInputStream("src/input.txt"));
            br = new BufferedReader(new InputStreamReader(System.in));
            n = Integer.parseInt(br.readLine());
            String s = br.readLine();
            for (int i = 0; i < s.length(); i++) {
                ans += (int) ((s.charAt(i) - 96) * Math.pow(31,i));
            }

            System.out.println(ans);
        }
    }