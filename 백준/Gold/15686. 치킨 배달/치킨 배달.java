import java.io.*;
import java.util.*;

public class Main{
    
    static int N, M;
    static int[][] map;
    static List<int[]> houses;
    static List<int[]> chickens;
    static boolean[] isVisited;
    static int answer;
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		
		houses = new ArrayList<>();
		chickens = new ArrayList<>();
		for(int i = 0; i<N; i++){
		    st = new StringTokenizer(br.readLine(), " ");
		    for(int k = 0; k<N; k++){
		        int val = Integer.parseInt(st.nextToken());
		        map[i][k] = val;
		        if(val == 1) houses.add(new int[]{i, k});
		        else if (val == 2) chickens.add(new int[]{i, k});
		    }
		}
		
		isVisited = new boolean[chickens.size()];
		answer = Integer.MAX_VALUE;
		backTracking(0, 0);
		
		System.out.println(answer);
	}
	
	static void backTracking(int depth, int start){
        if(depth == M){
            int distance = getDistance();
            answer = Math.min(answer, distance);
            return;
        }
        
        for(int i = start; i<chickens.size(); i++){
            if(isVisited[i]) continue;
            isVisited[i] = true;
            backTracking(depth + 1, i);
            isVisited[i] = false;
        }
        
    }
    
    static int getDistance(){
        int res = 0;
        for(int k = 0; k<houses.size(); k++){
            int min = Integer.MAX_VALUE;
            
            for(int i = 0; i<chickens.size(); i++){
                if(! isVisited[i]) continue;
                int[] chickensIdx = chickens.get(i);
                int[] housesIdx = houses.get(k);
                int distance = Math.abs(chickensIdx[0] - housesIdx[0]) + Math.abs(chickensIdx[1] - housesIdx[1]);
                min = Math.min(min, distance);
                }
            res += min;
        }
        return res;
    }
}
