import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
    static BufferedReader br;
    static StringTokenizer st;
    static int t,size = 9,sum = 45,ans;
    static int[][] arr = new int[size][size];
    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= t; tc++) {
            ans = 1;
            for (int i = 0; i < size; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < size; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
//            print();
            checkStraight();
            checkSquare();
            System.out.printf("#%d %d\n",tc,ans);
        }
    }

    private static void checkStraight() {
        for (int i = 0; i < size; i++) {
            rc(i,0,0,0);
            rc(0,i,0,1);
        }
    }

    private static void rc(int x, int y, int cnt, int dir) {
        if (x < 0 || y < 0 || x >= size || y >= size) {
            if (cnt != sum) {
                ans = 0;
            }
            return;
        }

        if (dir == 1) { // Left-to-right
            rc(x + 1, y, cnt + arr[x][y], dir);
        } else if (dir == 0) { // Top-to-bottom
            rc(x, y + 1, cnt + arr[x][y], dir);
        }
    }

    private static void checkSquare() {
        for (int si = 1; si <= size; si+=3) {
            for (int sj = 1; sj <= size ; sj+=3) {
                int ck = 0;
                for (int i = si; i < si+3; i++) {
                    for (int j = sj; j < sj+3; j++) {
                        ck += arr[i-1][j-1];
                    }
                }
                if(ck != sum){
                    ans = 0;
                }
            }
        }
    }

    private static void print() {
        for (int[] lst : arr) {
            System.out.println(Arrays.toString(lst));
        }
        System.out.println();
    }
}
