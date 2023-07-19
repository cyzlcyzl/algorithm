import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;
    static StringBuilder sb = new StringBuilder();
    public static void primeNum(int M, int N){
        arr = new int[N+1];
        for(int i = 0; i<arr.length; i++) arr[i] = i; // 배열 생성
        arr[1] = 0;
        
        // 어떤 수의 배수가 되는 것은 0으로 값 변경
        for(int i = 2; i<=N; i++){
            if(arr[i] == 0) continue; // 이미 0이 됐으면 패스

            for(int k = 2; k*i<=N; k++){ // i의 배수만 돌면 되기 때문에 k*i로 범위 잡아줌
                arr[k*i] = 0;
            }
        }

        for(int i = M; i<=N; i++){
            if(arr[i] != 0) sb.append(i).append("\n");
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        br.close();

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        // 소수 구하기
        // 소수: 1과 자기 자신만을 약수로 갖고 있음
        primeNum(M, N);
        sb.setLength(sb.length()-1);
        System.out.println(sb);
    }
}
