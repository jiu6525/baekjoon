import java.io.*;
import java.util.*;

class Main {
    static int n, m, ans;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static HashMap<String, List<String>> group = new HashMap<>();
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            String groupName = br.readLine();
            int c = Integer.parseInt(br.readLine());
            List<String> name = new ArrayList<>();
            for (int j = 0; j < c; j++) {
                name.add(br.readLine());
            }
            Collections.sort(name);
            group.put(groupName, name);
        }

        // 1 - key, 0 - value
        for (int i = 0; i < m; i++) {
            String name = br.readLine();
            int type = Integer.parseInt(br.readLine());

            for (Map.Entry<String, List<String>> entry : group.entrySet()) {
                if(type == 0 && name.equals(entry.getKey())){
                    for (String value : entry.getValue()) {
                        System.out.println(value);
                    }
                }else{
                    for (String value : entry.getValue()) {
                        if(value.equals(name)){
                            System.out.println(entry.getKey());
                            break;
                        }
                    }
                }
            }
        }
    }
}