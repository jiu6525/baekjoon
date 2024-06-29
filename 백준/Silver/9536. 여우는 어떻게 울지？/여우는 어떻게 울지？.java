import java.io.*;
import java.util.*;

class Main {
    static int n, m;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        for (int j = 0; j < n; j++) {
            List<String> ans = new ArrayList<>();
            List<String> words = Arrays.asList(br.readLine().split(" "));
            while(true){
                st = new StringTokenizer(br.readLine());
                int count = st.countTokens();
                if(count == 5){
                    break;
                }

                for (int i = 0; i < 2; i++) {
                    st.nextToken();
                }
                String sound = st.nextToken();
                for (int i = 0; i < words.size(); i++) {
                    if(words.get(i).equals(sound)){
                        words.set(i," ");
                    }
                }
            }
            for (String word : words) {
                if(!word.trim().isEmpty()){
                    ans.add(word);
                }
            }

            System.out.println(String.join(" ",ans));
        }
    }
}