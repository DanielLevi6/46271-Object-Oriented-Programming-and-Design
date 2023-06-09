package homework2;

import java.util.*;

/** The Graph class is an immutable generic class that represents a directed graph.
 * A directed graph is constructed of nodes, which might be connected through edges.
 * Every edge has a specific direction, from node A to node B.
 * The class provides methods to add or remove nodes and edges. In addition to methods for
 * getting the list of nodes and the list of children in the graph.
 */
public final class Graph<Node> {
    private final Map<Node, Set<Node>> nodesAdjacencyMap;
    private final String name;

    // Abstruction Function:
    //
    //

    // Representation invariant for every Graph g:
    //
    //


    // Creators - methods which creates new representation of the ADT(constructors)

    /**
     * Constructs a new Graph
     * @effects Makes a new graph with the specified name
     *          If the name is NaN, so an empty string will be placed.
     * @param name - the name of the new Graph object
     */
    public Graph(String name) {
        this.nodesAdjacencyMap = new HashMap<>();
        this.name = name;
        this.checkRep();
    }

    // Observers - methods for sending information about the object(without changing it)
    // Mutators - methods which changes the state of the object(just in mutable objects)

    // Producers - methods which creates new representations of the ADT using representation of the ADT(just in immutable objects)

    /**
     * @requires requirements. Inputs thaat the methos is not applied on
     * @modifies the names of the objects ehich are not being modified
     * @effects the behaviour of the method for all the inputs which are not being removed by @requires
     *
     * @param
     * @return
     * @throws
     */
    public String getName() {
        this.checkRep();
        return this.name;
    }


    public boolean addNode(Node new_node) {
        this.checkRep();
        this.nodesAdjacencyMap.put(new_node, new HashSet<Node>());
        this.checkRep();
        return true;
    }

    public boolean addEdge(Node parent_node, Node child_node) {
        this.checkRep();
        this.nodesAdjacencyMap.get(parent_node).add(child_node);
        this.checkRep();
        return true;
    }

    public Iterator<Node> getChildren(Node parent_node) {
        this.checkRep();
        return this.nodesAdjacencyMap.get(parent_node).iterator();
    }

    public Iterator<Node> getNodes() {
        this.checkRep();
        return this.nodesAdjacencyMap.keySet().iterator();
    }

    private void checkRep() {

    }
}
