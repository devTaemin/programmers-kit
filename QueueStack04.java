import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public ArrayList<Integer> Array = new ArrayList<Integer>();
    public Queue<Integer> Q = new LinkedList<Integer>();
    
    public int[] solution(int[] prices) {
        for (int i = 0; i < prices.length; i++) {
            Q.add(prices[i]);
        }
        
        while(!Q.isEmpty()) {
            int price = Q.poll();
            int size = Q.size();
            
            int count = 0;
            Iterator<Integer> iter = Q.iterator();
            for (int i = 0; i < size; i++) {
                int compare = iter.next();
                count++;
                
                if (price > compare) break;  
            }
            
            Array.add(count);
        }
        
        int[] answer = new int[Array.size()];
        for (int i = 0; i < Array.size(); i++) {
            answer[i] = Array.get(i);
        }
        return answer;
    }
}