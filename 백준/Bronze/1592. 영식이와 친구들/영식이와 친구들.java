import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];

        int num = 0, cnt = 0, idx = 0;
        arr[0] = 1;

        while(num < m) {
            ++cnt;
            num = arr[idx];

            if(arr[idx] % 2 != 0) {
                idx = (idx + l)%n;
            }else {
                idx = (idx-l<0) ? idx-l+n : idx-l;
            }
            arr[idx] += 1;
        }
        System.out.println(cnt-1);
    }
}
