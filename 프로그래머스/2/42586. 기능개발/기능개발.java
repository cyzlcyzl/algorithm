import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i<progresses.length; i++){
            int progress = progresses[i];
            int speed = speeds[i];
            
            int day = 0;
            while(progress<100) {
                progress += speed;
                day++;
            }
            queue.add(day);
        }
        System.out.println(queue);
        List<Integer> result = new ArrayList<>();
            while(! queue.isEmpty()){
            int day = queue.remove();
            int cnt = 1;
            while (!queue.isEmpty()) {
                Integer next = queue.peek();
                if(next == null) continue;
                if (day < next) break;
                queue.poll();
                cnt++;
            }
            result.add(cnt);
        }
        int[] answer = new int[result.size()];
        for(int i = 0; i<answer.length; i++) answer[i] = result.get(i);
        return answer;
    }
}