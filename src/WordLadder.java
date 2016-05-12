import java.util.*;

/**
 * Created by lizuyao2010 on 4/14/16.
 */
public class WordLadder {
    public List<List<String>> findLadders(String start, String end, Set<String> dict) {
        List<List<String>> results= new ArrayList<>();
        if (dict.size() == 0)
            return results;
        int min=Integer.MAX_VALUE;
        Queue<String> queue= new ArrayDeque<>();
        queue.add(start);
        Map<String,List<String>> map = new HashMap<>();
        Map<String,Integer> ladder = new HashMap<>();
        for (String string:dict)
            ladder.put(string, Integer.MAX_VALUE);
        ladder.put(start, 0);
        dict.add(end);
        while (!queue.isEmpty()) {
            String word = queue.poll();
            int step = ladder.get(word)+1;//'step' indicates how many steps are needed to travel to one word.
            if (step>min) break;
            min = getMin(end, min, queue, map, ladder, word, step);
        }
        backTrace(end,start,new ArrayList<>(),results,map);
        return results;
    }

    private int getMin(String end, int min, Queue<String> queue, Map<String, List<String>> map, Map<String, Integer> ladder, String word, int step) {
        for (int i = 0; i < word.length(); i++){
            StringBuilder builder = new StringBuilder(word);
            for (char ch='a';  ch <= 'z'; ch++){
                builder.setCharAt(i,ch);
                String new_word=builder.toString();
                if (ladder.containsKey(new_word)) {
                    if (step>ladder.get(new_word))//Check if it is the shortest path to one word.
                        continue;
                    else if (step<ladder.get(new_word)){
                        queue.add(new_word);
                        ladder.put(new_word, step);
                    }
                    else;// It is a KEY line. If one word already appeared in one ladder,
                    // Do not insert the same word inside the queue twice. Otherwise it gets TLE.
                    if(!map.containsKey(new_word))
                        map.put(new_word,new LinkedList<>());
                    map.get(new_word).add(word);
                    if (new_word.equals(end))
                        min=step;
                }
            }
        }
        return min;
    }

    private void backTrace(String word,String start,List<String> list,List<List<String>> results,Map<String,List<String>> map){
        if (word.equals(start)){
            list.add(0,start);
            results.add(new ArrayList<String>(list));
            list.remove(0);
            return;
        }
        list.add(0,word);
        if (map.get(word)!=null)
            for (String s:map.get(word))
                backTrace(s,start,list,results,map);
        list.remove(0);
    }
}