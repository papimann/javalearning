package com.kapil.practice.linkedLists;

public class LinkedList<E> {

	Node<Integer> head;

	public int getSize() {
		return size;
	}

	private transient int size;

	Node<Integer> get(int index) {
		if (index > size || index < 0) {
			System.out.println("index cannot be more than list size i.e. " + size);
			return null;
		}
		Node<Integer> node = head;
		int i = 0;
		while (node != null) {
			if (i == index) {
				break;
			}
			node = node.getNext();
			i++;
		}
		return node;
	}

	void printList() {
		if (head == null) {
			System.out.println("List is Empty !!");
			return;
		}
		Node<Integer> node = head;
		while (node != null) {
			System.out.println(node.getData());
			node = node.getNext();
		}
	}

	void add(int data) {
		Node<Integer> node = new Node<>(data);
		if (head == null) {
			head = node;
		} else {
			Node<Integer> n = head;
			while (n.getNext() != null) {
				n = n.getNext();
			}
			n.setNext(node);
		}
		size++;
	}

	void addToHead(int data) {
		Node<Integer> node = new Node<>(data);
		if (head == null) {
			head = node;
		} else {
			node.setNext(head.getNext());
			head.setNext(node);
		}
		size++;
	}

	void addAfter(Node<Integer> node, int data) {
		Node<Integer> currentNode = new Node<>(data);
		if (node == null) {
			System.out.println("Node cannot be null");
			return;
		}
		currentNode.setNext(node.getNext());
		node.setNext(currentNode);
		size++;
	}

	void addAtEnd(int data) {
		if (head == null) {
			head = new Node<>(data);
		} else {
			Node<Integer> node = head;
			while (node.getNext() != null) {
				node = node.getNext();
			}
			node.setNext(new Node<>(data));
		}
		size++;
	}

	void addAtFront(int data) {
		Node<Integer> node = new Node<>(data);
		node.setNext(head);
		head = node;
	}

	void addAtIndex(int data, int index) {
		if (head == null) {
			return;
		}
		Node<Integer> node = head;
		while (index > 1) {
			if (node == null) {
				return;
			}
			node = node.getNext();
			index--;
		}
		Node<Integer> nextNode = node.getNext();
		node.setNext(new Node<>(data));
		node.getNext().setNext(nextNode);
	}
}