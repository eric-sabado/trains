package com.tyche.codeexam.model;

public class Edge {
	private final Node head;
	private final Node tail;
	private final Float weight;

	public Edge(Node head, Node tail, Float weight) {
		this.head = head;
		this.tail = tail;
		this.weight = weight;
	}

	public Float getWeight() {
		return weight;
	}

	public Node getHead() {
		return head;
	}

	public Node getTail() {
		return tail;
	}

	public String getName() {
		return new StringBuilder()
				.append(head.getName())
				.append(tail.getName())
				.toString();
	}
}
