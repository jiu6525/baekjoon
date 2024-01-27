
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

// 스택을 사용
// 공백이라면 저장한 word 의 내용을 비우고 스택에 추가
// <를 만났다면 >를 만날때까지 단어 저장하기 -> check 를 통해 값 확인

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();
        Stack st = new Stack();
        boolean check = false;
        String ans = "";

        for (int i = 0; i<word.length(); i++){
            String w = String.valueOf(word.charAt(i));
            if(w.equals(" ")){
                while(st.size()>0){
                    ans += st.pop();
                }
                ans += w;
            }else if(w.equals("<")){
                while(st.size()>0){
                    ans += st.pop();
                }
                check = true;
                ans += w;
            }else if (w.equals(">")) {
                check = false;
                ans += w;
            }else if(check){
                ans += w;
            }else{
                st.push(w);
            }
        }
        while(st.size() >0){
            ans += st.pop();
        }
        System.out.println(ans);
    }
}
