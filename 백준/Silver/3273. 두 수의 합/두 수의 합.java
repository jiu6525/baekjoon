import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static int n,m;
    static int[] arr;
    static int s, e, ans;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        arr = new int[n];

        s = 0;
        e = n-1;

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        m = Integer.parseInt(br.readLine());
        while(s<e){
            int res = arr[s] + arr[e];
            if(res == m){
                s++;
                e--;
                ans++;
            }else if(res < m){
                s++;
            }else{
                e--;
            }
        }

        System.out.println(ans);
    }
}