package com.kapil.practice.linkedLists;

public class NthToLastElement {

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
		findNthToLastElement(5, l);
	}

	private static void findNthToLastElement(int n, LinkedList<Integer> l) {
		if (n > l.getSize() || n < 0) {
			System.out.println("n cannot be more than list size i.e. " + l.getSize());
			return;
		}
		Node<Integer> node = l.head;
		Node<Integer> slownode = l.head;
		int i = 0;
		while (node != null) {
			node = node.getNext();
			if (i >= n) {
				slownode = slownode.getNext();
			}
			i++;
		}
		System.out.println("Node at n is " + slownode.getData());
	}

}
