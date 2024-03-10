import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static StringBuilder sb;
    static int n,idx,ans;
    static String str;
    public static void main(String args[]) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine();
        idx = Integer.parseInt(br.readLine());
        System.out.println(str.charAt(idx-1));
    }
}