import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static int n,res = Integer.MAX_VALUE, se,ee;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int start = 0;
        int end = n-1;

        while(start<end){
            int num = Math.abs(arr[start] + arr[end]);
            if(num < res){
                res = num;
                se = arr[start];
                ee = arr[end];
            }
            if(arr[start] + arr[end] < 0){
                start++;
            }else{
                end--;
            }
        }
//        print();
        System.out.println(se + " " + ee);
    }

    private static void print() {
        System.out.println(Arrays.toString(arr));
    }
}