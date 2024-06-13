import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static int n,m;
    static int[] nArr, mArr;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        nArr = new int[n];
        for (int i = 0; i < n; i++) {
            nArr[i] = Integer.parseInt(st.nextToken());
        }

        m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        mArr = new int[m];
        for (int i = 0; i < m; i++) {
            mArr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(nArr);
//        System.out.println(Arrays.toString(nArr));
//        System.out.println(Arrays.toString(mArr));

        for (int i = 0; i < m; i++) {
            int res = Arrays.binarySearch(nArr, mArr[i]);
            System.out.println(res < 0 ? 0 : 1);
        }
    }
}