package com.kapil.practice.linkedLists;

public class RemoveMiddleElement {

	public static void main(String[] args) {
		LinkedList<Integer> l = new LinkedList<>();
		l.printList();
		l.add(1);
		l.add(2);
		l.add(3);
		l.add(4);
		l.add(5);
		l.add(6);
		l.printList();
		removeMiddleElement(l);
	}

	private static void removeMiddleElement(LinkedList<Integer> l) {
		Node<Integer> node = l.head;
		Node<Integer> node1 = node.getNext();
//		Node<Integer> prev = null;
		while(node1.getNext() != null) {
			node1 = node1.getNext().getNext();
//		/	prev = node;
			node = node.getNext();
		}
		System.out.println("Middle Element is "+node.getData());
		node.getPrev().setNext(node.getNext());
		l.printList();
	}

}
