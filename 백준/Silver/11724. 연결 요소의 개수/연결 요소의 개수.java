import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N, M, cnt;
    static ArrayList<Integer>[] graph;
    static boolean[] isVisited;

    public static void dfs(int now){
        for(int i : graph[now]){
            if(isVisited[i]) continue;
            isVisited[i] = true;
            dfs(i);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        cnt = 0;
        graph = new ArrayList[N+1];
        isVisited = new boolean[N+1];
        for(int i = 0; i<graph.length; i++) graph[i] = new ArrayList<>();

        for(int i = 0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u].add(v);
            graph[v].add(u);
        }
        br.close();

        for(int i = 1; i< graph.length; i++){
            if(isVisited[i]) continue;
            dfs(i);
            cnt++;
        }
        
        System.out.println(cnt);
    }
}
