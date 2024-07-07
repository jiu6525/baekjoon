import java.io.*;
import java.util.*;

class Main {
    static int n, m;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static boolean dup,flag;
    static char[] words;
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        char target = st.nextToken().charAt(0);
        int count = 0;
        for (int i = 1; i <= s; i++) {
            String str = String.valueOf(i);
            for (int j = 0; j < str.length(); j++) {
                if (str.charAt(j) == target) {
                    count++;
                }
            }

        }

        System.out.println(count);

    }
}