package com.kapil.java8.main;

public class KapilLinkedList {

	private Node head;

	public KapilLinkedList() {
		head = new Node(null);
	}

	public void add(Object data) {
		Node node = new Node(data);
		Node current = head;
		while (current.getNext() != null) {
			current = current.getNext();
		}
		current.setNext(node);
	}

	public void add(Object data, int index) {
		Node node = new Node(data);
		Node current = head;
		if (current != null) {
			for (int i = 0; i < index; i++) {
				if (current.getNext() == null) {
					break;
				}
				current = current.getNext();
			}
		}
		node.setNext(current.getNext());
		current.setNext(node);
	}

	public Object get(int index) {
		if (index < 0) {
			return null;
		}
		Node current = null;
		if (head != null) {
			current = head.getNext();
			for (int i = 0; i < index; i++) {
				if (current.getNext() == null) {
					return null;
				}
				current = current.getNext();
			}
			return current.getData();
		}
		return current;
	}

	public boolean remove(int index) {
		Node current = head;
		if (index < 1 || current == null) {
			return false;
		}

		for (int i = 0; i < index; i++) {
			if (current.getNext() == null) {
				return false;
			}
			current = current.getNext();
		}
		current.setNext(current.getNext().getNext());
		return true;

	}

	void printNthFromEnd(int n) {
		Node fast = head;
		Node slow = head;
		int i = 1;
		while (fast.getNext() != null) {
			i++;
			fast = fast.getNext();
			if (i > n) {
				slow = slow.getNext();
			}
		}
		System.out.println(slow.getData());
	}

	void printNth(int n) {
		Node fast = head;
		int i = 0;
		while (fast.getNext() != null) {
			if (i == n) {
				break;
			}
			i++;
			fast = fast.getNext();

		}
		System.out.println(fast.getData());
	}

	public String toString() {
		String output = "";

		if (head != null) {
			Node crunchifyCurrent = head.getNext();
			while (crunchifyCurrent != null) {
				output += "[" + crunchifyCurrent.getData().toString() + "]";
				crunchifyCurrent = crunchifyCurrent.getNext();
			}

		}
		return output;
	}

	private class Node {

		private Node next;

		private Object data;

		public Node(Object data) {
			next = null;
			this.data = data;
		}

		// these methods should be self-explanatory
		public Object getData() {
			return data;
		}

		public Node getNext() {
			return next;
		}

		public void setNext(Node next) {
			this.next = next;
		}
	}

	public static void main(String[] args) {
		KapilLinkedList lst = new KapilLinkedList();
		lst.add("1");
		lst.add("2");
		lst.add("3");
		lst.add("4");
		lst.add("5");

		/*
		 * Please note that primitive values can not be added into LinkedList directly.
		 * They must be converted to their corresponding wrapper class.
		 */

		System.out.println("Print: lst: \t\t" + lst);
		System.out.print("Printing 2nd Element : ");
		lst.printNth(2);
		/*
		 * System.out.print("Printing 2nd Element from Last : ");
		 * lst.printNthFromEnd(2); System.out.println(".get(3): \t\t\t\t" + lst.get(3) +
		 * " (get element at index:3 - list starts from 0)");
		 * System.out.println(".remove(2): \t\t\t\t" + lst.remove(2) +
		 * " (element removed)"); System.out.println(".get(3): \t\t\t\t" + lst.get(3) +
		 * " (get element at index:3 - list starts from 0)");
		 * System.out.println("Print again: lst: \t" + lst);
		 */
	}
}
