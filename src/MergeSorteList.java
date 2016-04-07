/**
 * Created by lizuyao2010 on 4/6/16.
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class MergeSorteList {
     class ListNode {
         int val;
         ListNode next;
         ListNode(int x) { val = x; }
     }
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dump=new ListNode(0);
        ListNode tail=dump;
        while (l1!=null || l2!=null)
        {
            if (l2==null || l1!=null && l1.val<l2.val) {
                tail.next = l1;
                l1=l1.next;
            }
            else {
                tail.next = l2;
                l2=l2.next;
            }
            tail=tail.next;
        }
        return dump.next;
    }
}