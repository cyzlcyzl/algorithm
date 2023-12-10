import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
        
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[N][M];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0; i<R; i++) {
			for(int j=0; j< Math.min(N, M)/2; j++) {
				
				int temp = map[j][j];
				
				for(int k=j; k<M-j-1; k++) map[j][k] = map[j][k+1];
				for(int k=j; k<N-1-j; k++) map[k][M-j-1] = map[k+1][M-j-1];
				for(int k=M-j-1; k>j; k--) map[N-1-j][k] = map[N-1-j][k-1];
				for(int k=N-j-1; k>j; k--) map[k][j] = map[k-1][j];
				
                map[j+1][j] = temp;
			}
		}
        
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				sb.append(map[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

}