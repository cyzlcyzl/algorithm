import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] time = new int[N][2];
        for(int i = 0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            time[i][0] = Integer.parseInt(st.nextToken());
            time[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(time, (a,b) -> a[1] != b[1]? a[1]-b[1] : a[0]-b[0]); // 끝나는 시간 오름차순 정렬

        int start = 0;
        int k = 0;
        int cnt = 1;
        if(time[start][0] == time[start][1]) cnt = 0;
        while(start<N){
            if(time[start][1]<=time[k][0]){
                start = k++;
                cnt++;
            }else k++;
            if(k==N) break;
        }

        System.out.println(cnt);

    }
}
