import java.util.Arrays;
import java.util.ArrayList;
import java.util.Iterator;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        
        Arrays.sort(lost);
        Arrays.sort(reserve);
        
        ArrayList<Integer> surplus = new ArrayList<>();
        boolean[] uniform = new boolean[n + 1];
        
        Arrays.fill(uniform, true);
        
        for (int i = 0; i < lost.length; i++) {
            uniform[lost[i]] = false;
        }
        
        for (int i = 0; i < reserve.length; i++) {
            int index = reserve[i];
            boolean find = false;
            
            for (int j = 0; j < lost.length; j++) {
                if (index == lost[j]) {
                    find = true;
                    break;
                }
            }
            
            if (find) {
                uniform[index] = true;
                continue;
            } 
            
            surplus.add(index);
        }
        
        Iterator<Integer> iter = surplus.iterator();
        while(iter.hasNext()) {
            int index = iter.next();
            int frontIdx = index - 1;
            int rearIdx = index + 1;
            
            if (frontIdx > 0) {
                    if (uniform[frontIdx] == false) {
                    uniform[frontIdx] = true;
                    continue;
                }
            }
            
            if (rearIdx <= n) {
                    if (uniform[rearIdx] == false) {
                    uniform[rearIdx] = true;
                    continue;
                }
            }
            
        }
        
        
        for (int i = 1; i <= n; i++) {
            if (uniform[i] == true) answer++;
        }
        
        return answer;
    }
}