import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static StringBuilder sb;
    static int res = 1;
    static String word;
    static int[] ans = new int[10];
    public static void main(String args[]) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 3; i++) {
            res *= Integer.parseInt(br.readLine());
        }

        word = String.valueOf(res);
        for (int i = 0; i < word.length(); i++) {
            ans[Integer.parseInt(String.valueOf(word.charAt(i)))]++;
        }

        for (int i : ans) {
            System.out.println(i);
        }

    }
}