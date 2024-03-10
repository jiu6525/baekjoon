import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static int n,ans;
    static String word;
    public static void main(String args[]) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        Map<Integer,Integer> ans = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            int num = Integer.parseInt(br.readLine())%42;
            ans.put(num, ans.getOrDefault(num,0)+1);
        }
        System.out.println(ans.size());


    }
}