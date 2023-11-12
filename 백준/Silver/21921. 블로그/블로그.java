import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int X;
    static int[] visitor;
    static int[] prefix_sum;
    static int max;
    static int cnt;

    static void findMax(){
        for(int i = N-1; i>=0; i--){
            int cal = 0;
            if(i-X <-1) continue;
            else if(i-X == -1) cal = prefix_sum[i];
            else cal = prefix_sum[i] - prefix_sum[i-X];
            if(cal > max) {
                max = cal;
                cnt = 1;
            }else if (cal == max) cnt++;
        }
        System.out.println(max);
        System.out.println(cnt);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        visitor = new int[N];
        prefix_sum = new int[N];
        max = cnt = 0;

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i< visitor.length; i++) visitor[i] = Integer.parseInt(st.nextToken());
        prefix_sum[0] = visitor[0];
        for(int i = 1; i<N; i++) prefix_sum[i] = prefix_sum[i-1] + visitor[i];

        if(prefix_sum[N-1] == 0) System.out.println("SAD");
        else findMax();

    }
}
