package homework2;

import java.util.*;

public class PathFinder<N, P extends Path<N,P>> {
    private Graph<N> graphPaths;
    public PathFinder(Graph<N> graphPathFinder) {
        this.graphPaths = graphPathFinder;
    }

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
}
