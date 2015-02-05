package uk.co.tyche.codeexam.model;

public class Edge {
	private final Node head;
	private final Node tail;
	private final Float weight;

	public Edge(Node head, Node tail, Float weight) {
		this.head = head;
		this.tail = tail;
		this.weight = weight;
	}

	public static Edge withNodes(Node head, Node tail) {
		return new Edge(head, tail, null);
	}

	public Node getHead() {
		return head;
	}

	public Node getTail() {
		return tail;
	}

	public Float getWeight() {
		if (null == this.weight) {
			return Float.valueOf(0);
		}
		return weight;
	}

	public String getName() {
		return new StringBuilder().append(head.getName())
				.append(tail.getName()).toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((head == null) ? 0 : head.hashCode());
		result = prime * result + ((tail == null) ? 0 : tail.hashCode());
		result = prime * result + ((weight == null) ? 0 : weight.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Edge other = (Edge) obj;
		if (head == null) {
			if (other.head != null)
				return false;
		} else if (!head.equals(other.head))
			return false;
		if (tail == null) {
			if (other.tail != null)
				return false;
		} else if (!tail.equals(other.tail))
			return false;
		if (weight == null) {
			if (other.weight != null)
				return false;
		} else if (!weight.equals(other.weight))
			return false;
		return true;
	}
}
