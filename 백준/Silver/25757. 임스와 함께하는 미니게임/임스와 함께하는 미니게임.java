import java.io.*;
import java.util.*;

class Main {
    static int n, ans;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static HashSet<String> player = new HashSet<>();
    static String type;
    // Y - 2, F - 3, O - 4
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        type = st.nextToken();

        for (int i = 0; i < n; i++) {
            player.add(br.readLine());
        }

        System.out.println(player.size() / (type.equals("Y") ? 1 : (type.equals("F") ? 2 : 3)));
    }
}