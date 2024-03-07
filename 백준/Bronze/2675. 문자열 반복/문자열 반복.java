import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static int n;
    static int[] arr = new int[9];

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            String w = st.nextToken();

            for (int j = 0; j < w.length(); j++) {
                for (int k = 0; k < r; k++) {
                    System.out.print(w.charAt(j));
                }
            }
            System.out.println();
        }
    }
}