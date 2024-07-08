import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;



public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        String[][] arr = new String[n][2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = st.nextToken();
            arr[i][1] = st.nextToken();
        }
        Arrays.sort(arr, Comparator.comparingInt(a -> Integer.parseInt(a[0])));

        for (String[] a : arr) {
            System.out.println(a[0] + " " + a[1]);
        }

    }
}