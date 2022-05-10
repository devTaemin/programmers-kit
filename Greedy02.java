import java.util.ArrayList;

class Solution {
    public ArrayList<Integer> NotAIndex = new ArrayList<>();
    public int[] NotAIndexArray;
    public int NumOfCommand = Integer.MAX_VALUE;
    public int[] Sequence;
    public boolean[] Visited;
    char[] NameArr;
    int Cursor;
    int NameLength;
    
    public char[] Alphabet = new char[]{
        'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M',
        'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'
    };
    
    public int solution(String name) {
        NameArr = name.toCharArray();
        NameLength = name.length();
        
        for (int i = 0; i < NameArr.length; i++) {
            if (NameArr[i] != 'A') NotAIndex.add(i);
        }
        
        int len = NotAIndex.size();
        NotAIndexArray = new int[len];
        for (int i = 0; i < len; i++) {
            NotAIndexArray[i] = NotAIndex.get(i);
        }
        
        Visited = new boolean[len];
        Sequence = new int[len];
        
        DFS(len, 0);
        
        return NumOfCommand;
    }
    
    public void Calculate(int len) {
        Cursor = 0;
        int commandTotal = 0;
        
        for (int i = 0; i < len; i++) {
            int targetIdx = Sequence[i];
            int leftCount = 0;
            int rightCount = 0;
            
            if (Cursor < targetIdx) {
                rightCount = targetIdx - Cursor;
                leftCount = Cursor + (NameLength - targetIdx);
            }
            
            if (Cursor > targetIdx) {
                rightCount = (NameLength - Cursor) + targetIdx;
                leftCount = Cursor - targetIdx;
            }
                        
            int minMove = Math.min(leftCount, rightCount);
            Cursor = targetIdx;
            commandTotal += minMove;
            
            int numOfChange = change(NameArr[targetIdx], len);
            commandTotal += numOfChange;
        }
        
        NumOfCommand = Math.min(NumOfCommand, commandTotal);
    }   
    
    public int change(char c, int len) {
        int upCount = (int)c - 65;
        int downCount = 26 - upCount;
        
        return Math.min(upCount, downCount);
    }
    
    public void DFS(int len, int index) {
        if (index == len) {
            Calculate(len);
            return;
        }
        
        for (int i = 0; i < len; i++) {
            if (!Visited[i]) {
                Visited[i] = true;
                Sequence[index] = NotAIndexArray[i];
                DFS(len, index + 1);
                Visited[i] = false;
            }
        }  
    }
}