import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N, cnt;
    static int[] arr;
    static boolean[] isPrimeNum;
    public static int primeNum(){
        isPrimeNum[0] = isPrimeNum[1] = true; // false면 소수
        for(int i = 2; i*i<=1000; i++){
            if(isPrimeNum[i]) continue;
            for(int k = i*i; k<=1000; k += i){
                if(k%i == 0) isPrimeNum[k] = true;
            }
        }

        for(int i = 0; i<arr.length; i++){
            if(! isPrimeNum[arr[i]]) cnt++;
        }

        return cnt;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        isPrimeNum = new boolean[1001];

        String input = br.readLine();
        for(int i = 0; i<N; i++) arr[i] = Integer.parseInt(input.split(" ")[i]);

        primeNum();
        System.out.println(cnt);
    }
}
