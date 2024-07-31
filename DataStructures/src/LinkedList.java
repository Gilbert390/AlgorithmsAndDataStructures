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
		temp = temp.next;
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
		if(index < length/2) {
			for(int i = 0; i < index; i++) {
				temp = temp.next;
			}
		}else {
			temp = tail;
			for(int i = length-1; i > index; i--) {
				temp = temp.prev;
			}
		}
		return temp;
	}
	
	

}

