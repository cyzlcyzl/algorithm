import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M, V;
    static ArrayList<Integer>[] graph;
    static StringBuilder sb = new StringBuilder();
    static boolean isVisited[];

    static void dfs(int node){
        sb.append(node).append(" ");

        for(int next : graph[node]){
            if(isVisited[next]) continue;
            isVisited[next] = true;
            dfs(next);
        }
    }

    static void bfs(int node){
        Queue<Integer> que = new LinkedList<>();
        que.add(node);

        while(! que.isEmpty()){
            int now = que.poll();
            sb.append(now).append(" ");

            for(int next : graph[now]){
                if(isVisited[next]) continue;
                isVisited[next] = true;
                que.add(next);
            }
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());
        graph = new ArrayList[N+1];
        isVisited = new boolean[N+1];
        for(int i = 0; i< graph.length; i++) graph[i] = new ArrayList<>();

        for(int i = 0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u].add(v);
            graph[v].add(u);
        }

        for(int i = 0; i< graph.length; i++) Collections.sort(graph[i]);

        isVisited[V] = true;
        dfs(V);
        System.out.println(sb);

        sb = new StringBuilder();
        isVisited = new boolean[N+1];

        isVisited[V] = true;
        bfs(V);
        System.out.println(sb);
    }
}
