import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public ArrayList<Integer> Array = new ArrayList<Integer>();
    public Queue<Progress> Queue = new LinkedList<Progress>();
    
    public int[] solution(int[] progresses, int[] speeds) {
        int len = progresses.length;
        for (int i = 0; i < len; i++) {
            Queue.add(new Progress(progresses[i], speeds[i]));
        }
        
        while (!Queue.isEmpty()) {
            Progress p = Queue.poll();
            int count = 1;
            int prog = p.getP();
            int speed = p.getS();
            int time = ((100 - prog) % speed == 0) ?
                        (100 - prog) / speed :
                        ((100 - prog) / speed) + 1;
            

            int size = Queue.size();
            for (int i = 0; i < size; i++) {
                Progress up = Queue.poll();
                up.updateP(time);
                Queue.add(up);
            }
            

            while (true) {
                if (Queue.isEmpty()) break;
                
                Progress cp = Queue.peek();
                int current = cp.getP();
                if (current >= 100) {
                    Queue.poll();
                    count++;
                    continue;
                }
                
                break;
            }
            
            Array.add(count);  
        }
        
        int size = Array.size();
        int[] answer = new int[size];
        for (int i = 0; i < size; i++) {
            answer[i] = Array.get(i);
        }
        
        return answer;
    }
}

class Progress {
    private int p;
    private int s;
    
    public Progress(int p, int s) {
        this.p = p;
        this.s = s;
    }
    
    public int getP() {
        return this.p;
    }
    
    public int getS() {
        return this.s;
    }
    
    public void updateP(int time) {
        this.p += this.s * time;
    }
}