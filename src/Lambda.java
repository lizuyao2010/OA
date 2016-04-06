import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by lizuyao2010 on 4/3/16.
 */
public class Lambda {
    static class Node {
        int val;
        char c;
        public Node(int val, char c) {
            this.val=val;
            this.c=c;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "val=" + val +
                    ", c=" + c +
                    '}';
        }
    }
    public static void main(String[] args)
    {
//        PriorityQueue<Node> pq=
        List<Node> l=new ArrayList<>();
        l.add(new Node(10,'c'));
        l.add(new Node(1,'b'));
        Collections.sort(l,(a,b)->(a.val-b.val));
        System.out.print(l);
    }

}
