
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		LinkedList myLinkedList = new LinkedList(4);
//		myLinkedList.printList();
		myLinkedList.append(10);
//		myLinkedList.printList();
		myLinkedList.append(15);
		myLinkedList.printList();
//		myLinkedList.removeEnd();
//		myLinkedList.printList();
		System.out.println("removed = " + myLinkedList.removeEnd().value);
		myLinkedList.printList();
		myLinkedList.prepend(5);
		myLinkedList.printList();
		
//		myLinkedList.printList();
//		myLinkedList.append(23);
//		myLinkedList.printList();
//		myLinkedList.append(33);
//		myLinkedList.printList();
		
//		System.out.println(myLinkedList.getIndex(1).value);
//		System.out.println(myLinkedList.getIndex(1).prev.value);
//		System.out.println(myLinkedList.getIndex(1).next.value);
		
	}

}
