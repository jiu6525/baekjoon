import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

    public class Main {
        static BufferedReader br;
        static StringTokenizer st;
        static int n;
        static BigInteger ans = new BigInteger("0");
        public static void main(String[] args) throws IOException {
            //System.setIn(new FileInputStream("src/input.txt"));
            br = new BufferedReader(new InputStreamReader(System.in));
            n = Integer.parseInt(br.readLine());
            String s = br.readLine();
            int m = 1234567891;
            for (int i = 0; i < n; i++) {
                ans = ans.add(BigInteger.valueOf(s.charAt(i) - 96).multiply(BigInteger.valueOf(31).pow(i)));
            }

            System.out.println(ans.remainder(BigInteger.valueOf(m)));
        }
    }