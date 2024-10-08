import java.util.HashSet;
import java.util.Iterator;
public class LinkedList {

	private Node head;
	private Node tail;
	private int length;
	
	class Node{
		int value;
		Node next;
		Node prev;
		
		Node(int value){
			this.value = value;
		}
	}
	
	public LinkedList(int value) {
		Node newNode = new Node(value);
		head = newNode;
		tail = newNode;
		length = 1;
		
	}
	
	public void append(int value) {
		Node newNode = new Node(value);
		if(length == 0) {
			head = newNode;
			tail = newNode;
		}else{
			tail.next = newNode;
			newNode.prev = tail;
			tail = newNode;
		}
		length++;
	}
	
	public Node removeEnd(){
		if (length == 0) return null;
		
		Node previous = getHead();
		Node temp = getHead();
		while(temp.next != null) {
			previous = temp;
			temp = temp.next;
		}
		tail = previous;
		tail.next = null;
		length--;
		if(length == 0) {
			head = null;
			tail = null;
		}
		return temp;
	}
	
	public Node removeFirst() {
		if (length == 0) {return null;}
		Node temp = head;
		head = head.next;
		temp.next = null;
		length--;
		if (length == 0) {
			tail = null;
		}
		return temp;
	}
	
	public void prepend(int value) {
		Node newNode = new Node(value);	
		if (length == 0) {
			head = newNode;
			tail = newNode;
			head.next = null;
		}else {
			newNode.next = head;
			head = newNode;
		}
		length++;
	}

	public Node getHead() {
		return head;
	}

	public Node getTail() {
		return tail;
	}

	public int getLength() {
		return length;
	}
	
	public void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.value + " ");
            current = current.next;
        }
        System.out.println();
    }
	
	public Node getIndex(int index) {
		if(index < 0 || index >= length) {
			return null;
		}
		Node temp = head;
		for(int i = 0; i < index; i++) {
			temp = temp.next;
		}
		
		return temp;
	}
	
	public boolean setValue(int index, int value) {
		Node temp = getIndex(index);
		if(temp != null) {
			temp.value = value;
			return true;
		}
		return false;
	}
	public boolean insert(int index, int value) {
		if(index < 0 || index > length) {return false;}
		if(index == 0) {prepend(value); return true;}
		if(index == length) {append(value); return true;}

		Node newNode = new Node(value);
		Node temp = getIndex(index-1);
		newNode.next = getIndex(index);
		temp.next = newNode;
		length++;
		return true;
	}
	
	public Node remove(int index) {
		if(index < 0 || index >= length) {return null;}
		if(index == 0) {return removeFirst();}
		if(index == length-1) {return removeEnd();}
		Node tempprev = getIndex(index-1);
		Node temp = tempprev.next;
		tempprev.next = temp.next;
		temp.next = null;
		length--;
		
		return temp;
	}
	
	public void reverse() {
		Node temp = head;
		head = tail;
		tail = temp;
		Node after = tail.next;
		Node before = null;
		for(int i = 0; i < length; i++) {
			after = temp.next;
			temp.next = before;
			before = temp;
			temp = after;
			
		}
	}
	
	public Node findMiddleNode (){
	    Node H1 = head;
	    Node H2 = head;
	    if(H1 == null || H2 == null) {return null;}
	    while (H2.next != null){
	    	H1 = H1.next;
	    	H2 = H2.next;
	    	if (H2.next != null) {
	    		H2 = H2.next;
	    	}
	    }
	    return H1;
	}
	
	public boolean hasLoop() {
		Node H1 = head;
	    Node H2 = head;
	    if(H1 == null || H2 == null) {return false;}
	    while (H2.next != null){
	    	H1 = H1.next;
	    	H2 = H2.next;
	    	if (H2.next != null) {
	    		H2 = H2.next;
	    	}
	    	if(H1 == H2) {return true;}
	    	
	    }
	    return false;
		
	}
	
	public Node findKthFromEnd(int k) {
		Node fast = head;
		Node slow = head;
		for(int i = 0; i < k; i++) {
			if(fast.next == null) {
				return null;
			}
			fast = fast.next;
			
		}
		
		while(fast != null) {
			fast = fast.next;
			slow = slow.next;
		}
		return slow;
	}
	
	public void partitionList(int x) {
		if(head == null) {
			return;
		}
		Node dummy1 = new Node(0) ;
		Node prev1 = dummy1;
		
		Node dummy2 = new Node(0);
		Node prev2 = dummy2;
		
		Node current = head;
		
		while(current != null){
				if(current.value < x) {
					prev1.next = current;
					prev1 = current;
					System.out.println(prev1.value);
				}else {
					prev2.next = current;
					prev2 = current;
					System.out.println(prev2.value);
				}
				current = current.next;
		}
		prev2.next = null;
		prev1.next = dummy2.next;
		head = dummy1.next;
	}
	
	public void removeDuplicates() {
		if(head == null) {
			return;
		}
		HashSet<Integer> hash = new HashSet<Integer>();
		Node tempH = head;
		Node current = head;
		Node  prev = head;
		hash.add(current.value);
		
		head = head.next;
		current = head;
		while(current != null) {
			if(hash.contains(current.value)) {
				head = head.next;
				current = current.next;
				prev.next = current;
				length-=1;
			}else {
				head = head.next;
				current = current.next;
				prev = prev.next;
			}
			hash.add(prev.value);
		}
		head = tempH;
	}
	
	public int binaryToDecimal() {
		int num = 0;
		while(head != null) {
			num = (num * 2) + head.value;
			head = head.next;
		}
		return num;
	}
	
	public void reverseBetween(int m, int n) {
		if(head == null) return;
		Node d1 = new Node(0);
		d1.next = head;
		Node prevN = d1;
		
		
		for(int i=0; i < m; i++) {
			prevN = prevN.next;
		}
		System.out.println(prevN.value);
		Node current = prevN.next;
		System.out.println(current.value);
		
		for(int i=0; i < n-m; i ++){
			Node ntm = current.next;
			current.next = ntm.next;
			System.out.println(current.next.value + " : current.next");
			ntm.next = prevN.next;
			prevN.next = ntm;
			System.out.println(ntm.value + " : ntm");
		}
		head = d1.next;
	}
	

}

