import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static StringBuilder sb;
    static int n,ans;
    static String str;
    public static void main(String args[]) throws IOException {
        str = "         ,r'\"7\n" + 	// \", \n 이 제어문자다.
                "r`-_   ,'  ,/\n" + 		// \n 이 제어문자다.
                " \\. \". L_r'\n" + 		// \\, \", \n 이 제어문자다.
                "   `~\\/\n" + 			// \\, \n 이 제어문자다.
                "      |\n" + 			// \n 이 제어문자다.
                "      |";
        System.out.println(str);
    }
}