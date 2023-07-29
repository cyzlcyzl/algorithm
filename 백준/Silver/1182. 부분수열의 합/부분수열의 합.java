import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, S, cnt, sum;
    static int[] arr;
    static boolean[] isSelected;

    static void subset(int size){
        // 종료 조건
        if(size == N){
            for(int i = 0; i<N; i++){
                if(isSelected[i]) sum += arr[i];
            }
            if(sum==S) cnt++;
            sum = 0;
            return;
        }

        // 확장
        isSelected[size] = true;
        subset(size + 1);
        isSelected[size] = false;
        subset(size + 1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N= Integer.parseInt(st.nextToken());
        S= Integer.parseInt(st.nextToken());
        arr = new int[N];
        isSelected = new boolean[N];
        cnt = 0;
        sum = 0;
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<N; i++) arr[i] = Integer.parseInt(st.nextToken());
        br.close();

        // 부분수열
        subset(0);
        if(S==0) cnt--;
        System.out.println(cnt);

    }
}
