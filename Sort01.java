import java.util.Arrays;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int len = commands.length;
        int[] answer = new int[len];
        
        for (int index = 0; index < len; index++) {
            int i = commands[index][0];
            int j = commands[index][1];
            int k = commands[index][2];
            
            int[] copyArr = Arrays.copyOfRange(array, i - 1, j);
            Arrays.sort(copyArr);
            answer[index] = copyArr[k - 1];
        }
        
        return answer;
    }
}