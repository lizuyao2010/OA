import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by lizuyao2010 on 3/26/16.
 */
public class Vector2D {
    private Iterator<Integer> j;
    private Iterator<List<Integer>> i;
    public Vector2D(List<List<Integer>> vec2d) {
        i=vec2d.iterator();
    }

    public int next() {
        hasNext();
        return j.next();
    }

    public boolean hasNext() {
        while((j==null || !j.hasNext()) && i.hasNext())
        {
            j=i.next().iterator();
        }
        return j!=null && j.hasNext();
    }
    public static void main(String[] args)
    {
        List<Integer> l=new ArrayList<>();
        l.add(1);
        l.add(2);
        Iterator<Integer> i=l.iterator();
        while(i.hasNext())
        {
            System.out.println(i.next());
        }
//        Vector2D v=new Vector2D()
    }
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D i = new Vector2D(vec2d);
 * while (i.hasNext()) v[f()] = i.next();
 */
