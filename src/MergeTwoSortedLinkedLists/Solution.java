package MergeTwoSortedLinkedLists;

import java.io.*;
import java.util.*;

public class Solution {

    static class SinglyLinkedListNode {
        public int data;
        public SinglyLinkedListNode next;

        public SinglyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
        }
    }

    static class SinglyLinkedList {
        public SinglyLinkedListNode head;
        public SinglyLinkedListNode tail;

        public SinglyLinkedList() {
            this.head = null;
            this.tail = null;
        }

        public void insertNode(int nodeData) {
            SinglyLinkedListNode node = new SinglyLinkedListNode(nodeData);

            if (this.head == null) {
                this.head = node;
            } else {
                this.tail.next = node;
            }

            this.tail = node;
        }
    }

    public static void printSinglyLinkedList(SinglyLinkedListNode node, String sep, BufferedWriter bufferedWriter) throws IOException {
        while (node != null) {
            bufferedWriter.write(String.valueOf(node.data));

            node = node.next;

            if (node != null) {
                bufferedWriter.write(sep);
            }
        }
    }

    /*
     * Given pointers to the heads of two sorted linked lists, 
     * merge them into a single, sorted linked list. Either head 
     * pointer may be null meaning that the corresponding list is 
     * empty.
     * 
     * Example
     * 
     * headA refers to 1->3->7->NULL
     * headB refers to 1->2->NULL
     * The new merged list is 1->1->2->3->7->NULL
     * 
     * Function Description
     * 
     * Complete the mergeLists function below.
     * 
     * mergeLists has the following parameters:
     * 
     * SinglyLinkedListNode pointer headA: a reference to the 
     * head of a list
     * SinglyLinkedListNode pointer headB: a reference to the 
     * head of a list
     * 
     * Returns
     * 
     * SinglyLinkedListNode pointer: a reference to the head of 
     * the merged list
     * 
     * Input Format
     * 
     * The first line contains an integer t, the number of test 
     * cases. The format for each test case is as follows:
     * 
     * The first line contains an integer n, the length of the 
     * first linked list. The next n lines contain an integer 
     * each, the elements of the linked list.
     * 
     * The next line contains an integer m, the length of the 
     * second linked list. The next m lines contain an integer 
     * each, the elements of the second linked list.
     * 
     * Constraints
     * 
     * 1 is less than or equal to t which is less than or equal
     * to 10
     * 1 is less than or equal to n and m which are less than or
     * equal to 1000
     * 1 is less than or equal to list[i] which is less than or
     * equal to 1000, where list[i] is the ith element of the 
     * list.
     * 
     * For your reference:
     *
     * SinglyLinkedListNode {
     *     int data;
     *     SinglyLinkedListNode next;
     * }
     *
     */
    static SinglyLinkedListNode mergeLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
        if(head1 == null){
            return head2;
        } else if(head2 == null){
            return head1;
        } else {
            if(head1.data<=head2.data){
                SinglyLinkedListNode head2Tail = head2.next;
                SinglyLinkedListNode current = head1;
                SinglyLinkedListNode previous = null;
                // Find where to insert first node of head2 into head1
                while(current!=null && head2.data>=current.data){
                    previous = current;
                    current = current.next;
                }
                previous.next = head2;
                head2.next = current;
                return mergeLists(head1, head2Tail);
            } else {
                SinglyLinkedListNode head1Tail = head1.next;
                SinglyLinkedListNode current = head2;
                SinglyLinkedListNode previous = null;
                // Find where to insert first node of head1 into head2
                while(current!=null && head1.data>=current.data){
                    previous = current;
                    current = current.next;
                }
                previous.next = head1;
                head1.next = current;
                return mergeLists(head2, head1Tail);
            }
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int tests = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int testsItr = 0; testsItr < tests; testsItr++) {
            SinglyLinkedList llist1 = new SinglyLinkedList();

            int llist1Count = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < llist1Count; i++) {
                int llist1Item = scanner.nextInt();
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                llist1.insertNode(llist1Item);
            }
          
          	SinglyLinkedList llist2 = new SinglyLinkedList();

            int llist2Count = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < llist2Count; i++) {
                int llist2Item = scanner.nextInt();
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                llist2.insertNode(llist2Item);
            }

            SinglyLinkedListNode llist3 = mergeLists(llist1.head, llist2.head);

            printSinglyLinkedList(llist3, " ", bufferedWriter);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
