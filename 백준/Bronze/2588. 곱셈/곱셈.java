import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


class Main{	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int a = Integer.parseInt(br.readLine());
		String b = br.readLine();
		
		System.out.printf("%d %d %d %d", a*(b.charAt(2)-'0'),a*(b.charAt(1)-'0'),a*(b.charAt(0)-'0'),a*Integer.parseInt(b));
		}
}
