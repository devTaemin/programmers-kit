import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;

class Solution {
    public HashMap<String, Integer> genreTimes = new HashMap<>();
    public HashMap<String, ArrayList<Integer>> genreMusic = new HashMap<>();
    public int[] musicTimes = new int[10000];
    
    public int[] solution(String[] genres, int[] plays) {
        int[] answer;
        int id = 0;
        int len = genres.length;
        
        for (int i = 0; i < len; i++) {
            String genre = genres[i];
            int play = plays[i];
            
            // genreTimes
            if (genreTimes.containsKey(genre)) {
                genreTimes.put(genre, genreTimes.get(genre) + play);
            }
            else {
                genreTimes.put(genre, play);
            }
            
            // genreMusic
            if (genreMusic.containsKey(genre)) {
                ArrayList<Integer> arr = genreMusic.get(genre);
                arr.add(id);
                genreMusic.put(genre, arr);
            }
            else {
                ArrayList<Integer> arr = new ArrayList<>();
                arr.add(id);
                genreMusic.put(genre, arr);
            }
            
            // musicTimes
            musicTimes[i] = play;
            
            // NextId
            id++;
        }
        
        ArrayList<String> genreList = new ArrayList<>();
        for (String key : genreTimes.keySet()) {
            genreList.add(key);
        }
        
        Collections.sort(genreList, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return genreTimes.get(o2) - genreTimes.get(o1);
            }
        });
        
        
        for (String key : genreMusic.keySet()) {
            ArrayList<Integer> arr = genreMusic.get(key);
            
            Collections.sort(arr, new Comparator<Integer>() {
                @Override
                public int compare(Integer i1, Integer i2) {
                    return musicTimes[i2] - musicTimes[i1];
                }
            });
            
            genreMusic.put(key, arr);
        }
        
        ArrayList<Integer> result = new ArrayList<>();
        for (String g : genreList) {
            ArrayList<Integer> arr = genreMusic.get(g);
            int size = arr.size();
            
            for (int j = 0; j < size && j < 2; j++) {
                result.add(arr.get(j));
            }
        }
        
        Iterator<Integer> iter = result.iterator();
        answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = iter.next();
        }
        
        return answer;
    }
}