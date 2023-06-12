package homework2;

import java.util.*;

/** The Graph class is an immutable generic class that represents a directed graph.
 *
 * A directed graph is constructed of nodes, which might be connected through edges.
 * Every edge has a specific direction, from node A to node B.
 *
 * The class provides methods to add nodes and edges to the graph. In addition to methods to
 * get the list of nodes and the list of node's children.
 *
 * Node - the node's class
 */
public final class Graph<Node> {
    // Abstraction Function:
    // A node in the graph is represented as a key of the nodesAdjacencyMap map
    // An edge from A to B is represented as by the presence of B in A's adjacency set(the value of the map's key A)

    // Representation invariant:
    //      name != null
    //      for every Node n in map's keys:
    //           n exists in only one copy
    //      for every set of node's children:
    //           each child node n exists as only one copy
    private final Map<Node, Set<Node>> nodesAdjacencyMap;
    private final String name;

    /**
     * Constructs a new Graph
     * @effects Makes a new graph with the specified name
     *          If the name is null, so an empty string will be placed.
     * @param name - the name of the new Graph object
     */
    public Graph(String name) {
        this.nodesAdjacencyMap = new HashMap<>();
        if(name != null) {
            this.name = name;
        }
        else {
            this.name = "";
        }
        this.checkRep();
    }

    /**
     * @return the graph's name
     */
    public String getName() {
        this.checkRep();
        return this.name;
    }

    /**
     * @requires (new_node != null) && (new_node hasn't been already added to the graph)
     * @modifies this
     * @effects adds new_node to nodesAdjacencyMap as a key
     *
     * @param new_node to add to the graph
     * @throws IllegalArgumentException when new_node already exists in the graph or new_node==null
     */
    public void addNode(Node new_node) {
        this.checkRep();
        if(new_node == null) {
        	throw new IllegalArgumentException("Can't add null node to the graph");
        }
        if(this.nodesAdjacencyMap.containsKey(new_node)) {
        	throw new IllegalArgumentException("The node already exists in the graph");
        }
        this.nodesAdjacencyMap.put(new_node, new HashSet<Node>());
        this.checkRep();
    }

    /**
     * @requires (parent_node != null) && (child_node != null) && (parent_node and child_node are part of the graph)
     * @modifies this
     * @effects adds child_node to the parent_node's adjacency set(this.nodeAdjacencyMap.get(parent_node))
     *
     * @param parent_node the node which the edge starts from.
*             child_node the node which the edge ends in.
     * @throws IllegalArgumentException when parent_node == null or child_node == null
     */
    public void addEdge(Node parent_node, Node child_node) {
        this.checkRep();
        if(parent_node == null || child_node == null) {
        	throw new IllegalArgumentException("Can't add an edge with a null node to the graph");
        }
        this.nodesAdjacencyMap.get(parent_node).add(child_node);
        this.checkRep();
    }

    /**
     * @requires parent_node != null
     *
     * @param parent_node the node whose children's iterator we want
     * @return an iterator for the parent_node's children
     * @throws IllegalArgumentException when parent_node == null
     */
    public Iterator<Node> getChildren(Node parent_node) {
        this.checkRep();
        if(parent_node == null) {
        	throw new IllegalArgumentException("Can't add an edge with a null node to the graph");
        }
        return this.nodesAdjacencyMap.get(parent_node).iterator();
    }

    /**
     * @return an iterator for all the nodes in the graph
     */
    public Iterator<Node> getNodes() {
        this.checkRep();
        return this.nodesAdjacencyMap.keySet().iterator();
    }

    /**
     * @effects checks the Rep. Invariant on the object, and throws an error accordingly
     *
     * @throws AssertionError if the Rep. Invariant was not fulfilled
     */
    private void checkRep() {
        assert(this.name != null);
        // All the other requirements holds because of the data structures-
        // If the same node will be added somehow to the graph, so the HashMap would replace the previous one(and it's value).
        // If the same node will be added to an adjacent set of a node, it wouldn't insert it again, because of the Set
        // definition.
    }
}
