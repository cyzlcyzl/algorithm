import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static boolean[] isPrime;

    static int goldbach(int N){
        int cnt = 0;
        int a = 2;
        while(a<=N/2){
            if(isPrime[a] && isPrime[N-a]) cnt++;
            a++;
        }

        return cnt;
    }

    static void isPrime(){
        int max = 1000000;
        isPrime = new boolean[max+1];
        for(int i = 0; i< isPrime.length; i++) isPrime[i] = true;
        isPrime[0] = isPrime[1] = false;

        for(int i = 0; i*i<=max; i++){
            if(! isPrime[i]) continue;
            for(int k = i*i; k<=max; k+=i){
                isPrime[k] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        isPrime();
        for(int i = 0; i<T; i++){
            int N = Integer.parseInt(br.readLine());
            sb.append(goldbach(N)).append("\n");
        }

        sb.setLength(sb.length()-1);
        System.out.println(sb);
    }
}
