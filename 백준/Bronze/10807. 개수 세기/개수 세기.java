import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String input = br.readLine();
        String[] arr = input.split(" ");
        String V = br.readLine();

        br.close();

        int cnt = 0;

        for(String s : arr){
            if(s.equals(V)){
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}
