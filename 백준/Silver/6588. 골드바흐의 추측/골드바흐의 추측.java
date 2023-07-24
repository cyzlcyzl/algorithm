import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static boolean[] isPrime;
    static int maxSize = 1000000;
    static StringBuilder sb = new StringBuilder();

    static void goldbach(int n){
        // n = a + b
        // b-a가 가장 큰 것을 출력
        // "Goldbach's conjecture is wrong."
        int a = 2;
        int b = n - a;
        while(! isPrime[a] || ! isPrime[b]){
            a++;
            b--;
            if(a>b) {
                sb.append("Goldbach's conjecture is wrong.").append("\n");
                return;
            }
        }
        sb.append(n + " = " + a + " + " + b).append("\n");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // true -> 소수
        isPrime = new boolean[maxSize + 1];
        for(int i = 0; i<isPrime.length; i++) isPrime[i] = true;
        isPrime[0] = isPrime[1] = false;
        for(int i = 2; i*i<=maxSize; i++){
            if(! isPrime[i]) continue;
            for(int k = i*i; k<=maxSize; k += i) isPrime[k] = false;
        }

        // 짝수 정수 6 ≤ n ≤ 1000000
        while(true){
            int n = Integer.parseInt(br.readLine());
            if(n==0) break;
            goldbach(n);
        }
        br.close();

        sb.setLength(sb.length()-1);
        System.out.println(sb);
    }
}
