import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String word1 = br.readLine();
		String word2 = br.readLine();
		
		int[] word1Cnt = new int[26];
		int[] word2Cnt = new int[26];
		
		for(int i = 0; i<word1.length(); i++){
		    word1Cnt[(int)(word1.charAt(i))-'a']++;
		}
		
		for(int i = 0; i<word2.length(); i++){
		    word2Cnt[(int)(word2.charAt(i))-'a']++;
		}
		
		int answer = 0;
		for(int i = 0; i<26; i++){
		    int minus = word1Cnt[i] - word2Cnt[i];
		    if(minus == 0) continue;
		    answer += Math.abs(minus);
		}
		
		System.out.println(answer);
	}
}
