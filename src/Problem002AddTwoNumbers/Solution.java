package Problem002AddTwoNumbers;

import java.util.Objects;

public class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        Objects.requireNonNull(l1);
        Objects.requireNonNull(l2);

        ListNode rerNode=null;
        int carryOver=0;


        ListNode iter;
        ListNode adder;
        ListNode curr=null;

        if(l1.next!=null){
            iter=l1;
            adder=l2;

        }else{
            iter=l2;
            adder=l1;
        }


        while (iter!=null){

            int first=iter.val;
            int second=(adder!=null)?adder.val:0;
            if(rerNode==null){
                rerNode=new ListNode((first+second)%10);
                curr=rerNode;
            }else {
                curr.next=new ListNode((first+second+carryOver)%10);
                curr=curr.next;
            }
            carryOver=(first+second+carryOver)>9?1:0;


            if(iter.next!=null){
                iter=iter.next;

                if(adder!=null&&adder.next!=null){
                    adder=adder.next;
                }else adder=null;
            }else if (adder!=null&&adder.next!=null){

                iter=adder.next;
                adder=null;
            }else iter=null;

        }
        if(carryOver==1){
            curr.next=new ListNode(1);
        }

        return rerNode;



    }




    public static void main(String[] args) {
        ListNode listNode=new ListNode(1);
//        listNode.next=new ListNode(4);
 //       listNode.next.next=new ListNode(3);


        ListNode listNode1=new ListNode(9);
        listNode1.next=new ListNode(9);
       // listNode1.next.next=new ListNode(4);


        new Solution().addTwoNumbers(listNode,listNode1);
    }
}
