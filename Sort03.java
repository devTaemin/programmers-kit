import java.util.Arrays;

class Solution {
    public int solution(int[] citations) {     
        int H = 0;
        int N = citations.length;
        Arrays.sort(citations);
        
        int max = citations[N - 1];
        
        for (int i = 0; i <= max; i++) {
            int count = 0;
            for (int j = 0; j < N; j++) {
                if (citations[j] >= i) count++;
            }
            
            if (count >= i) H = i;
        }

        return H;
    }
}