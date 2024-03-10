import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static int n,ans;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        String word = br.readLine();
        for (int i = 0; i < n; i++) {
            ans += Integer.parseInt(String.valueOf(word.charAt(i)));
        }

        System.out.println(ans);
    }
}