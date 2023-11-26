import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] time = new int[N];
		int[] pay = new int[N];
		for(int i = 0; i<N; i++){
		    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		    time[i] = Integer.parseInt(st.nextToken());
		    pay[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] dp = new int[N+1];
		for(int i = 0; i<N; i++){
		    int next = i + time[i];
		    if(next < N+1){
		        dp[next] = Math.max(dp[next], dp[i] + pay[i]);
		    }
		    dp[i+1] = Math.max(dp[i+1], dp[i]);
		}
		System.out.println(dp[N]);
	}
}
