import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, R, s, b, res;
    static int[] S, B;
    static boolean[] isSelected;
    static int min;

    public static void subset(int n){
        if(n == N){
            for(int i = 0; i<N; i++){
                if(isSelected[i]){
                    // 신맛 곱
                    s *= S[i];
                    // 쓴맛 합
                    b += B[i];
                }
            }
            if(s!=1 && b!=0) {
                res = s>b?s-b:b-s;
                if(min == -1 || res<min) min = res;
            }
                s = 1;
                b = 0;
            return;
        }

        isSelected[n] = true;
        subset(n+1);

        isSelected[n] = false;
        subset(n+1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        S = new int[N];
        B = new int[N];
        s = 1;
        b = 0;
        isSelected = new boolean[N];
        min = -1;
        res = 0;

        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            S[i] = Integer.parseInt(st.nextToken());
            B[i] = Integer.parseInt(st.nextToken());
        }
        br.close();
        // 조합할 수 있는 모든 경우의 수를 구해서 그 중 신맛 - 쓴맛 min 출력
        subset(0);
        System.out.println(min);
    }
}
