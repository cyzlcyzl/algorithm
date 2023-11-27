import java.util.*;
import java.io.*;

public class Main{

    static int N;
    static int count;
    static int[] graph;
    static boolean isVisited[];

    static void dfs(int now){
        int next = graph[now];

        if(isVisited[next]) {
            return;
        }
        else {
            isVisited[next] = true;
            dfs(next);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i<T; i++){
            count = 0;
            N = Integer.parseInt(br.readLine());

            graph = new int[N+1];
            isVisited = new boolean[N+1];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 1; j<=N; j++){
                int node = Integer.parseInt(st.nextToken());
                graph[j] = node;
            }

            for(int k = 1; k<=N; k++){
                if(isVisited[k]) continue;
                isVisited[k] = true;
                dfs(k);
                count++;
            }
            System.out.println(count);
        }
    }
}
