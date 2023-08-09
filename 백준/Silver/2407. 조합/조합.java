import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {

    static BigInteger combination(String n, String m){

        BigInteger a = new BigInteger(n);
        BigInteger b = new BigInteger(m);

        for(int i = Integer.parseInt(n)-1; i>Integer.parseInt(n)-Integer.parseInt(m); i--) a = a.multiply(BigInteger.valueOf(i));
        for(int i = Integer.parseInt(m)-1; i>1; i--) b = b.multiply(BigInteger.valueOf(i));

        return a.divide(b);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        br.close();

        String n = st.nextToken();
        String m = st.nextToken();

        System.out.println(combination(n, m));
    }
}
