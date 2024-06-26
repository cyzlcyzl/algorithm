import java.util.*;

class Solution {
    
    static Set<Integer> set;
    static boolean[] isVisited;
    static int[] selected;
    
    public static void dfs(int idx, int depth, int[] numbers) {
        if (depth == 2) {
            int sum = 0;
            for(int i = 0; i<2; i++) sum += numbers[selected[i]];
            set.add(sum);
            return;
        }
        
        for (int i = idx; i<numbers.length; i++) {
            if (isVisited[i]) continue;
            selected[depth] = i;
            isVisited[i] = true;
            dfs(i, depth+1, numbers);
            isVisited[i] = false;
        }
    }
    
    public static int[] solution(int[] numbers) {
        set = new HashSet<>();
        isVisited = new boolean[numbers.length];
        selected = new int[2];
        dfs(0, 0, numbers);
        
        int[] answer = new int[set.size()];
        Iterator<Integer> iter = set.iterator();
        int idx = 0;
        while(iter.hasNext()) answer[idx++] = iter.next();
        Arrays.sort(answer);
        return answer;
    }
}