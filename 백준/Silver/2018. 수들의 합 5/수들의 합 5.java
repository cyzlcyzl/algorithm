import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // 투포인터
        int start = 1;
        int end = 1;
        int sum = 1;
        int cnt = 0; // 횟수 체크

        while(end<=N){
            if(sum == N){
                cnt++;
                sum -= start;
                start++;
            }else if(sum > N){
                sum -= start;
                start++;
            }else{
                end++;
                sum += end;
            }
        }

        System.out.println(cnt);

    }
}
