class Solution {
    public int[] solution(int brown, int yellow) {        
        int row = 3;
        int col = 3;
        int maxRow = 3;
        int maxCol = 3;
        
        while (true) {
            if ((row * maxCol) - ((row - 2) * (maxCol - 2)) >= brown) break;
            maxCol++;
        }
        
        while (true) {
            if ((maxRow - 2) * (col - 2) >= yellow) break;
            maxRow++;
        }
        
        boolean find = false;
        for (row = 3; row <= maxRow; row++) {
            for (col = 3; col <= maxCol; col++) {
                int numOfYellow = (row - 2) * (col - 2);
                int numOfBrown = (row * col) - numOfYellow;
                
                if (numOfYellow == yellow && numOfBrown == brown) {
                    find = true;
                    break;
                }
            }
            
            if (find) break;
        }
        
        int[] answer = new int[2];
        answer[0] = col;
        answer[1] = row;
        
        return answer;
    }
}