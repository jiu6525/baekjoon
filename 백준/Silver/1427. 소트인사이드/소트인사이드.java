import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static String word;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static Integer[] arr;
    public static void main(String[] args) throws IOException {
        word = br.readLine();
        arr = new Integer[word.length()];
        for (int i = 0; i < word.length(); i++) {
            arr[i] = Integer.parseInt(String.valueOf(word.charAt(i)));
        }

        Arrays.sort(arr, Collections.reverseOrder());

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
    }
}