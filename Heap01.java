import java.util.Iterator;
import java.util.PriorityQueue;

class Solution {
    public PriorityQueue<Integer> pq = new PriorityQueue<>();
    
    public boolean check(int K) {
        Iterator<Integer> iter = pq.iterator();
        
        while (iter.hasNext()) {
            int level = iter.next();
            if (level < K) return false;
        }
        
        return true;
    }
    
    public int solution(int[] scoville, int K) {
        for (int i = 0; i < scoville.length; i++) {
            pq.add(scoville[i]);
        }
        
        int answer = 0;
        
        while(!check(K)) {
            answer++;
            
            if (pq.size() < 2) {
                answer = -1;
                break;
            }
            
            int first = pq.poll();
            int second = pq.poll();
            int combination = first + (second * 2);
            
            pq.add(combination);
        }
        
        return answer;
    }
}