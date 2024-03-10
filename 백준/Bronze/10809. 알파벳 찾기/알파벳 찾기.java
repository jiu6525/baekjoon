import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static int n,ans;
    static String word;
    static int[] alpha = new int[26];
    public static void main(String args[]) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        word = br.readLine();
        for (int i = 0; i < alpha.length; i++) {
            alpha[i] = word.indexOf((char)(i+97));
        }
        for (int i : alpha) {
            System.out.print(i + " ");
        }
    }
}