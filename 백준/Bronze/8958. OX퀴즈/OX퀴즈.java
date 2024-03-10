import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static int n,ans;
    static String word;
    public static void main(String args[]) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            ans = 0;
            word = br.readLine();
            int num = 0;
            for (int j = 0; j < word.length(); j++) {
                char c = word.charAt(j);
                if(c == 'O'){
                    num++;
                }else{
                    num = 0;
                }
                ans += num;
            }
            System.out.println(ans);
        }

    }
}