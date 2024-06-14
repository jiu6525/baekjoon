import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static int n;
    static String[] arr;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static HashSet<String> set;
    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        set = new HashSet();
        for (int i = 0; i < n; i++) {
            set.add(br.readLine());
        }

        arr = set.toArray(new String[0]);

        Arrays.sort(arr, (a,b) -> {
            if(a.length() == b.length()){
                return a.compareTo(b);
            }else{
                return a.length() - b.length();
            }
        });

        for (String a : arr) {
            System.out.println(a);
        }
    }
}