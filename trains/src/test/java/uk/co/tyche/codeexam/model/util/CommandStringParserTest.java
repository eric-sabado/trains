package uk.co.tyche.codeexam.model.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static uk.co.tyche.codeexam.util.CommandStringParser.toEdges;
import static uk.co.tyche.codeexam.util.CommandStringParser.toNodes;

import java.util.List;

import org.junit.Test;

import uk.co.tyche.codeexam.exception.FormatException;
import uk.co.tyche.codeexam.model.Edge;
import uk.co.tyche.codeexam.model.Node;

public class CommandStringParserTest {

	@Test
	public void testToEdges() throws FormatException {
		List<Edge> edges = toEdges("AB1,BC2,CD3");
		assertEquals(3, edges.size());
		assertTrue(edges.contains(new Edge(new Node("A"), new Node("B"), Float
				.valueOf(1))));
		assertTrue(edges.contains(new Edge(new Node("B"), new Node("C"), Float
				.valueOf(2))));
		assertTrue(edges.contains(new Edge(new Node("C"), new Node("D"), Float
				.valueOf(3))));
	}

	@Test
	public void testToEdgesWithSpaces() throws FormatException {
		List<Edge> edges = toEdges("A B 1, BC2");
		assertEquals(2, edges.size());
		assertTrue(edges.contains(new Edge(new Node("A"), new Node("B"), Float
				.valueOf(1))));
		assertTrue(edges.contains(new Edge(new Node("B"), new Node("C"), Float
				.valueOf(2))));
	}

	@Test(expected = uk.co.tyche.codeexam.exception.FormatException.class)
	public void testToEdgesIncompleteInput() throws FormatException {
		toEdges("A");
	}

	@Test(expected = uk.co.tyche.codeexam.exception.FormatException.class)
	public void testToEdgesIllegalArgumetFormat() throws FormatException {
		toEdges("ABC");
	}

	@Test(expected = uk.co.tyche.codeexam.exception.FormatException.class)
	public void testToEdgesIllegalArgumetFormat1() throws FormatException {
		toEdges("1");
	}

	@Test(expected = uk.co.tyche.codeexam.exception.FormatException.class)
	public void testToEdgesIllegalArgumetFormat2() throws FormatException {
		toEdges("");
	}

	@Test(expected = uk.co.tyche.codeexam.exception.FormatException.class)
	public void testToEdgesIllegalArgumetFormat3() throws FormatException {
		toEdges("AB,BC2");
	}

	@Test
	public void toNodesString() {
		List<Node> nodes = toNodes("AB");
		assertEquals(2, nodes.size());
		assertTrue(nodes.contains(new Node("A")));
		assertTrue(nodes.contains(new Node("B")));
	}

	@Test
	public void toNodesChar() {
		List<Node> nodes = toNodes("A");
		assertEquals(1, nodes.size());
		assertTrue(nodes.contains(new Node("A")));
	}
}
