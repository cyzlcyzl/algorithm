import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, X, count, max;
    static int[] visitor;

    static void findMax(int X) {

        for (int i = N; i >= 0; i--) {
            if (i - X < 0) continue;
            int cal = visitor[i] - visitor[i - X];
            if (cal > max) {
                max = cal;
                count = 1;
            } else if (cal == max) count++;
        }

        if (visitor[N] == 0) System.out.println("SAD");
        else {
            System.out.println(max);
            System.out.println(count);
        }
    }


        public static void main (String[]args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine(), " ");
        visitor = new int[N + 1];
        for (int i = 0; i < N; i++) {
            visitor[i + 1] = Integer.parseInt(st.nextToken()) + visitor[i];
        }
        count = 0;
        max = 0;
        findMax(X);
    }
}
