import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] isPrime;
    static StringBuilder sb = new StringBuilder();

    public static void primeNum(int n){
        int cnt = 0;
        for(int i = n+1; i<=2*n; i++){
            if(isPrime[i] != 0) cnt++;
        }
        sb.append(cnt).append("\n");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int maxNum = 123456*2;
        isPrime = new int[maxNum+1];
        for(int i = 0; i< isPrime.length; i++) isPrime[i] = i;
        isPrime[1] = 0;
        for(int i = 2; i*i<=maxNum; i++){
            if(isPrime[i] == 0) continue;
            for(int k = i*i; k<=maxNum; k += i){
                if(k%i==0) isPrime[k] = 0;
            }
        }

        while(true){
            int n = Integer.parseInt(br.readLine());
            if(n == 0) break;
            primeNum(n);
        }
        sb.setLength(sb.length()-1);
        System.out.println(sb);
    }
}
