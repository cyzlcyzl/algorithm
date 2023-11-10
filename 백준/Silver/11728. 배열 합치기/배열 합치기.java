import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{

    static int N;
    static int M;
    static int[] A;
    static int[] B;
    static StringBuilder sb = new StringBuilder();

    static void twoPointer(){
        int start_A = 0;
        int start_B = 0;

        for(int i = 0; i<N+M; i++){

            if(start_A == N){
                sb.append(B[start_B++]).append(" ");
                continue;
            } else if (start_B == M) {
                sb.append(A[start_A++]).append(" ");
                continue;
            }

            int a = A[start_A];
            int b = B[start_B];

            if(a<=b) {
                sb.append(a).append(" ");
                start_A++;
            }else{
                sb.append(b).append(" ");
                start_B++;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        A = new int[N];
        B = new int[M];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<N; i++) A[i] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<M; i++) B[i] = Integer.parseInt(st.nextToken());

        twoPointer();

        System.out.println(sb);
    }
}