package com.tyche.codeexam;

import java.util.ArrayList;
import java.util.Scanner;

import com.tyche.codeexam.model.Digraph;
import com.tyche.codeexam.model.Edge;
import com.tyche.codeexam.model.Node;

public class Runner {

	final static Digraph digraph;
	final static ArrayList<Edge> edgeQuery;

	static {
		digraph = new Digraph();
		edgeQuery = new ArrayList<Edge>();
	}

	public static void main(String[] args) {
		System.out.println("Path Query:\n");
		
		Scanner sc = new Scanner(System.in);		
		String query = sc.next();
		
		buildDigrpah();
		buildEdgeQuery(query);
		computePath();
		
		sc.close();
	}

	private static void buildEdgeQuery(String arg) {
		String[] nodeName = arg.split("");

		for (int i = 0; i < nodeName.length; i++) {
			if (i + 1 < nodeName.length) {
				edgeQuery.add(new Edge(new Node(nodeName[i]), new Node(
						nodeName[i + 1]), null));
			}
		}
	}

	private static void buildDigrpah() {
		digraph.addEdge(new Edge(new Node("A"), new Node("B"), Float.valueOf(5)));
		digraph.addEdge(new Edge(new Node("B"), new Node("C"), Float.valueOf(4)));
		digraph.addEdge(new Edge(new Node("C"), new Node("D"), Float.valueOf(8)));
		digraph.addEdge(new Edge(new Node("D"), new Node("C"), Float.valueOf(8)));
		digraph.addEdge(new Edge(new Node("D"), new Node("E"), Float.valueOf(6)));
		digraph.addEdge(new Edge(new Node("A"), new Node("D"), Float.valueOf(5)));
		digraph.addEdge(new Edge(new Node("C"), new Node("E"), Float.valueOf(2)));
		digraph.addEdge(new Edge(new Node("E"), new Node("B"), Float.valueOf(3)));
		digraph.addEdge(new Edge(new Node("A"), new Node("E"), Float.valueOf(7)));

	}

	private static void computePath() {

		try {
			System.out.println(digraph.computeWeight(edgeQuery));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
