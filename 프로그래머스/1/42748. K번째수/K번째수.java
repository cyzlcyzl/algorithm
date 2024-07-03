import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        List<Integer> answer = new ArrayList<>();
        for(int[] c : commands) {
            int[] slice = Arrays.copyOfRange(array, c[0]-1, c[1]);
            Arrays.sort(slice);
            answer.add(slice[c[2]-1]);
        }
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}