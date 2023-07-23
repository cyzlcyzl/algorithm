import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int max = 10000000;
    static boolean[] isPrime;
    static StringBuilder sb = new StringBuilder();

    static void pf(int N, int num) {
        // N == 소수일 때까지 계속 나누기
        if(isPrime[N]){
            sb.append(N).append("\n");
            return;
        }

        if(N%num==0){
            sb.append(num).append("\n");
            pf(N/num, num);
        }else{
            num++;
            pf(N, num);
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // N (1 ≤ N ≤ 10,000,000)

        isPrime = new boolean[max + 1];
        for(int i = 0; i<isPrime.length; i++) isPrime[i] = true;
        isPrime[0] = isPrime[1] = false;

        for(int i = 2; i*i<=max; i++){
            if(! isPrime[i]) continue;
            for(int k = i*i; k<=max; k += i){
                isPrime[k] = false;
            }
        }

        if(N!=1) {
            // 소인수분해
            pf(N, 2);
            sb.setLength(sb.length()-1);
            System.out.println(sb);
        }
    }
}

