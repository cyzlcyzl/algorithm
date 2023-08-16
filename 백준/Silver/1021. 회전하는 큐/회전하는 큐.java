import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Main {
    static Deque<Integer> deque;
    static int cnt = 0;
    static void left(){
        deque.offerLast(deque.pollFirst());
        cnt++;
    }
    static void right(){
        deque.offerFirst(deque.pollLast());
        cnt++;
    }
    static int index(int n){
        int res = 0;
        int idx = 0;
        Iterator<Integer> it = deque.iterator();
        while(it.hasNext()){
            idx++;
            if(it.next().equals(n)) res = idx;
        }
        return res;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] nums = new int[M];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<nums.length; i++) nums[i] = Integer.parseInt(st.nextToken());

        deque = new ArrayDeque<>();
        for(int i = 1; i<=N; i++) deque.offerLast(i);


        for(int i = 0; i<nums.length; i++){
            int pick = nums[i];
            int idx = index(pick);
            while(! deque.peekFirst().equals(pick)){
                if(idx<=deque.size()/2) left();
                else if(deque.size()%2==1 && idx==deque.size()/2 +1) left();
                else if(idx>deque.size()/2) right();
            }
            deque.pollFirst();
        }

        System.out.println(cnt);

    }
}