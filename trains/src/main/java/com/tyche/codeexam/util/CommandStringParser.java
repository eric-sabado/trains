package com.tyche.codeexam.util;

import static org.apache.commons.lang3.StringUtils.trim;
import static org.apache.commons.lang3.StringUtils.deleteWhitespace;
import static org.apache.commons.lang3.math.NumberUtils.toFloat;

import java.util.ArrayList;
import java.util.List;

import com.tyche.codeexam.model.Edge;
import com.tyche.codeexam.model.Node;

/**
 * 
 * @author Eric
 * This parser is based on the simple parameter
 * requirements stated in the code exam.
 * 
 * It is assumed that cities(nodes) are named using
 * single characters, and paths(edges) are named using
 * the head node and tail node; weight is the distance
 * of the path.
 */
public class CommandStringParser {

	private static final int MIN_PARAM_SIZE = 2;
	private static final String NODE_COMMAND_DELIMETER = "";
	private static final String DIGRAPH_DEFINITION_DELIMITER = ",";

	public static List<Edge> toEdges(String string) {
		List<Edge> edges = new ArrayList<Edge>();

		String[] subStrings = deleteWhitespace(string).split(DIGRAPH_DEFINITION_DELIMITER);
		for (String subString : subStrings) {
			if(subString.length() > MIN_PARAM_SIZE ) {
				String headStr = subString.substring(0, 1);
				String tailStr = subString.substring(1, 2);
				String weightStr = subString.substring(2);
	
				Node head = new Node(trim(headStr));
				Node tail = new Node(trim(tailStr));
				Float weight = toFloat(weightStr);
	
				edges.add(new Edge(head, tail, weight));
			}
		}

		return edges;
	}

	public static List<Node> toNodes(String nodeString) {
		List<Node> nodes = new ArrayList<Node>();

		String[] nodeNames = nodeString.split(NODE_COMMAND_DELIMETER);
		for (String nodeName : nodeNames) {
			nodes.add(new Node(nodeName));
		}

		return nodes;
	}

}
