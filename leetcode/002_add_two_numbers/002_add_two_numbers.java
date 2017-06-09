public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode init, tail, head;
        head = tail = init = new ListNode(l1.val + l2.val);
        int carry = 0;
        if(head.val >= 10){
            carry = 1;
            head.val %= 10;
        }
        while(l1.next != null || l2.next != null){
            if (l1.next != null){
                l1 = l1.next;
            } else {
                l1.val = 0;
            }
            if (l2.next != null){
                l2 = l2.next;
            } else {
                l2.val = 0;
            }
            head = new ListNode(l1.val + l2.val + carry);
            tail.next = head;
            tail = head;
            carry = 0;
            if(head.val >= 10){
                carry = 1;
                head.val %= 10;
            }
        }
        if(carry >= 1){
            head = new ListNode(carry);
            tail.next = head;
            tail = head;
        }
        return init;
    }
}