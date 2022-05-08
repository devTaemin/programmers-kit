import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public Queue<Integer> Queue = new LinkedList<Integer>();
    public boolean[] Visited;
    public int[] Sequence;
    
    public int solution(int[] priorities, int location) {
        Visited = new boolean[priorities.length];
        Sequence = new int[priorities.length];
        
        for (int i = 0; i < priorities.length; i++) {
            Queue.add(i);
        }
        
        int count = 1;
        while(!Queue.isEmpty()) {
            int index = Queue.poll();
            boolean isFind = false;
            
            for (int i = 0; i < priorities.length; i++) {
                if (!Visited[i] && (priorities[i] > priorities[index])) {
                    Queue.add(index);
                    isFind = true;
                    break;
                }
            }
            
            if (!isFind) {
                Visited[index] = true;
                Sequence[index] = count++;
            }
        }
        
        int answer = Sequence[location];
        return answer;
    }
}