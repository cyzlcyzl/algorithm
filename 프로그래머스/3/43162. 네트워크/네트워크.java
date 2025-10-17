import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        Queue<Integer> network = new LinkedList<>();
        boolean[] isVisited = new boolean[computers.length];
        
        for (int i = 0; i<n; i++) {
            if (isVisited[i]) continue;
            
            network.add(i);
            isVisited[i] = true;
            
            while (!network.isEmpty()) {
                int node = network.poll();
                for (int j = 0; j<n; j++) {
                    if (!isVisited[j] && computers[node][j] == 1) {
                    network.add(j);
                    isVisited[j] = true;
                    }
                }
            }
            answer++;
        }
        
        return answer;
    }
}