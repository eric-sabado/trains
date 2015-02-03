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

	public Float computeWeight(List<Node> nodeList) throws Exception {
		Float totalWeight = Float.valueOf(0);

		for (int i = 0; i < nodeList.size()-1; i++) {
			totalWeight += extractEdge(nodeList, i).getWeight();
		}
		return totalWeight;
	}

	private Edge extractEdge(List<Node> nodeList, int i) throws Exception {
		Node currentNode = nodeList.get(i);
		Node adjacentNode = nodeList.get(i+1);
		
		String nodeKey = currentNode.getName().concat(adjacentNode.getName());
		Edge edge = edges.get(nodeKey);
		
		if (null == edge) {
			throw new Exception(NO_SUCH_ROUTE);
		}
		
		return edge;
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
