import java.io.*;
import java.util.*;

public class Main{
    
    static int N;
    static int[][] cost;
    static boolean[] isVisited;
    static int[] select;
    static int answer;
    
    static void dfs(int depth){
        if(depth == N){
            answer = Math.min(answer, calculate());
            return;
        }
        
        for(int i = 0; i<N; i++){
            if(isVisited[i]) continue;
            select[depth] = i;
            isVisited[i] = true;
            dfs(depth + 1);
            isVisited[i] = false;
        }
    }
    
    static int calculate(){
        int sum = 0;
        for(int i = 0; i<N-1; i++){
            if(cost[select[i]][select[i+1]] == 0 || cost[select[N-1]][select[0]] == 0) {
                return Integer.MAX_VALUE;
            }
            sum += cost[select[i]][select[i+1]];
        }
        sum += cost[select[N-1]][select[0]];
        return sum;
    }
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		cost = new int[N][N];
		select = new int[N];
		isVisited = new boolean[N];
		
		for(int i = 0; i<N; i++){
		    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		    for(int k = 0; k<N; k++){
		        cost[i][k] = Integer.parseInt(st.nextToken());
		    }
		}
		
		answer = Integer.MAX_VALUE;
		dfs(0);
		System.out.println(answer);
	}
}
