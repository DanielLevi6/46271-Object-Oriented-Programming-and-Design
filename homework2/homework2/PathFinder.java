package homework2;

import java.util.*;

/** The PathFinder class is an immutable generic class that represents an algorithm
 * for finding the shortest path between two groups of nodes in a graph.
*
* N - the node's class
* P - the path's class
*/
public class PathFinder<N, P extends Path<N,P>> {
    // Abstraction Function:
	// The graph is stored in the class, and by sending two groups of nodes to the PathFinder method we get 
	// the shortest path between the two groups.
	// The starts group must be represented as paths(P), and goals as nodes(N)

    // Representation invariant:
    //      graphPaths != null
    private Graph<N> graphPaths;
    
    /**
     * Constructs a new PathFinder
     * @requires graphPathFinder != null
     * 
     * @effects Makes a new finder which works on the specified graph
     * @param graphPathFinder - the graph we want to apply the finding algorithm on
     * @throws IllegalArgumentException when graphPathFinder == null
     */
    public PathFinder(Graph<N> graphPathFinder) {
    	if(graphPathFinder == null) {
    		throw new IllegalArgumentException("Can't use null a graph");
    	}
        this.graphPaths = graphPathFinder;
        this.checkRep();
    }

    /**
     * @requires starts != null && goals != null
     *
     * @param starts a set of nodes, represented as paths(P), which the shortest path should come from(to one of them)
     * 		  goals a set of nodes(N) which the shortest path should come to(to one of them)
     * @return The shortest path(P type) from starts to goals if such a path exists
     * 		   null if there is no such path
     */
    public P findPath(Set<P> starts, Set<N> goals) {
        Map<N, P> paths = new HashMap<N, P>();

        PriorityQueue<P> active = new PriorityQueue<P>();

        Iterator<P> startIter = starts.iterator();
        while(startIter.hasNext()) {
            P startNode = startIter.next();
            paths.put(startNode.getEnd(), startNode);
            active.add(startNode);
        }

        Set<N> finished = new HashSet<N>();

        while(!active.isEmpty()) {
            P queueMin = active.poll();
            N queueMinNode = queueMin.getEnd();
            P queueMinPath = paths.get(queueMinNode);

            if(goals.contains(queueMinNode)) {
                return queueMinPath;
            }

            Iterator<N> queueMinIter = this.graphPaths.getChildren(queueMinNode);
            while(queueMinIter.hasNext()) {
                N c = queueMinIter.next();
                P cpath = queueMinPath.extend(c);
                if(!finished.contains(c)) {
                    boolean inActive = false;
                    Iterator<P> activeIter = active.iterator();
                    while(activeIter.hasNext()) {
                        if(c == activeIter.next().getEnd()) {
                            inActive = true;
                        }
                    }
                    if(inActive == false) {
                        paths.put(c, cpath);
                        active.add(cpath);
                    }
                }
            }

            finished.add(queueMinNode);
        }

        return null;
    }
    
    /**
     * @effects checks the Rep. Invariant on the object, and throws an error accordingly
     *
     * @throws AssertionError if the Rep. Invariant was not fulfilled
     */
    private void checkRep() {
        assert(this.graphPaths != null);
    }
}
