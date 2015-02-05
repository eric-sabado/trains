package uk.co.tyche.codeexam;

import static uk.co.tyche.codeexam.util.CommandStringParser.toEdges;
import static uk.co.tyche.codeexam.util.CommandStringParser.toNodes;

import java.util.List;
import java.util.Scanner;

import uk.co.tyche.codeexam.exception.FormatException;
import uk.co.tyche.codeexam.exception.MissingRouteException;
import uk.co.tyche.codeexam.model.Digraph;
import uk.co.tyche.codeexam.model.Edge;
import uk.co.tyche.codeexam.model.Node;

public class Runner {

	private static Digraph digraph;
	private static List<Node> nodeQuery;
	private static Scanner scanner;

	static {
		digraph = new Digraph();
		scanner = new Scanner(System.in);
	}

	public static void main(String[] args) {
		captureDigraphCommand();
		captureNodeQueryCommand();
	}

	private static void captureDigraphCommand() {
		System.out.println("Direct Graph Definition: ");

		try {
			buildDigraph();
		} catch (FormatException e) {
			captureDigraphCommand();
		}
	}

	private static void captureNodeQueryCommand() {
		System.out.println("Route? ");

		buildNodeQuery();
		computePath();
		captureNodeQueryCommand();
	}

	private static void buildNodeQuery() {
		nodeQuery = toNodes(scanner.next());
	}

	private static void computePath() {
		try {
			System.out.println("Distance: " + digraph.computeWeight(nodeQuery));
		} catch (MissingRouteException e) {
			System.out.println(e.getMessage());
		}
	}

	private static void buildDigraph() throws FormatException {
		try {
			List<Edge> edges = toEdges(scanner.next());
			digraph.addEdge(edges);
		} catch (FormatException e) {
			throw e;
		}
	}
}
