class Solution {
    public String solution(String number, int k) {
        StringBuilder builder = new StringBuilder();
        int lenOfNumber = number.length();
        int lenOfResult = lenOfNumber - k;
        
        char[] array = number.toCharArray();
        int current = 0;
        for (int i = 0; i < lenOfResult; i++) {
            int max = array[current] - '0';            
            for (int j = current; j <= lenOfNumber - (lenOfResult - i); j++) {
                int compare = array[j] - '0';
                if (max < compare) {
                    max = array[j] - '0';
                    current = j;
                }
                
                if (max == '9') break;
            }
            
            builder.append(array[current]);
            current += 1; 
        }
        
        String answer = builder.toString();
        return answer;
    }
}