import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Solution {
    public String solution(int[] numbers) {
        ArrayList<String> array = new ArrayList<>();
        for (int number : numbers) {
            array.add(String.valueOf(number));
        }
        
        Collections.sort(array, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2 + o1).compareTo(o1 + o2);
            }
        });
        
        String answer = "";
        if (array.get(0).equals("0")) answer = "0";
        else {
            for (String elem : array) {
                answer += elem;
            }
        }
        
        return answer;
    }
}