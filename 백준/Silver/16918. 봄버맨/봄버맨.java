import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

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
            for (int j = 0; j < m; j++) {
                real[i][j] = "O";
                bomb1[i][j] = "O";
                bomb2[i][j] = "O";
            }
        }

        if (k <= 1) {
            for (String[] lst1 : arr) {
                System.out.println(String.join("", lst1));
            }
        } else if (k % 2 == 0) {
            for (String[] lst2 : real) {
                System.out.println(String.join("", lst2));
            }
        } else {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (arr[i][j].equals("O")) {
                        bomb1[i][j] = ".";
                        for (int l = 0; l < dir.length; l++) {
                            int dx = i + dir[l][0];
                            int dy = j + dir[l][1];
                            if (dx < 0 || dy < 0 || dx >= n || dy >= m) {
                                continue;
                            }
                            bomb1[dx][dy] = ".";
                        }
                    }
                }
            }

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


        if (k % 4 == 3){
            for (String[] lst3 : bomb1) {
                System.out.println(String.join("", lst3));
            }
        }

        if (k % 4 == 1){
            for (String[] lst4 : bomb2) {
                System.out.println(String.join("", lst4));
            }
        }

        }
    }
}
