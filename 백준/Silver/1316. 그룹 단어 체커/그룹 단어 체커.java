import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int sum = 0;
		
		for(int i = 0; i<N; i++) {
			int cnt = 0;
			String input = br.readLine();
			
			if(input.length()<=2) {
				sum++;
				continue;
			}
			
			
			String[] arr = input.split("");
			
			// 바로 다음 문자와 다를 때: 그 뒤부터 있으면 안 됨
			
			
			for(int k = 0; k<arr.length-1; k++) {
				int j = k+1;
				while(arr[k].equals(arr[j])) {
					if(j == arr.length-1) {
						break;
					}
						j++;
				}
				
				if(! ((input.substring(j+1, input.length())).contains(arr[k]))){
					cnt++;
			}
				
			}
			
			if(cnt == arr.length-1) {
				sum++;
			}
			
		}
		
		bw.write(sum+"");
		
		br.close();
		bw.flush();
		bw.close();
		
	}

}