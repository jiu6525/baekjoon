import java.io.*;
import java.util.*;

class Main {
    static int n, m;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static boolean dup,flag;
    static char[] words;
    public static void main(String[] args) throws IOException {
        int left = 0, right = 0;
        boolean flag = false;
        String line = br.readLine();
        for (int i = 0; i < line.length(); i++) {
            if(line.charAt(i) == '@'){
                if (!flag){
                    left++;
                }else{
                    right++;
                }
            } else if (line.charAt(i) == '0') {
                flag = true;
            }
        }
        System.out.println(left + " " + right);


    }
}