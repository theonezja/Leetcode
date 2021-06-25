package leetcode;
class ListNode{
    public int val;
    public ListNode next;
    ListNode(){};
    public ListNode(int val){
        this.val = val;
    }
    ListNode(int val, ListNode next){
        this.val = val;
        this.next = next;
    }
}

public class Solution83 {
    public ListNode deleteDuplicates(ListNode head){
        if(head==null) return head;
        ListNode cur = head;
        while(cur.next!=null){
            if(cur.val==cur.next.val){
                cur.next = cur.next.next;
            }else{
                cur = cur.next;
            }
        }
        return head;
    }
}
