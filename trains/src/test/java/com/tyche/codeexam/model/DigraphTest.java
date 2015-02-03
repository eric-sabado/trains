package com.tyche.codeexam.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class DigraphTest {

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
		List<Edge> params = buildParams(edgeAB5, edgeBC4);
		
		assertEquals(Float.valueOf(9), digraph.computeWeight(params));
	}
	
	@Test
	public void testComputeWeightAD() throws Exception {
		addAllEdges();
		List<Edge> params = buildParams(edgeAD5);
		
		assertEquals(Float.valueOf(5), digraph.computeWeight(params));
	}
	
	@Test
	public void testComputeWeightADC() throws Exception {
		addAllEdges();
		List<Edge> params = buildParams(edgeAD5, edgeDC8);
		
		assertEquals(Float.valueOf(13), digraph.computeWeight(params));
	}
	
	@Test
	public void testComputeWeightAEBCD() throws Exception {
		addAllEdges();
		List<Edge> params = buildParams(edgeAE7, edgeEB3, edgeBC4, edgeCD8);
		
		assertEquals(Float.valueOf(22), digraph.computeWeight(params));
	}
	
	@Test(expected=Exception.class)
	public void testNoRoute() throws Exception {
		addAllEdges();
		List<Edge> params = buildParams(edgeAE7, new Edge(new Node("E"), new Node("D"), null));
		
		digraph.computeWeight(params);
	}

	@Test
	public void getNodes() {
		digraph.addEdge(edgeAB5);
		assertTrue(digraph.getEdges().containsValue(edgeAB5));
		assertTrue(digraph.getNodes().contains(new Node("A")));
		assertTrue(digraph.getNodes().contains(new Node("B")));
	}
	
	@Test
	@Ignore
	public void testGetEdges() {
		fail("Not yet implemented");
	}
	
	private List<Edge> buildParams(Edge... edges) {
		if(null!=edges && edges.length!=0) {
			return Arrays.asList(edges);
		}
		return new ArrayList<Edge>();
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
		edgeAB5 = new Edge(new Node("A"), new Node("B"), Float.valueOf(5));
		edgeBC4 = new Edge(new Node("B"), new Node("C"), Float.valueOf(4));
		edgeCD8 = new Edge(new Node("C"), new Node("D"), Float.valueOf(8));
		edgeDC8 = new Edge(new Node("D"), new Node("C"), Float.valueOf(8));
		edgeDE6 = new Edge(new Node("D"), new Node("E"), Float.valueOf(6));
		edgeAD5 = new Edge(new Node("A"), new Node("D"), Float.valueOf(5));
		edgeCE2 = new Edge(new Node("C"), new Node("E"), Float.valueOf(2));
		edgeEB3 = new Edge(new Node("E"), new Node("B"), Float.valueOf(3));
		edgeAE7 = new Edge(new Node("A"), new Node("E"), Float.valueOf(7));
	}
}
