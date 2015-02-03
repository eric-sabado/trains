package com.tyche.codeexam.model;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class Digraph {
	private Set<Node> nodes;
	private Set<Edge> edges;

	Digraph() {
		this.nodes = new HashSet<>();
		this.edges = new HashSet<>();
	}

	public void addEdge(Edge edge) {
		this.edges.add(edge);
		addNodes(edge);
	}

	private void addNodes(Edge edge) {
		Node head = edge.getHead();
		Node tail = edge.getTail();

		if (null != head && null != tail) {
			this.nodes.add(head);
			this.nodes.add(tail);
		}
	}

	public void addEdge(Collection<Edge> edges) {
		this.edges.addAll(edges);
	}

	public Set<Node> getNodes() {
		return nodes;
	}

	public Set<Edge> getEdges() {
		return edges;
	}
}
