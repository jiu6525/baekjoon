import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

    public class Main {
        static BufferedReader br;
        static StringTokenizer st;
        static int n = 3;
        static String[] arr = new String[n];
        static int ans;
        public static void main(String[] args) throws IOException {
            //System.setIn(new FileInputStream("src/input.txt"));

            String f = "Fizz";
            String b = "Buzz";
            String fb = "FizzBuzz";

            br = new BufferedReader(new InputStreamReader(System.in));
            for (int i = 0; i < n; i++) {
                arr[i] = br.readLine();
            }

            for (int i = n-1; i >= 0; i--) {
                if(!arr[i].equals(f) && !arr[i].equals(b) && !arr[i].equals(fb)) {
                    ans = Integer.parseInt(arr[i]) + n-i;
                    break;
                }
            }

            System.out.println(ans % 3 == 0 && ans % 5 == 0 ? fb : ans % 3 == 0 ? f : ans % 5 == 0 ? b : ans);
        }
    }