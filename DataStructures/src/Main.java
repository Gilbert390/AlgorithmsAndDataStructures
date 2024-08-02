
public class Main {

		// TODO Auto-generated method stub

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
//		myLinkedList.removeFirst();
//		myLinkedList.printList();
//		System.out.println(myLinkedList.removeFirst().value);
//		myLinkedList.printList();
		System.out.println(myLinkedList.getIndex(1).value);
		myLinkedList.setValue(0, 10);
		myLinkedList.printList();
		myLinkedList.insert(3, 7);
		myLinkedList.printList();
		myLinkedList.insert(4, 8);
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
