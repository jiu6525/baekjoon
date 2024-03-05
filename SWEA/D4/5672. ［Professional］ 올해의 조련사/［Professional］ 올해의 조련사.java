import java.io.*;

//기존의 줄과 새로운 줄 두 줄을 세운 다음
// 기존의 줄에서 가장 앞에 있는 앵무새 혹은 가장 뒤에 있는 앵무새를 새로운 줄의 마지막에 세우는 것을 반복하는 방식
public class Solution {
    static BufferedReader br;
    static StringBuilder sb;
    static int t,n;
    static char[] arr;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= t; tc++) {
            sb = new StringBuilder();
            n = Integer.parseInt(br.readLine());
            arr = new char[n];
            for (int i = 0; i < n; i++) {
                arr[i] = br.readLine().charAt(0);
            }
            binarySearch();
            System.out.printf("#%d %s\n",tc,sb);
        }
    }
//A
//C
//D
//B
//C
//B
    private static void binarySearch() {
        int start = 0;
        int end = n - 1;
        // 숫자 비교
        for (int i = 0; i < n; i++) {
            if (arr[start] < arr[end]) {
//                System.out.print(arr[start++]);
                sb.append(arr[start++]);
            } else if (arr[start] > arr[end]) {
//                System.out.print(arr[end--]);
                sb.append(arr[end--]);
            } else if (arr[start] == arr[end]) {        // 두개가 같다면 다음 글자를 확인하자
                int left = start + 1;
                int right = end - 1;
                while (true) {
                    if (right - left > 0) {        // 오른쪽 idx 가 더 클때
                        if (arr[left] < arr[right]) {  // arr[right]값이 더 크면 start 값 누적후 ++
//                            System.out.print(arr[start++]);
                            sb.append(arr[start++]);
                            break;
                        } else if (arr[left] > arr[right]) {
//                            System.out.print(arr[end--]);
                            sb.append(arr[end--]);
                            break;
                        }else{          // 다음꺼 또 확인
                            left++;
                            right--;
                        }
                    } else {
//                        System.out.print(arr[start++]);
                        sb.append(arr[start++]);
                        break;
                    }
                }
            }
        }
    }
}