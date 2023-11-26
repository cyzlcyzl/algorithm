import java.io.*;
import java.util.*;

public class Main{

    static int N, M, K;
    static int count;
    static int[] moveX = {-1,1,0,0};
    static int[] moveY = {0,0,-1,1};
    static int[][] cabbage;
    static boolean[][] isVistied;

    static void bfs(int m, int n){
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{m, n});

        while(! queue.isEmpty()){
            int[] now = queue.poll();
            int x = now[0];
            int y = now[1];

            for(int i = 0; i<4; i++){
                int nX = x + moveX[i];
                int nY = y + moveY[i];

                if(nX >=0 && nY >=0 && nX<M && nY<N){
                    if(cabbage[nX][nY] == 1 && ! isVistied[nX][nY]){
                        queue.add(new int[]{nX, nY});
                        isVistied[nX][nY] = true;
                    }
                }
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());


        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<T; i++){
            count = 0;

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            cabbage = new int[M][N];
            isVistied = new boolean[M][N];
            for(int j = 0; j<K; j++){
                st = new StringTokenizer(br.readLine(), " ");
                int m = Integer.parseInt(st.nextToken());
                int n = Integer.parseInt(st.nextToken());
                cabbage[m][n] = 1;
            }

            for(int l = 0; l<M; l++){
                for(int k = 0; k<N; k++){
                    if(cabbage[l][k] == 1 && ! isVistied[l][k]){
                        isVistied[l][k] = true;
                        bfs(l, k);
                        count++;
                    }
                }
            }
            sb.append(count).append("\n");
        }
        sb.setLength(sb.length()-1);
        System.out.println(sb);
    }
}
