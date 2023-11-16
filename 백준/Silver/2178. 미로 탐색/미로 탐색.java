import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] maze;
    static boolean[][] isVisited;
    static int[] moveX = {-1, 1, 0, 0};
    static int[] moveY = {0,0,-1,1};

    static void bfs(int x, int y){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});

        while(!queue.isEmpty()){
            int[] now = queue.poll();
            int nowX = now[0];
            int nowY = now[1];

            for(int i = 0; i<4; i++){
                int nextX = nowX + moveX[i];
                int nextY = nowY + moveY[i];

                if(nextX>=0 && nextY>=0 && nextX <N && nextY<M){
                    if(maze[nextX][nextY] == 1 && ! isVisited[nextX][nextY]){
                        isVisited[nextX][nextY] = true;
                        queue.add(new int[]{nextX, nextY});
                        maze[nextX][nextY] = maze[nowX][nowY] + 1;
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        maze = new int[N][M];
        isVisited = new boolean[N][M];
        for(int i = 0; i<N; i++){
            String[] input = br.readLine().split("");
            for(int k = 0; k<M; k++){
                maze[i][k] = Integer.parseInt(input[k]);
            }
        }

        isVisited[0][0] = true;
        bfs(0,0);
        System.out.println(maze[N-1][M-1]);
    }
}
