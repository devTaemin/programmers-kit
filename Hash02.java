import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

class Solution {
    public HashMap<String, Integer> Map = new HashMap<>();
    
    public void checkIn(char[] digits) {
        int len = digits.length;
        String digit = "";
        
        for (int i = 0; i < len; i++) {
            digit += digits[i];
            Map.put(digit, 1);
        }
        
        Map.put(digit, -1);
    }
    
    public boolean solution(String[] phone_book) {
        
        Arrays.sort(phone_book, new Comparator<String>(){
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });
            
        for (String number : phone_book) {
            char[] digits = number.toCharArray();
            String digit = "";
            int len = digits.length;
            
            for (int i = 0; i < len; i++) {
                digit += digits[i];
                
                if (Map.containsKey(digit)) {
                    if (Map.get(digit) == -1) return false;
                    else continue;
                }
                else { 
                    checkIn(digits);
                    break;
                }
            }
        }
        
        return true;
    }
}