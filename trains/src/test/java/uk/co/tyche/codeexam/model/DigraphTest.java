package uk.co.tyche.codeexam.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import uk.co.tyche.codeexam.exception.MissingRouteException;
import uk.co.tyche.codeexam.model.Digraph;
import uk.co.tyche.codeexam.model.Edge;
import uk.co.tyche.codeexam.model.Node;

public class DigraphTest {

	private static final Node NODE_A = new Node("A");
	private static final Node NODE_B = new Node("B");
	private static final Node NODE_C = new Node("C");
	private static final Node NODE_D = new Node("D");
	private static final Node NODE_E = new Node("E");

	private Digraph digraph;

	private Edge edgeAB5;
	private Edge edgeBC4;
	private Edge edgeCD8;
	private Edge edgeDC8;
	private Edge edgeDE6;
	private Edge edgeAD5;
	private Edge edgeCE2;
	private Edge edgeEB3;
	private Edge edgeAE7;

	@Before
	public void setUp() throws Exception {
		digraph = new Digraph();
		initEdges();
	}

	@After
	public void tearDown() throws Exception {
		digraph = null;
	}

	@Test
	public void addEdge() {
		assertEquals(0, digraph.getNodes().size());
		assertEquals(0, digraph.getEdges().size());

		digraph.addEdge(edgeAB5);
		assertEquals(1, digraph.getEdges().size());
		assertEquals(2, digraph.getNodes().size());
	}

	@Test
	public void addEdgeWithDuplicateEdge() {
		assertEquals(0, digraph.getNodes().size());
		assertEquals(0, digraph.getEdges().size());

		digraph.addEdge(edgeAB5);
		assertEquals(1, digraph.getEdges().size());
		assertEquals(2, digraph.getNodes().size());

		digraph.addEdge(edgeAD5);
		assertEquals(2, digraph.getEdges().size());
		assertEquals(3, digraph.getNodes().size());
	}

	@Test
	public void testComputeWeightABC() throws Exception {
		addAllEdges();
		List<Node> params = asNodeParams(NODE_A, NODE_B, NODE_C);

		assertEquals(Float.valueOf(9), digraph.computeWeight(params));
	}

	@Test
	public void testComputeWeightAD() throws Exception {
		addAllEdges();
		List<Node> params = asNodeParams(NODE_A, NODE_D);

		assertEquals(Float.valueOf(5), digraph.computeWeight(params));
	}

	@Test
	public void testComputeWeightADC() throws Exception {
		addAllEdges();
		List<Node> params = asNodeParams(NODE_A, NODE_D, NODE_C);

		assertEquals(Float.valueOf(13), digraph.computeWeight(params));
	}

	@Test
	public void testComputeWeightAEBCD() throws Exception {
		addAllEdges();
		List<Node> params = asNodeParams(NODE_A, NODE_E, NODE_B, NODE_C, NODE_D);

		assertEquals(Float.valueOf(22), digraph.computeWeight(params));
	}

	@Test(expected = MissingRouteException.class)
	public void testNoRoute() throws Exception {
		addAllEdges();
		List<Node> params = asNodeParams(NODE_A, NODE_E, NODE_D);

		digraph.computeWeight(params);
	}

	@Test
	public void getNodes() {
		digraph.addEdge(edgeAB5);
		assertTrue(digraph.getEdges().containsValue(edgeAB5));
		assertTrue(digraph.getNodes().contains(NODE_A));
		assertTrue(digraph.getNodes().contains(NODE_B));
	}

	private List<Node> asNodeParams(Node... nodes) {
		if (null != nodes && nodes.length != 0) {
			return Arrays.asList(nodes);
		}
		return new ArrayList<Node>();
	}

	private void addAllEdges() {
		digraph.addEdge(edgeAB5);
		digraph.addEdge(edgeBC4);
		digraph.addEdge(edgeCD8);
		digraph.addEdge(edgeDC8);
		digraph.addEdge(edgeDE6);
		digraph.addEdge(edgeAD5);
		digraph.addEdge(edgeCE2);
		digraph.addEdge(edgeEB3);
		digraph.addEdge(edgeAE7);
	}

	private void initEdges() {
		edgeAB5 = new Edge(NODE_A, NODE_B, Float.valueOf(5));
		edgeBC4 = new Edge(NODE_B, NODE_C, Float.valueOf(4));
		edgeCD8 = new Edge(NODE_C, NODE_D, Float.valueOf(8));
		edgeDC8 = new Edge(NODE_D, NODE_C, Float.valueOf(8));
		edgeDE6 = new Edge(NODE_D, NODE_E, Float.valueOf(6));
		edgeAD5 = new Edge(NODE_A, NODE_D, Float.valueOf(5));
		edgeCE2 = new Edge(NODE_C, NODE_E, Float.valueOf(2));
		edgeEB3 = new Edge(NODE_E, NODE_B, Float.valueOf(3));
		edgeAE7 = new Edge(NODE_A, NODE_E, Float.valueOf(7));
	}
}
