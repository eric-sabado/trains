package uk.co.tyche.codeexam.model;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import uk.co.tyche.codeexam.exception.MissingRouteException;

public class Digraph {
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

	public void addEdge(List<Edge> edges) {
		for (Edge edge : edges) {
			this.addEdge(edge);
		}
	}

	public Float computeWeight(List<Node> orderedNodes) throws MissingRouteException {
		Float totalWeight = Float.valueOf(0);
		for (int i = 0; i < orderedNodes.size() - 1; i++) {
			totalWeight += extractEdge(orderedNodes, i).getWeight();
		}
		
		return totalWeight;
	}

	private Edge extractEdge(List<Node> orderedNodes, int i) throws MissingRouteException {
		Node currentNode = orderedNodes.get(i);
		Node adjacentNode = orderedNodes.get(i + 1); 

		String edgeKey = Edge.withNodes(currentNode, adjacentNode).getName();
		Edge edge = edges.get(edgeKey);

		if (null == edge) {
			throw new MissingRouteException();
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
