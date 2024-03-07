import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static int res = -1;
    static char ans  = '?';
    static int[] arr = new int[26];

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        for (int i = 0; i < s.length(); i++){
            if ('A' <= s.charAt(i) && s.charAt(i) <= 'Z') {
                arr[s.charAt(i) - 'A']++;
            }

            else {
                arr[s.charAt(i) - 'a']++;
            }
        }

        for (int i = 0; i < 26; i++) {
            if (arr[i] > res) {
                res = arr[i];
                ans = (char) (i + 65);
            }
            else if (arr[i] == res) {
                ans = '?';
            }
        }

        System.out.print(ans);

    }
}