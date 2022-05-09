import java.util.Collections;
import java.util.PriorityQueue;


class Solution {
    public PriorityQueue<Integer> ascPQ = new PriorityQueue<>();
    public PriorityQueue<Integer> descPQ = new PriorityQueue<>(Collections.reverseOrder());
    
    public int[] solution(String[] operations) {
        int len = operations.length;
        
        for (int i = 0; i < len; i++) {
            String[] operation = operations[i].split(" ");
            String command = operation[0];
            int data = Integer.parseInt(operation[1]);
            
            if (command.equals("I")) {
                ascPQ.add(data);
            }
            else if (command.equals("D")) {
                if (data == 1) {
                    while(!ascPQ.isEmpty()) {
                        data = ascPQ.poll();
                        descPQ.add(data);
                    }
                    
                    descPQ.poll();
                    
                    while(!descPQ.isEmpty()) {
                        data = descPQ.poll();
                        ascPQ.add(data);
                    }
                    
                }
                else {
                    ascPQ.poll();
                }
            }
        }
        
        int[] answer = new int[2];
        if (ascPQ.isEmpty()) {
            answer[0] = 0;
            answer[1] = 0;
        }
        else {
            int min = ascPQ.peek();
            
            while(!ascPQ.isEmpty()) {
                int data = ascPQ.poll();
                descPQ.add(data);
            }
            
            int max = descPQ.peek();
            
            answer[0] = max;
            answer[1] = min;
        }
        
        return answer;
    }
}