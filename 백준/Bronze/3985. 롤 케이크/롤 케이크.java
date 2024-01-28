import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int l = Integer.parseInt(br.readLine());
        int[] lst = new int[l+1];
        int n = Integer.parseInt(br.readLine());
        int[] lst2 = new int[n+1];

        for(int i=1; i<=n; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            lst2[i] = b-a+1;

            for(int j = a; j<=b; j++){
                if(lst[j] == 0){
                    lst[j] = i;
                }
            }
        }

        System.out.printf("%d\n%d",find1(lst2),find2(lst));
    }

    private static int find1(int[] lst2) {
        int max = lst2[0];
        int idx = 0;
        for (int i = 0; i < lst2.length; i++) {
            if(lst2[i] > max){
                max = lst2[i];
                idx = i;
            }
        }

        return idx;
    }

    private static int find2(int[] lst) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int num : lst) {
            if(num!=0) {
                count.put(num, count.getOrDefault(num, 0) + 1);
            }
        }

        int mode = 0;
        int maxCount = 0;
        for (Entry<Integer, Integer> entry : count.entrySet()) {
            if(entry.getValue() > maxCount){
                maxCount = entry.getValue();
                mode = entry.getKey();
            }
        }
        return mode;
    }
}