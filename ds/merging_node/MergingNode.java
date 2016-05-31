package ds;
import java.util.Scanner;

public class MergingNode {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Node headA = new Node(10);
        headA.next = new Node(20);
        headA.next.next = new Node(30);
        headA.next.next.next = new Node(40);
        
        Node headB = new Node(1);
        headB.next = new Node(2);
        headB.next.next = headA.next.next;
        System.out.println(FindMergeNode(headA, headB));
    }
    
    static void merge(int arr[], int first, int last){
    }
    


    static void printLL(Node head) {
    	while(head != null){
    		System.out.printf("%d --> ",head.data);
    		head =  head.next;
    	}
    	System.out.printf("%s\n",head);
    }
    
    static int FindMergeNode(Node headA, Node headB) {
    	printLL(headA);
    	printLL(headB);
        Node pPtr = headA;
        Node qPtr = headB;
        
        while(pPtr != null){
            while(qPtr != null){
            	System.out.println(pPtr.next + " , " + qPtr.next);
                if(pPtr.next == qPtr.next){
                    //merge point found
                    Node mergeNode = pPtr.next;
                    return mergeNode.data;
                }
                qPtr = qPtr.next;
            }
            pPtr = pPtr.next;
            qPtr = headB;
        }

        return -1;
    }
    
   static Node SortedInsert(Node head,int data) {
    	  Node newNode = new Node();
    	    newNode.data = data;
    	    
    	    if(head == null){
    	        head = newNode;
    	        return head;
    	    }
    	    
    	    Node pPtr = head;
    	    
    	    if(pPtr.next == null){
    	        if(pPtr.data < newNode.data){
    	            //Insert after this
    	            newNode.prev = pPtr;
    	            newNode.next = null;
    	            pPtr.next = newNode;
    	        }else{
    	            // Insert before this
    	            newNode.prev = null;
    	            newNode.next = pPtr;
    	            pPtr.prev = newNode;
    	        }
    	        return head;
    	    }
    	    
    	    while( pPtr.data < newNode.data && pPtr.next != null){
    	        pPtr = pPtr.next;
    	    }
    	    if(pPtr.next != null && pPtr.data > newNode.data){
    	        //Insert before pPtr now
    	        newNode.prev = pPtr.prev;
    	        newNode.next = pPtr;
    	        pPtr.prev.next = newNode;
    	        pPtr.prev = newNode;
    	        return head;
    	    }
    	    //new Node need to be inserted at last
    	    newNode.next = null;
    	    newNode.prev = pPtr;
    	    pPtr.next = newNode;
    	    
    	    return head;
    	}

}

class Node{
	int data;
	Node next;
	Node prev;
	
	public Node(){
		this.data = 0;
		this.next = null;
		this.prev = null;
	}
	public Node(int data){
		this.data = data;
	}
}
