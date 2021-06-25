package leetcode;

public class Solution86 {
    //给一个链表的头节点head和一个特定值小，请你对链表进行分隔，使得所有小于x的节点出现在大于或等于x的节点之前
    public ListNode partition(ListNode head, int x){
    //方法一模拟
    //就是维护两个链表small和large即可，
        ListNode small = new ListNode(0);
        ListNode smallHead = small;
        ListNode large = new ListNode(0);
        ListNode largeHead = large;
        while(head!=null){
            if(head.val<x){
                small.next = head;
                small = small.next;
            }else{
                large.next = head;
                large = large.next;
            }
            large = large.next;
        }
        large.next = null;
        small.next = largeHead.next;
        return smallHead.next;
    }
}
