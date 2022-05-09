import java.util.ArrayList;

class Solution {
    public int[] solution(int[] answers) {
        ArrayList<Integer> result = new ArrayList<>();
        
        int[] score = new int[]{ 0, 0, 0 };
        int[] first = { 1, 2, 3, 4, 5 };                    
        int[] second = { 2, 1, 2, 3, 2, 4, 2, 5 };          
        int[] third = { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 };   
        
        for (int i = 0; i < answers.length; i++) {
            int firstIdx = i % 5;
            int secondIdx = i % 8;
            int thirdIdx = i % 10;
            
            if (answers[i] == first[firstIdx]) score[0]++;
            if (answers[i] == second[secondIdx]) score[1]++;
            if (answers[i] == third[thirdIdx]) score[2]++;
        }
        
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < score.length; i++) {
            max = Math.max(max, score[i]);
        }
        
        for (int i = 0; i < score.length; i++) {
            if (score[i] == max) result.add(i);
        }
        
        int[] answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = (result.get(i) + 1);
        }

        return answer;
    }
}