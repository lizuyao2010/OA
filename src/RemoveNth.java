/**
 * Created by lizuyao2010 on 4/6/16.
 */
public class RemoveNth {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {val=x;}

    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dump=new ListNode(0);
        dump.next=head;
        ListNode slow=dump;
        ListNode fast=slow;
        for (int i=0;i<n+1;i++)
            fast=fast.next;
        while (fast!=null)
        {
            slow=slow.next;
            fast=fast.next;
        }
        slow.next=slow.next.next;
        return dump.next;
    }
}
