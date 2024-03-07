import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static int idx,ans;
    static int[] arr = new int[9];

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 0; i < 9; i++) {
            if(ans<arr[i]){
                ans = arr[i];
                idx = i;
            }
        }
        System.out.print(ans + "\n" + (idx+1));

//        print();
    }

    private static void print() {
        System.out.println(Arrays.toString(arr));
    }
}