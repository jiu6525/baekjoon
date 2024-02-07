import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static int n, m, r;
    static int[][] arr;
    static int[] sel;
    static boolean flag = true;

    public static void main(String[] args) throws Exception {
        //System.setIn(new FileInputStream("src/homework/Main.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        sel = new int[r];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < r; i++) {
            sel[i] = Integer.parseInt(st.nextToken());
        }

        for (int i : sel) {
            switch (i){

                case 1:
                    arr = calculate1(arr);
                    break;
                case 2:
                    arr = calculate2(arr);
                    break;
                case 3:
                    arr = calculate3(arr);
                    break;
                case 4:
                    arr = calculate4(arr);
                    break;
                case 5:
                    arr = calculate5(arr);
                    break;
                case 6:
                    arr = calculate6(arr);
                    break;
            }
        }


        for (int[] lst : arr) {
            for (int num : lst) {
                System.out.print(num+" ");
            }
            System.out.println();
        }

    }

    /*
    00 01 02 03 04 05
    10 11 12 13 14 15
    20 21 22 23 24 25
    30 31 32 33 34 35

//  5
    20 21 22 00 01 02
    30 31 32 10 11 12
    23 24 25 03 04 05
    33 34 35 13 14 15

//  6
    03 04 05 23 24 25
    13 14 15 33 34 35
    00 01 02 20 21 22
    10 11 12 30 31 32
     */

    private static int[][] calculate1(int[][] tmp) {
        int[][] arr1 = new int[n][m];
        for (int i = 0; i< n; i++) {
            for (int j = 0; j < m; j++) {
                arr1[i][j] = tmp[n-i-1][j];
            }
        }

        return arr1;
    }



    private static int[][] calculate2(int[][] tmp) {
        int[][] arr2 = new int[n][m];
        for (int i = 0; i< n; i++) {
            for (int j = 0; j < m; j++) {
                arr2[i][j] = tmp[i][m-j-1];
            }
        }
        return arr2;
    }

    private static int[][] calculate3(int[][] tmp) {
        int[][] arr3 = new int[m][n];
        for (int i = 0; i< n; i++) {
            for (int j = 0; j < m; j++) {
                arr3[j][n-i-1] = tmp[i][j];
            }
        }

        swap();
        return arr3;
    }


    private static int[][] calculate4(int[][] tmp) {
        int[][] arr4 = new int[m][n];

        for (int i = 0; i< n; i++) {
            for (int j = 0; j < m; j++) {
                arr4[m-j-1][i] = tmp[i][j] ;
            }
        }
        swap();
        return arr4;
    }

    private static int[][] calculate5(int[][] tmp) {

        int n_mid = arr.length;
        int m_mid = arr[0].length;

        int[][] arr5 = new int[n_mid][m_mid];

        for (int i = 0; i < n_mid / 2; i++) {
            for (int j = 0; j < m_mid / 2; j++) {
                arr5[i][(m_mid / 2) + j] = tmp[i][j];
            }
        }

        for (int i = 0; i < n_mid / 2; i++) {
            for (int j = m_mid / 2; j < m_mid; j++) {
                arr5[(n_mid / 2) + i][j] = tmp[i][j];
            }
        }

        for (int i = n_mid / 2; i < n_mid; i++) {
            for (int j = m_mid / 2; j < m_mid; j++) {
                arr5[i][j - (m_mid / 2)] = tmp[i][j];
            }
        }

        for (int i = n_mid / 2; i < n_mid; i++) {
            for (int j = 0; j < m_mid / 2; j++) {
                arr5[i - (n_mid / 2)][j] = tmp[i][j];
            }
        }

        return arr5;
    }


    private static int[][] calculate6(int[][] tmp) {
        int n_mid = arr.length;
        int m_mid = arr[0].length;

        int[][] arr6 = new int[n_mid][m_mid];
        for (int i = 0; i < n_mid / 2; i++) {
            for (int j = 0; j < m_mid / 2; j++) {
                arr6[(n_mid/2)+i][j] = tmp[i][j];
            }
        }

        for (int i = n_mid/2; i<n_mid; i++) {
            for (int j = 0; j<m_mid/2; j++) {
                arr6[i][(m_mid/2)+j] = tmp[i][j];
            }
        }

        for (int i = n_mid/2; i<n_mid; i++) {
            for (int j = m_mid/2; j<m_mid; j++) {
                arr6[i-(n_mid/2)][j] = tmp[i][j];
            }
        }

        for (int i =0; i < n_mid/2; i++) {
            for (int j = m_mid/2; j < m_mid; j++) {
                arr6[i][j-(m_mid/2)] = tmp[i][j];
            }
        }


        return arr6;
    }

    private static void swap() {
        int temp = n;
        n = m;
        m = temp;

    }
}

//3 3 1
//1 2 3
//4 5 6
//7 8 9
//1