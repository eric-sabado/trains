package com.tyche.codeexam.model;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Digraph {
	public static final String NO_SUCH_ROUTE = "NO SUCH ROUTE";
	
	private Set<Node> nodes;
	private Map<String, Edge> edges;

	public Digraph() {
		this.nodes = new HashSet<Node>();
		this.edges = new HashMap<String, Edge>();
	}

	public void addEdge(Edge edge) {
		this.edges.put(edge.getName(), edge);
		registerNodes(edge);
	}

	public Float computeWeight(List<Edge> edgeQueries) throws Exception {
		Float totalWeight = Float.valueOf(0);

		for (Edge edgeQuery : edgeQueries) {
			Edge edge = edges.get(edgeQuery.getName());
			if (null == edge) {
				throw new Exception(NO_SUCH_ROUTE);
			}

			totalWeight += edge.getWeight();
		}
		return totalWeight;
	}

	private void registerNodes(Edge edge) {
		Node head = edge.getHead();
		Node tail = edge.getTail();

		if (null != head && null != tail) {
			this.nodes.add(head);
			this.nodes.add(tail);
		}
	}

	public Set<Node> getNodes() {
		return nodes;
	}

	public Map<String, Edge> getEdges() {
		return edges;
	}
}
