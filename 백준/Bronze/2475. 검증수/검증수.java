import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static StringBuilder sb;
    static int res;
    static String word;
    static int[] ans = new int[10];
    public static void main(String args[]) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 5; i++) {
            res += Math.pow(Integer.parseInt(st.nextToken()),2);
        }
        System.out.println(res%10);
    }
}