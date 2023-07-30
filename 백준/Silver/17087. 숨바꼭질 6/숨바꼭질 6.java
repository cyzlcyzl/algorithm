import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    // 최대공약수
    static int gcd(int a, int b){
        if(b == 0) return a;
        else return gcd(b, a%b);
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 동생
        int S = Integer.parseInt(st.nextToken()); // 위치
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<arr.length; i++) arr[i] = Math.abs(S-Integer.parseInt(st.nextToken()));
        br.close();

        // 최대공약수
        if(N==1) System.out.println(arr[0]);
        else{
            int gcd = gcd(arr[0], arr[1]);
            for(int i = 1; i<arr.length; i++) gcd = gcd(gcd, arr[i]);
            System.out.println(gcd);
        }

    }
}
