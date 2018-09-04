package com.kapil.practice.linkedLists;

public class Node<E> {

	private E data;

	private Node<E> next;

	private int index;

	private Node<E> prev;

	Node(E data) {
		this.data = data;
		this.next = null;
		this.index = 0;
		this.prev = null;
	}

	public E getData() {
		return data;
	}

	public void setData(E data) {
		this.data = data;
	}

	public Node<E> getNext() {
		return next;
	}

	public void setNext(Node<E> next) {
		this.next = next;
		if (next != null) {
			next.setPrev(this);
		}
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public Node<E> getPrev() {
		return prev;
	}

	private void setPrev(Node<E> prev) {
		this.prev = prev;
	}
}
