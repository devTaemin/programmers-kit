import java.util.Arrays;

class Solution {
    public int solution(int[] people, int limit) {
        Arrays.sort(people);
        int numOfPeople = people.length;
        int numOfBoat = 0;
        int idx = 0;
        
        for (int i = numOfPeople - 1; i >= idx; i--) {
            numOfBoat++;
            if (people[i] + people[idx] <= limit) idx++;
        }
        
        return numOfBoat;
    }
}