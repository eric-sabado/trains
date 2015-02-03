package com.tyche.codeexam;

import static com.tyche.codeexam.util.CommandStringParser.toEdges;
import static com.tyche.codeexam.util.CommandStringParser.toNodes;
import static org.apache.commons.lang3.StringUtils.isEmpty;

import java.util.List;
import java.util.Scanner;

import com.tyche.codeexam.exception.MissingRouteException;
import com.tyche.codeexam.model.Digraph;
import com.tyche.codeexam.model.Node;

public class Runner {

	private static Digraph digraph;
	private static List<Node> nodeQuery;
	private static Scanner scanner;
	private static String digraphString;

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

		digraphString = scanner.next();
		if (isEmpty(digraphString)) {
			captureDigraphCommand();
		} else {
			buildDigraph();
		}
	}

	private static void captureNodeQueryCommand() {
		System.out.println("Route? ");

		buildNodeQuery(scanner.next());
		computePath();
		captureNodeQueryCommand();
	}

	private static void buildNodeQuery(String routeCommandString) {
		nodeQuery = toNodes(routeCommandString);
	}

	private static void computePath() {
		try {
			System.out.println("Distance: " + digraph.computeWeight(nodeQuery));
		} catch (MissingRouteException e) {
			System.out.println(e.getMessage());
		}
	}

	private static void buildDigraph() {
		digraph.addEdge(toEdges(digraphString));
	}
}
