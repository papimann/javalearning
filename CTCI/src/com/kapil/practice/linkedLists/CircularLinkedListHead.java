package com.kapil.practice.linkedLists;

public class CircularLinkedListHead {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList<Integer> l = new LinkedList<>();
		l.printList();
		l.add(1);
		l.add(2);
		l.add(3);
		l.add(4);
		l.add(5);
		l.add(6);
		l.printList();
//		l.head.getNext().getNext().getNext().getNext().setNext(l.head.getNext().getNext());
//		System.out.println(node.getData());
		hasLoop(l);
	}

	private static void hasLoop(LinkedList<Integer> l) {

		Node<Integer> node = l.head;
		Node<Integer> fastNode = l.head;
		boolean circular = false;
		while (node != null && fastNode != null && fastNode.getNext() != null) {
			node = node.getNext();
			fastNode = fastNode.getNext().getNext();
			if (node == fastNode) {
				circular = true;
				break;
			}
		}

		if (circular) {
			System.out.println("Circular head is " + node.getData());
		} else {
			System.out.println("List is not circular.");
		}
	}

}
