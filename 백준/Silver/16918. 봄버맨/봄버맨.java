import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// ㅊ
public class Main {
    static StringTokenizer st;
    static int n, m, k;
    static int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        String[][] arr = new String[n][m];
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = String.valueOf(line.charAt(j));
            }
        }

        String[][] real = new String[n][m];
        String[][] bomb1 = new String[n][m];
        String[][] bomb2 = new String[n][m];

        for (int i = 0; i < n; i++) {
            Arrays.fill(real[i],"O");
            Arrays.fill(bomb1[i],"O");
            Arrays.fill(bomb2[i],"O");
        }

        if (k == 1) {
            print(arr);
        } else if (k % 2 == 0) {
            print(real);
        } else {
            getBoard(arr, bomb1);
            getBoard(bomb1, bomb2);
            if (k % 4 == 3){
                print(bomb1);
            }
            if (k % 4 == 1){
                print(bomb2);
            }
        }
    }

    private static void print(String[][] arr) {
        for (String[] lst1 : arr) {
            System.out.println(String.join("", lst1));
        }
    }

    private static void getBoard(String[][] bomb1, String[][] bomb2) {
        for (int i1 = 0; i1 < n; i1++) {
            for (int j1 = 0; j1 < m; j1++) {
                if (bomb1[i1][j1].equals("O")) {
                    bomb2[i1][j1] = ".";
                    for (int l = 0; l < dir.length; l++) {
                        int dx = i1 + dir[l][0];
                        int dy = j1 + dir[l][1];
                        if (dx < 0 || dy < 0 || dx >= n || dy >= m) {
                            continue;
                        }
                        bomb2[dx][dy] = ".";
                    }
                }
            }
        }
    }
}
