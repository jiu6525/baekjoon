import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static int h, w, n, m, ans;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        h = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int hv = h / (n + 1) + (h % (n + 1) == 0 ? 0 : 1);
        int wv = w / (m + 1) + (w % (m + 1) == 0 ? 0 : 1);
        ans = hv * wv;
        System.out.println(ans);
    }
}