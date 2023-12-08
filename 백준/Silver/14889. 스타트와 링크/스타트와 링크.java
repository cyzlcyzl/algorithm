import java.io.*;
import java.util.*;

public class Main{
    
    static int N, cnt;
    static int[][] team;
    static int[] select;
    static boolean[] isVisited;
    static int answer;
    
    static void dfs(int depth, int idx){
        if(depth == cnt){

            List<Integer> startTeam = new ArrayList<>();
            List<Integer> linkTeam = new ArrayList<>();
            for(int i = 0; i<N; i++){
                if(isVisited[i]) startTeam.add(i);
                else linkTeam.add(i);
            }
            answer = Math.min(answer, calculate(startTeam, linkTeam));
            return;
        }
        
        for(int i = idx; i<N; i++){
            if(isVisited[i]) continue;
            isVisited[i] = true;
            dfs(depth + 1, i + 1);
            isVisited[i] = false;
        }
    }
    
    static int calculate(List<Integer> startTeam, List<Integer> linkTeam){
        int start = 0;
        int link = 0;
        for(int i = 0; i<cnt-1; i++){
            for(int k = i+1; k<cnt; k++){
                start += team[startTeam.get(i)][startTeam.get(k)];
                start += team[startTeam.get(k)][startTeam.get(i)];
                link += team[linkTeam.get(i)][linkTeam.get(k)];
                link += team[linkTeam.get(k)][linkTeam.get(i)];
            }
        }
        return Math.abs(start - link);
    }
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		team = new int[N][N];
		select = new int[N];
		isVisited = new boolean[N];
		cnt = N / 2;
		
		for(int i = 0; i<N; i++){
		    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		    for(int k = 0; k<N; k++){
		        team[i][k] = Integer.parseInt(st.nextToken());
		    }
		}
		
		answer = Integer.MAX_VALUE;
		dfs(0, 0);
		System.out.println(answer);
		
	}
}
