import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int M, N;
    static int[][] tomato;
    static int[] moveX = {-1, 1, 0, 0};
    static int[] moveY = {0, 0, -1, 1};
    static Queue<int[]> queue = new LinkedList<>();

    static void bfs(){
        while (! queue.isEmpty()){
            int[] now = queue.poll();
            int nowX = now[0];
            int nowY = now[1];

            for(int i = 0; i<4; i++){
                int nextX = nowX + moveX[i];
                int nextY = nowY + moveY[i];

                if(nextX>=0 && nextY>=0 && nextX<N && nextY<M){
                    if(tomato[nextX][nextY]==0) {
                        tomato[nextX][nextY] = tomato[nowX][nowY] + 1;
                        queue.add(new int[]{nextX, nextY});
                    }
                }
            }
        }
        if(checkZero()) System.out.println(-1);
        else System.out.println(findMax());
    }

    static boolean checkZero(){
        for(int i = 0; i<N; i++){
            for(int k = 0; k<M; k++){
                if(tomato[i][k] == 0) return true;
            }
        }
        return false;
    }

    static int findMax(){
        int max = Integer.MIN_VALUE;
        for(int i = 0; i<N; i++){
            for(int k = 0; k<M; k++){
                if(tomato[i][k]>max) max = tomato[i][k];
            }
        }
        if(max==1) return 0;
        return max-1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        tomato = new int[N][M];

        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int k = 0; k<M; k++){
                tomato[i][k] = Integer.parseInt(st.nextToken());
                if(tomato[i][k] == 1) queue.offer(new int[]{i,k});
            }
        }

        bfs();
    }
}
