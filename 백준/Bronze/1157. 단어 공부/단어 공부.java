import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String s = br.readLine().toUpperCase();
		int[] arr = new int[26];
		
		for(int i = 0; i<26; i++) {
			int cnt = 0;
			for(int k = 0; k<s.length(); k++) {
				if((char)(i+65) == s.charAt(k)) {
					cnt++;
				}
			}
			arr[i] = cnt;
		}
		int max = 0;
		int I = 0;
		for(int i = 0; i<arr.length; i++) {
			if(arr[i]>max) {
				max = arr[i];
				I = i+65;
			}
		}
		
		int cnt = 0;
		for(int i = 0; i<arr.length; i++) {
			if(arr[i] == max) {
				cnt++;
			}
		}
		if(cnt>=2) {
			bw.write("?"+"");
		}else {			
			bw.write((char)I+"");
		}
		
		br.close();
		bw.flush();
		bw.close();
	}

}
