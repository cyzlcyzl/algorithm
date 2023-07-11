import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        Queue<Integer> que = new ArrayDeque<>();

        int offer = 1;
        for(int i = 1; i<=N; i++){
            que.offer(offer++);
        }

        while(que.size() > 1){
            que.poll();
            que.offer(que.poll());
        }
        System.out.println(que.peek());
    }
}
