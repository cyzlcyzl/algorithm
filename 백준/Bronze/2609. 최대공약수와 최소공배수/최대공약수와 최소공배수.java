import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static int GCD(int a, int b){
        if(a%b==0) return b;
        else return GCD(b, a%b);
    }
    public static int LCM(int a, int b){
        // a와 b의 최대공약수를 구한 다음에 그 공약수로 나눈 몫들을 다 곱함
        int gcd = GCD(a, b);

        return a/gcd * b/gcd * gcd;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        // 최대공약수
        System.out.println(GCD(a,b));
        // 최소공배수
        System.out.println(LCM(a,b));
    }
}
