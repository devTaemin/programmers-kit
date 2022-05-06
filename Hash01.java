import java.util.Map;
import java.util.HashMap;

class Solution {
    public HashMap<String, Integer> map = new HashMap<>();
    
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        for (String key : participant) {
            if (map.containsKey(key)) map.put(key, map.get(key) + 1);
            else map.put(key, 1);
        }
        
        for (String key : completion) {
            if (map.get(key) == 1) map.remove(key);
            else map.put(key, map.get(key) - 1);
        }
        
        for (String key : map.keySet()) {
            answer = key;
        }
        
        return answer;
    }
}