import java.util.HashMap;
import java.util.Map;

/**
 * Created by lizuyao2010 on 3/26/16.
 */

class ListNode {
    int val;
    int key;
    ListNode prev;
    ListNode next;
    public ListNode(int key,int val) {
        this.val=val;
        this.key=key;
    }
}
public class LRU {
    int cap;
    ListNode head;
    ListNode tail;
    Map<Integer,ListNode> map;
    public LRU(int capacity) {
        cap=capacity;
        map=new HashMap<>();
    }

    public void setHead(ListNode n)
    {
        n.next=head;
        n.prev=null;
        if (head!=null)
            head.prev=n;
        head=n;
        if(tail==null)
            tail=head;
    }
    public void remove(ListNode n)
    {
        if (n.prev!=null)
            n.prev.next=n.next;
        else
            head=n.next;
        if (n.next!=null)
            n.next.prev=n.prev;
        else
            tail=n.prev;
    }
    public int get(int key) {
        if (map.containsKey(key))
        {
            ListNode n=map.get(key);
            remove(n);
            setHead(n);
            return n.val;
        }
        else {
            return -1;
        }
    }

    public void set(int key, int value) {
        if (map.containsKey(key))
        {
            ListNode n=map.get(key);
            n.val=value;
            remove(n);
            setHead(n);
        }
        else {
            if (cap==map.size())
            {
                map.remove(tail.key);
                remove(tail);
            }
            ListNode n=new ListNode(key,value);
            map.put(key,n);
            setHead(n);
        }
    }
}
