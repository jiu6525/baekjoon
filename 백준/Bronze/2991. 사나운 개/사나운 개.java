import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] dog = new int[4];

        for (int i = 0; i < 4; i++) {
            dog[i] = Integer.parseInt(st.nextToken());
        }

        int ab = dog[0] + dog[1];
        int cd = dog[2] + dog[3];

        st = new StringTokenizer(br.readLine());

        int[] lst = new int[3];
        for (int i = 0; i < 3; i++) {
            int people = Integer.parseInt(st.nextToken());
            int n = people % ab;
            int m = people % cd;
            if (n!=0 && n <= dog[0]) {
                ++lst[i];
            }
            if (m!=0 && m <= dog[2]) {
                ++lst[i];
            }
        }

        for (int i : lst) {
            System.out.println(i);
        }

    }
}