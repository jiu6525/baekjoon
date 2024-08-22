import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static BufferedReader br;
    public static int n;
    public static Map<String, Integer> map;
    public static boolean flag;
    public static int ans;

    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("src/input.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        String[] fruit = br.readLine().split(" ");
        int left = 0, right = 0;

        map = new HashMap<>();

        while (right < n) {
            map.put(fruit[right], map.getOrDefault(fruit[right], 0) + 1);

            while (map.size() > 2) {
                map.put(fruit[left], map.get(fruit[left]) - 1);
                if (map.get(fruit[left]) == 0) {
                    map.remove(fruit[left]);
                }
                left++;
            }

            ans = Math.max(ans, right - left + 1);
            right++;
        }

        System.out.println(ans);
    }
}