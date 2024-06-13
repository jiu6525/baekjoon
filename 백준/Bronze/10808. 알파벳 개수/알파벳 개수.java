import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static String word;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[] alpha = new int[26];
    public static void main(String[] args) throws IOException {
        word = br.readLine();
        for (int i = 0; i < word.length(); i++) {
            alpha[(int)word.charAt(i) - 97]++;
        }
        for (int i = 0; i < 26; i++) {
            System.out.print(alpha[i] + " ");
        }
    }
}