import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by lizuyao2010 on 3/17/16.
 */
public class FirstNonRepeat {

    public static char firstNonRepeat(String s)
    {
        Map<Character,Integer> m=new LinkedHashMap<>();
        for (char c: s.toCharArray())
        {
            if (!m.containsKey(c))
            {
                m.put(c,1);
            }
            else
            {
                m.put(c,m.get(c)+1);
            }
        }
        for (char c: m.keySet())
        {
            if (m.get(c)==1)
                return c;
        }
        return ' ';
    }
    public static void main(String[] args)
    {
        char c=firstNonRepeat("daabbc");
        System.out.println(c);
    }
}
