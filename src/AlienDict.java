import java.util.*;

/**
 * Created by lizuyao2010 on 3/26/16.
 */
public class AlienDict {
    public String alienOrder(String[] words) {
        Map<Character,Set<Character>> graph=new HashMap<>();
        Map<Character,Integer> inDegrees=new HashMap<>();
        for(String s: words){
            for(char c: s.toCharArray()){
                inDegrees.put(c,0);
            }
        }
        for (int i=1; i<words.length; i++)
        {
            String word1=words[i-1];
            String word2=words[i];
            int min=Math.min(word1.length(),word2.length());
            for(int j=0;j<min;j++)
            {
                char c1=word1.charAt(j);
                char c2=word2.charAt(j);
                if (c1!=c2)
                {
                    if (!graph.containsKey(c1))
                        graph.put(c1,new HashSet<>());
                    if (!graph.get(c1).contains(c2))
                        inDegrees.put(c2,inDegrees.get(c2)+1);
                    graph.get(c1).add(c2);
                    break;
                }
            }
        }
        Queue<Character> q=new LinkedList<>();
        boolean[] visited=new boolean[256];
        for (char c:inDegrees.keySet())
        {
            if (inDegrees.get(c)==0) {
                q.add(c);
            }
        }
        StringBuilder sb=new StringBuilder();
        while (!q.isEmpty())
        {
            char cu=q.poll();
            sb.append(cu);
            if (graph.containsKey(cu))
                for (char nei:graph.get(cu))
                {
                    inDegrees.put(nei,inDegrees.get(nei)-1);
                    if(inDegrees.get(nei)==0)
                    {
                        q.add(nei);
                    }
                }
        }
        if(sb.length()!=inDegrees.size()) return "";
        return sb.toString();
    }

}
