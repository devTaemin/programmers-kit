import java.util.ArrayList;
import java.util.HashMap;

class Solution {
    public HashMap<String, ArrayList<String>> Map = new HashMap<String, ArrayList<String>>();
    
    public int solution(String[][] clothes) {
        int answer = 1;
        
        for (String[] set : clothes) {
            String cloth = set[0];
            String type = set[1];
            
            if (Map.containsKey(type)) { 
                ArrayList<String> arr = Map.get(type);
                arr.add(cloth);
                Map.put(type, arr);
            }
            else {
                ArrayList<String> arr = new ArrayList<>();
                arr.add(cloth);
                Map.put(type, arr);
            }
        }

        for (String key : Map.keySet()) {
            int count = Map.get(key).size();
            answer *= (count + 1);
        }
        
        answer -= 1;
        return answer;
    }
}