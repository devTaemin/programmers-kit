import java.util.*;

class Solution {
    public ArrayList<Integer> Result = new ArrayList<>();
    public String[] Array;
    public String[] Combination;
    public boolean[] Visited;
    
    public int solution(String numbers) {
        int size = numbers.length();

        Array = numbers.split("");
        Visited = new boolean[size];
        
        for (int len = 1; len <= size; len++) {
            Combination = new String[len];
            DFS(len, 0);
        }
        
        return Result.size();
    }
    
    public void DFS(int len, int index) {
        
        if (index == len) {
            if (Combination[0].equals("0")) return;
        	
        	StringBuilder builder = new StringBuilder();
        	for (int i = 0; i < len; i++) {
        		builder.append(Combination[i]);
        	}
            
            String result = builder.toString();
            int number = Integer.parseInt(result);
            if (isPrime(number)) {
                if (!Result.contains(number)) Result.add(number);
            }
            
            return;
        }
        
        for (int i = 0; i < Visited.length; i++) {
            if (!Visited[i]) {
                Visited[i] = true;
                Combination[index] = Array[i];
                DFS(len, index + 1);
                Visited[i] = false;
            }
        }
    }
    
    public boolean isPrime(int number) {
        if (number <= 1) return false;
        
        for (int i = 2; i * i <= number; i++) {
            if (number % i == 0) return false;
        }
        return true;
    }
}