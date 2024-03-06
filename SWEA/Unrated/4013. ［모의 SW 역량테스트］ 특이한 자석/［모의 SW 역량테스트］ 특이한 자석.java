import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

// 자석 전체를 받을 배열 선언
// 1 시계 -1 반시계
//   1  2   3  4
// 2  6  2 6  2  6
public class Solution {
    static BufferedReader br;
    static StringTokenizer st;
    static int magnetic = 4,t, n,ans;
    static int[][] arr;

    static int[] turn;
    static int range = 2*magnetic-1;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= t; tc++) {
            n = Integer.parseInt(br.readLine());
            arr = new int[magnetic+1][8];
                 // 자석이 돌수 있는지 확인용
            ans = 0;
            for (int i = 1; i <= magnetic; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 2*magnetic; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int[] right = new int[]{0,2,2,2};
            int[] left = new int[]{0,0,6,6,6};
            for (int i = 0; i < n; i++) {
                turn = new int[magnetic+1];
                st = new StringTokenizer(br.readLine());
                int r = Integer.parseInt(st.nextToken());
                int d = Integer.parseInt(st.nextToken());
                turn[r] = d;

                for (int j = r; j < magnetic; j++) {
                    if(arr[j][right[j]] != arr[j+1][left[j+1]]){
                        turn[j+1] -= turn[j];
                    }
                }

                for (int j = r-1; j >= 1; j--) {
                    if(arr[j][right[j]] != arr[j+1][left[j+1]]){
                        turn[j] -= turn[j+1];
                    }
                }


                for (int j = 1; j < turn.length; j++) {
                    if(j == 1){
                        int num = right[j] + turn[j] * -1;
                        num = num <0 ? range : (num>range ? 0 : num);
                        right[j] = num;
                    }else if(j == 2){
                        int num = right[j] + turn[j] * -1;
                        num = num <0 ? range : (num>range ? 0 : num);
                        right[j] = num;

                        int num2 = left[j] + turn[j] * -1;
                        num2 = num2 <0 ? range : (num2>range ? 0 : num2);
                        left[j] = num2;
                    } else if (j == 3) {
                        int num = right[j] + turn[j] * -1;
                        num = num <0 ? range : (num>range ? 0 : num);
                        right[j] = num;

                        int num2 = left[j] + turn[j] * -1;
                        num2 = num2 <0 ? range : (num2>range ? 0 : num2);
                        left[j] = num2;
                    }else{
                        int num = left[j] + turn[j] * -1;
                        num = num <0 ? range : (num>range ? 0 : num);
                        left[j] = num;
                    }
                }

//              2,2,3,5
//              -> 3 > 2 = 1 > 0
//              -> 5 > 6 = -1 > 0
            }
            // 한회전씩 계산인줄 알고 30분동안 찾음 문제를 잘 읽자
//                System.out.println();
//                System.out.println(Arrays.toString(turn));
//                System.out.println(Arrays.toString(right));
//                System.out.println(Arrays.toString(left));
//                System.out.println();
                for (int j = 1; j < magnetic; j++) {
                    int num = right[j] - 2;
                    num = num < 0 ? range+1+num: (num>range ? num-range:num);
                    ans += arr[j][num] == 1? 1<<j-1:0;
                }

                int num = left[4] - 6;
                num = num < 0 ? range+1+num : (num>range ? num-range:num);
                ans += arr[4][num] == 1 ? 1 << 3:0;

            System.out.printf("#%d %s\n", tc, ans);

//            print();
        }
    }

    private static void print() {
        for (int i = 1; i <= magnetic; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }
        System.out.println();
    }
}