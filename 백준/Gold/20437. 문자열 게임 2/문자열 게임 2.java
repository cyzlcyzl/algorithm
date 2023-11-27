import java.io.*;
import java.util.*;
 
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
        int T = Integer.parseInt(br.readLine());
        for(int i = 0; i < T; i++) {
            String w = br.readLine();
            int k = Integer.parseInt(br.readLine()); 
         
            if(k == 1) {
                System.out.println("1 1");
                continue;
            }
 
            int[] alpha = new int[26];
            for(int j = 0; j < w.length(); j++) {
                alpha[w.charAt(j) - 'a']++;
            }
 
            int min = Integer.MAX_VALUE;
            int max = -1;
            for(int j = 0; j < w.length(); j++) {
                if(alpha[w.charAt(j) - 'a'] < k) continue;
 
                int count = 1;
                for(int l = j + 1; l < w.length(); l++) {
                    if(w.charAt(j) == w.charAt(l)) count++;
                    if(count == k) {
                        min = Math.min(min, l - j + 1);
                        max = Math.max(max, l - j + 1);
                        break;
                    }
                }
            }
            if(min == Integer.MAX_VALUE || max == -1) System.out.println("-1");
            else System.out.println(min + " " + max);
        }
    }        
}