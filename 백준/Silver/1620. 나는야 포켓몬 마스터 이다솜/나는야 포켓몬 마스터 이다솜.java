import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<String, Integer> pokemon = new HashMap<>();
        List<String> pokemon2 = new ArrayList<>();
        for(int i = 1; i<=N; i++){
            String input = br.readLine();
            pokemon.put(input, i);
            pokemon2.add(input);
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<M; i++){
            String input = br.readLine();
            if((int) input.charAt(0) >= 65){
                // 문자가 들어왔으면
                sb.append(pokemon.get(input)).append("\n");
            }
            else{
                // 숫자가 들어왔으면
                String name = pokemon2.get(Integer.parseInt(input)-1);
                sb.append(name).append("\n");
            }
        }

        sb.setLength(sb.length()-1);
        System.out.println(sb);
    }
}
