import java.io.*;

public class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] words = br.readLine().toCharArray();
		
		StringBuilder sb = new StringBuilder();
		for(char c : words){
		    int num = (int) c;
		    if(num<97) sb.append((char)(c+32));
		    else sb.append((char)(c-32));
		}
		System.out.println(sb);
	}
}
