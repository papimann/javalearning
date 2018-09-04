package com.kapil.practice.linkedLists;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicateLinkedList {

	public static void main(String[] args) {
		LinkedList<Integer> l = new LinkedList<>();
		l.printList();
		l.add(5);
		l.add(4);
		l.add(3);
		l.add(3);
		l.add(2);
		l.printList();
		System.out.println("After Removing Duplicates");
		removeDuplicatesWithBuffer(l);
		removeDuplicatesWOBuffer(l);
	}

	private static void removeDuplicatesWithBuffer(LinkedList<Integer> l) {
		Set<Integer> unique = new HashSet<>();
		Node<Integer> prev = null;
		Node<Integer> node = l.head;
		while (node != null) {
			if (unique.contains(node.getData())) {
				prev.setNext(node.getNext());
			} else {
				unique.add(node.getData());
				prev = node;
			}
			node = node.getNext();
		}
		l.printList();
	}

	private static void removeDuplicatesWOBuffer(LinkedList<Integer> l) {
		if (l.head == null) {
			return;
		}
		Node<Integer> node = l.head;
		/* Pick elements one by one */
		while (node != null && node.getNext() != null) {
			Node<Integer> node1 = node;
			/*
			 * Compare the picked element with rest of the elements
			 */
			while (node1.getNext() != null) {
				/* If duplicate then delete it */
				if (node.getData() == node1.getNext().getData()) {
					/* sequence of steps is important here */
					Node<Integer> temp = node1.getNext();
					node.setNext(temp.getNext());
				} else {
					node1 = node1.getNext();
				}
			}
			node = node.getNext();
		}
		l.printList();
	}

}
