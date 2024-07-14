import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    static int[] student;
    static int[] ans;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n, m = 20;
    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        ans = new int[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            st.nextToken();
            student = new int[m];

            for (int j = 0; j < m; j++) {
                student[j] = Integer.parseInt(st.nextToken());
            }

            for (int j = 1; j < m; j++) {
                for (int k = 0; k < j; k++) {
                    if(student[k] > student[j]){
                        ans[i] ++;
//                        int tmp = student[j];
//                        student[j] = student[k];
//                        student[k] = tmp;
//                        break;
                    }
                }
            }

//            System.out.println(Arrays.toString(student));


        }
        for (int j = 0; j < n; j++) {
            System.out.printf("%d %d\n",j+1, ans[j]);
        }
    }
}