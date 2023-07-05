package homework4;

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
public class WeatherDataFactory {
    // Abstraction Function:
    // A node in the graph is represented as a key of the nodesAdjacencyMap map
    // An edge from A to B is represented as by the presence of B in A's adjacency set(the value of the map's key A)

    // Representation invariant:
    //      name != null
    //      for every Node n in map's keys:
    //           n exists in only one copy
    //      for every set of node's children:
    //           each child node n exists as only one copy
	public LocationWeatherData c() {
		
	}
}
