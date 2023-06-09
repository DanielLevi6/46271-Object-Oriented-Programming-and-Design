package homework2;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

/**
 * This class implements a testing driver which reads test scripts from files
 * for testing Graph and PathFinder.
 */
public class TestDriver {

	// String -> Graph: maps the names of graphs to the actual graph
	// TODO: Parameterize the next line correctly.
  	private final Map<String,Graph<WeightedNode>> graphs = new HashMap<>();
  	// String -> WeightedNode: maps the names of nodes to the actual node
  	private final Map<String,WeightedNode> nodes = new HashMap<>();
	private final BufferedReader input;
  	private final PrintWriter output;


  	/**
  	 * Creates a new TestDriver.
     * @requires r != null, w != null
     * @effects Creates a new TestDriver which reads command from r and writes
     *   results to w
     */
  	public TestDriver(Reader r, Writer w) {
    	input = new BufferedReader(r);
    	output = new PrintWriter(w);
  	}


  	/**
  	 * Executes the commands read from the input and writes results to the
  	 * output.
     * @effects Executes the commands read from the input and writes results
     *   to the output.
     * @throws IOException - if the input or output sources encounter an
     *  IOException.
     */
  	public void runTests() throws IOException {
    	String inputLine;
		while ((inputLine = input.readLine()) != null) {
			// echo blank and comment lines
      		if (inputLine.trim().isEmpty() || inputLine.charAt(0) == '#') {
        		output.println(inputLine);
        		continue;
      		}

      		// separate the input line on white space
      		StringTokenizer st = new StringTokenizer(inputLine);
      		if (st.hasMoreTokens()) {
        		String command = st.nextToken();

        		List<String> arguments = new ArrayList<>();
        		while (st.hasMoreTokens())
          			arguments.add(st.nextToken());

        		executeCommand(command, arguments);
      		}
    	}

    	output.flush();
  	}


  	private void executeCommand(String command, List<String> arguments) {
    	try {
      		switch(command) {
      		case "CreateGraph":
        		createGraph(arguments);
        		break;
      		case "CreateNode":
        		createNode(arguments);
        		break;
      		case "AddNode":
        		addNode(arguments);
        		break;
      		case "AddEdge":
        		addEdge(arguments);
        		break;
      		case "ListNodes":
        		listNodes(arguments);
        		break;
      		case "ListChildren":
        		listChildren(arguments);
        		break;
      		case "FindPath":
      			findPath(arguments);
      			break;
      		default:
      			output.println("Unrecognized command: " + command);
      			break;
      		}
    	} catch (Exception e) {
      		output.println("Exception: " + e.toString());
    	}
  	}


	private void createGraph(List<String> arguments) {
    	if (arguments.size() != 1)
      		throw new CommandException(
				"Bad arguments to CreateGraph: " + arguments);

    	String graphName = arguments.get(0);
    	createGraph(graphName);
  	}


  	private void createGraph(String graphName) {
  		//TODO: Insert your code here.
		graphs.put(graphName, new Graph<WeightedNode>(graphName));
		output.println("created graph " + graphName);
  	}
 
  	
  	private void createNode(List<String> arguments) {
    	if (arguments.size() != 2)
      		throw new CommandException(
				"Bad arguments to createNode: " + arguments);

    	String nodeName = arguments.get(0);
    	String cost = arguments.get(1);
    	createNode(nodeName, cost);
  	}


 	private void createNode(String nodeName, String cost) {
 		// TODO: Insert your code here.
 		nodes.put(nodeName, new WeightedNode(nodeName, Integer.parseInt(cost)));
 		output.println("created node " + nodeName + " with cost " + cost);
  	}
	

  	private void addNode(List<String> arguments) {
    	if (arguments.size() != 2)
      		throw new CommandException(
				"Bad arguments to addNode: " + arguments);

    	String graphName = arguments.get(0);
    	String nodeName = arguments.get(1);
    	addNode(graphName, nodeName);
  	}


  	private void addNode(String graphName, String nodeName) {
  		// TODO: Insert your code here.
  		Graph<WeightedNode> graph = graphs.get(graphName);
  		WeightedNode nodeToEnter = nodes.get(nodeName);
		graph.addNode(nodeToEnter);
		output.println("added node " + nodeName + " to " + graphName);
  	}


  	private void addEdge(List<String> arguments) {
    	if (arguments.size() != 3)
      		throw new CommandException(
				"Bad arguments to addEdge: " + arguments);

    	String graphName = arguments.get(0);
    	String parentName = arguments.get(1);
    	String childName = arguments.get(2);
    	addEdge(graphName, parentName, childName);
  	}


	private void addEdge(String graphName, String parentName,
			String childName) {	
		// TODO: Insert your code here.
		Graph<WeightedNode> graph = graphs.get(graphName);
		WeightedNode parentNode = nodes.get(parentName);
		WeightedNode childNode = nodes.get(childName);
		graph.addEdge(parentNode, childNode);
		output.println("added edge from " + parentName + " to " + childName + " in " + graphName);
  	}


  	private void listNodes(List<String> arguments) {
    	if (arguments.size() != 1)
      		throw new CommandException(
				"Bad arguments to listNodes: " + arguments);

    	String graphName = arguments.get(0);
    	listNodes(graphName);
  	}


  	private void listNodes(String graphName) {	
  		// TODO: Insert your code here.
  		Graph<WeightedNode> graph = graphs.get(graphName);
		Iterator<WeightedNode> nodesIter = graph.getNodes();

  		List<String> sortedNameList = new ArrayList<String>();
		while(nodesIter.hasNext()) {
			sortedNameList.add(nodesIter.next().getName());
		}

		String namesString = "";
		if(!sortedNameList.isEmpty()) {
			Collections.sort(sortedNameList);
			namesString = sortedNameList.toString().replace("[", " ");
			namesString = namesString.replace("]", "");
			namesString = namesString.replace(",", "");
		}

		output.println(graphName + " contains:" + namesString);
  	}


  	private void listChildren(List<String> arguments) {
    	if (arguments.size() != 2)
      		throw new CommandException(
				"Bad arguments to listChildren: " + arguments);

    	String graphName = arguments.get(0);
    	String parentName = arguments.get(1);
    	listChildren(graphName, parentName);
  	}


  	private void listChildren(String graphName, String parentName) {
  		// TODO: Insert your code here.
  		Graph<WeightedNode> graph = graphs.get(graphName);
  		WeightedNode parentNode = nodes.get(parentName);
		Iterator<WeightedNode> childrenNodesIter = graph.getChildren(parentNode);

		List<String> sortedNameList = new ArrayList<String>();
		while(childrenNodesIter.hasNext()) {
			sortedNameList.add(childrenNodesIter.next().getName());
		}

		String namesString = "";
		if(!sortedNameList.isEmpty()) {
			Collections.sort(sortedNameList);
			namesString = sortedNameList.toString().replace("[", " ");
			namesString = namesString.replace("]", "");
			namesString = namesString.replace(",", "");
		}

		output.println("the children of " + parentName + " in " + graphName + " are:" + namesString);
  	}


  	private void findPath(List<String> arguments) {
    	String graphName;
    	List<String> sourceArgs = new ArrayList<>();
    	List<String> destArgs = new ArrayList<>();

    	if (arguments.size() < 1)
      		throw new CommandException(
				"Bad arguments to FindPath: " + arguments);

    	Iterator<String> iter = arguments.iterator();
    	graphName = iter.next();

		// extract source arguments
    	while (iter.hasNext()) {
      		String s = iter.next();
      		if (s.equals("->"))
        		break;
      		sourceArgs.add(s);
    	}

		// extract destination arguments
    	while (iter.hasNext())
      		destArgs.add(iter.next());

    	if (sourceArgs.isEmpty())
      		throw new CommandException("Too few source args for FindPath");

    	if (destArgs.isEmpty())
      		throw new CommandException("Too few dest args for FindPath");

    	findPath(graphName, sourceArgs, destArgs);
  	}


  	private void findPath(String graphName, List<String> sourceArgs,
  						  List<String> destArgs) {
  		// TODO: Insert your code here.
		Graph<WeightedNode> graph = graphs.get(graphName);

		Set<WeightedNodePath> starts = new HashSet<WeightedNodePath>();
		for(int i = 0; i < sourceArgs.size(); i++) {
			starts.add(new WeightedNodePath(nodes.get(sourceArgs.get(i))));
		}

		Set<WeightedNode> ends = new HashSet<WeightedNode>();
		for(int i = 0; i < destArgs.size(); i++) {
			ends.add(nodes.get(destArgs.get(i)));
		}

		PathFinder<WeightedNode, WeightedNodePath> finder = new PathFinder<WeightedNode, WeightedNodePath>(graph);
		WeightedNodePath shortestPath = finder.findPath(starts, ends);
		if(shortestPath != null) {
			String nodesString = "";
			Iterator<WeightedNode> nodesIter = shortestPath.iterator();
			while(nodesIter.hasNext()) {
				nodesString += " " + nodesIter.next().getName();
			}
			output.println("shortest path in " + graphName + ":" + nodesString);
		}
		else {
			output.println("no path found in " + graphName);
		}
  	}


	private static void printUsage() {
		System.err.println("Usage:");
		System.err.println("To read from a file: java TestDriver <name of input script>");
		System.err.println("To read from standard input: java TestDriver");
	}


	public static void main(String args[]) {
		try {
			// check for correct number of arguments
			if (args.length > 1) {
				printUsage();
				return;
			}

			TestDriver td;
			if (args.length == 0)
				// no arguments - read from standard input
				td = new TestDriver(new InputStreamReader(System.in),
								    new OutputStreamWriter(System.out));
			else {
				// one argument - read from file
				java.nio.file.Path testsFile = Paths.get(args[0]);
				if (Files.exists(testsFile) && Files.isReadable(testsFile)) {
					td = new TestDriver(
							Files.newBufferedReader(
									testsFile,
									Charset.forName("US-ASCII")),
									new OutputStreamWriter(System.out));
				} else {
					System.err.println("Cannot read from " + testsFile.toString());
					printUsage();
					return;
				}
			}

			td.runTests();

		} catch (IOException e) {
			System.err.println(e.toString());
			e.printStackTrace(System.err);
		}
	}
}

/**
 * This exception results when the input file cannot be parsed properly.
 */
class CommandException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public CommandException() {
		super();
	}

	public CommandException(String s) {
		super(s);
	}
}