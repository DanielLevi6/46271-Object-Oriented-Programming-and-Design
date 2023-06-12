package homework2;

import java.util.*;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * This class contains a set of test cases that can be used to test the graph
 * and shortest path finding algorithm implementations of homework assignment
 * #2.
 */
public class GraphTester extends GraphScriptFileTester {

	// black-box tests are inherited from super
	public GraphTester(java.nio.file.Path testFile) {
		super(testFile);
	}

	// TODO: add additional white box tests
	@Test
	public void basicGraphCreateTest() {
		Graph<WeightedNode> graph = new Graph<WeightedNode>("myGraph");
		assertNotNull(graph);
		assertEquals(graph.getName(), "myGraph");
	}

	@Test
	public void nullNameGraphTest() {
		Graph<WeightedNode> graph = new Graph<WeightedNode>(null);
		assertEquals(graph.getName(), "");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void addNodeTwiceTest() {
		// Doesn't flow the Rep. Invariant, but we added this case to the code
		Graph<WeightedNode> graph = new Graph<WeightedNode>("myGraph");
		WeightedNode node = new WeightedNode("myNode", 2);
		
		graph.addNode(node);
		graph.addNode(node);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void nullNodeAddTest() {
		// Doesn't flow the Rep. Invariant, but we added this case to the code
		Graph<WeightedNode> graph = new Graph<WeightedNode>("myGraph");
		
		graph.addNode(null);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void nullParentEdgeAddTest() {
		Graph<WeightedNode> graph = new Graph<WeightedNode>("myGraph");
		WeightedNode node = new WeightedNode("node", 432);
		
		graph.addNode(node);
		graph.addEdge(null, node);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void nullChildEdgeAddTest() {
		Graph<WeightedNode> graph = new Graph<WeightedNode>("myGraph");
		WeightedNode node = new WeightedNode("node", 432);
		
		graph.addNode(node);
		graph.addEdge(node, null);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void nullGraphInFinderCreate() {
		PathFinder<WeightedNode, WeightedNodePath> finder = new PathFinder<WeightedNode, WeightedNodePath>(null);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void nullGetChildrenCreate() {
		Graph<WeightedNode> graph = new Graph<WeightedNode>("myGraph");
		graph.getChildren(null);
	}
	
	@Test
	public void noPathExists() {
		Graph<WeightedNode> graph = new Graph<WeightedNode>("myGraph");
		WeightedNode node1 = new WeightedNode("node", 2);
		WeightedNode node2 = new WeightedNode("node2", 2);

		graph.addNode(node1);
		graph.addNode(node2);
		
		PathFinder<WeightedNode, WeightedNodePath> finder = new PathFinder<WeightedNode, WeightedNodePath>(graph);
		Set<WeightedNodePath> starts = new HashSet<WeightedNodePath>();
		Set<WeightedNode> goals = new HashSet<WeightedNode>();
		assertEquals(finder.findPath(starts, goals), null);
	}
	
}
