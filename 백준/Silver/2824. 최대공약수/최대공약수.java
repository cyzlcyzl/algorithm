import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {

    static BigInteger gcd(String[] N, String[] M){
        BigInteger n = multi(N);
        BigInteger m = multi(M);

        return n.gcd(m);
    }

    static BigInteger multi(String[] arr){

        BigInteger res = new BigInteger("1");

        for(String i : arr) {
            BigInteger num = new BigInteger(i);
            res = res.multiply(num);
        }

        return res;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] arrN = br.readLine().split(" ");
        int M = Integer.parseInt(br.readLine());
        String[] arrM = br.readLine().split(" ");
        br.close();

        String res = gcd(arrN, arrM).toString();

        if(res.length()>9) System.out.println(res.substring(res.length()-9, res.length()
        ));
        else System.out.println(res);

    }
}
