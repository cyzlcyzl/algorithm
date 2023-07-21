import java.io.*;

public class Main {
    
    static boolean[] arr;
    static StringBuilder sb = new StringBuilder();
    
    public static void goldbach(int n){
        int min = Integer.MAX_VALUE;
        int tmp_a = 0;
        int tmp_b = 0;

        if(arr[n/2]) sb.append(n/2+" "+n/2).append("\n");
        else{

            for(int i = 3; i<=n; i++){
                if(! arr[i]) continue;
                int a = i;
                if(! arr[n-a]) continue;
                int b = n-a;

                if(Math.abs(a-b)<min){
                    min = Math.abs(a-b);
                    tmp_a = a;
                    tmp_b = b;
                }
            }
            sb.append(tmp_a+" "+tmp_b).append("\n");
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        // 소수 판별 arr - true면 소수
        arr = new boolean[10001];
        for(int i = 0; i<arr.length; i++) arr[i] = true;
        arr[0] = arr[1] = false;

        for(int i = 2; i*i<=10000; i++){
            if(! arr[i]) continue;
            for(int k = i*i; k<=10000; k += i){
                arr[k] = false;
            }
        }

        // 테스트 케이스 입력
        for(int i = 0; i<T; i++){
            int n = Integer.parseInt(br.readLine());
            goldbach(n);
        }

        sb.setLength(sb.length()-1);
        System.out.println(sb);
    }
}
