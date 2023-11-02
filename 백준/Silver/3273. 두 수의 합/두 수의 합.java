import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
    static int n;
    static int[] arr;
    static int x;
    static int count;

    public static void twoPointer(){
        int start = 0;
        int end = n-1;

        while (start < end) {
            int sum = arr[start] + arr[end];
            if(sum == x) {
                count++;
                start++;
                end--;
            }
            else if(sum > x) end--;
            else start++;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i<n; i++) arr[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr);
        
        x = Integer.parseInt(br.readLine());

        count = 0;
        twoPointer();
        System.out.println(count);
    }
}