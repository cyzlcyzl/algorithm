import java.io.*;
import java.util.*;

public class Main{

    static int N, K;
    static int second;
    static boolean[] isVisited = new boolean[100001];
    static Queue<HideAndSeek> queue = new LinkedList<>();

    public static class HideAndSeek{
        int index;
        int second;

        public HideAndSeek(int index, int second) {
            this.index = index;
            this.second = second;
        }

        public int getIndex() {
            return index;
        }

        public int getSecond() {
            return second;
        }
    }

    static void bfs(HideAndSeek hideAndSeek){

        queue.offer(hideAndSeek);

        while(! queue.isEmpty()){
            HideAndSeek now = queue.poll();
            int nowIdx = now.getIndex();
            int nowSec = now.getSecond();

            if(nowIdx == K) {
                second = Math.min(second, nowSec);
                continue;
            }

            int way1 = nowIdx + 1;
            int way2 = nowIdx - 1;
            int way3 = nowIdx * 2;

            visitNode(way1, nowSec);
            visitNode(way2, nowSec);
            visitNode(way3, nowSec);

        }
    }

    static void visitNode(int next, int nowSec){
        if(next >= 0 && next <= 100000){
            if(! isVisited[next]){
                queue.offer(new HideAndSeek(next, nowSec+1));
                isVisited[next] = true;
            }
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        if(N == K) System.out.println(0);
        else{
            second = Integer.MAX_VALUE;
            isVisited[N] = true;
            bfs(new HideAndSeek(N, 0));
            System.out.println(second);
        }
    }
}
