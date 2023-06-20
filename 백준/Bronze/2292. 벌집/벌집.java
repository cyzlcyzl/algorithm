import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// 1 2~7(6)  8~19(12)  20~37(18) ...
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine())-1;
		br.close();
		
		int cnt = 1;
		
		if(N==0) {
			System.out.println(cnt);
		}else {
			while(N>0) {
				N -= 6 * cnt;
				cnt++;
			}
			
			System.out.println(cnt);
		}
	}
}