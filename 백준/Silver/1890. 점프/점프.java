import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    
    static int N;
    static int[][] arr;
    static long[][] dp;
    
    static void jump(){
        dp[0][0] = 1;
        
        for(int i = 0; i<N; i++){
            for(int k = 0; k<N; k++){
                int val = arr[i][k];
                if(val == 0) break;
                if(i + val < N) dp[i+val][k] += dp[i][k];
                if(k + val < N) dp[i][k+val] += dp[i][k];
            }
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        dp = new long[N][N];
        
        for(int i = 0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int k = 0; k<N; k++){
                arr[i][k] = Integer.parseInt(st.nextToken());
            }
        }
        
        jump();
        System.out.println(dp[N-1][N-1]);
    }
}