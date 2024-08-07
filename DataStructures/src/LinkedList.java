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
	
	

}

