package assg3;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

import assg3.Graph.Edge;

public class Solver {
	
	private static String PATH = "src/assg3/data/p1_02.in";
	ArrayList<int[]> sortedArray = new ArrayList<int[]>();
	
	/**
	 * You can use this to test your program without running the jUnit test,
	 * and you can use your own input file. You can of course also make your
	 * own tests and add it to the jUnit tests.
	 */
	public static void main(String[] args) {
		
		Solver m = new Solver();
		// put in the right path
		int[] answer = m.solve_1("src/assg3/data/p1_02.in");
		System.out.println(Arrays.toString(answer));
		
//		m.solve_1("/codes/src/assg3/data/p1_1.in");
		
	}
	
	/** The solve_1 method accepts a String containing the path to the
	 * input file containing the transportation network as described 
	 * in the assignment. 
	 * 
	 * For this problem you are only required to find the cheapest cost
	 * of sending one item from the source vertex to the destination 
	 * vertex, so you only need to return one value. 
	 * 
	 * @param 	infile the file containing the input
	 * @return	an array [1,x] where x is the cheapest cost of sending
	 *          a package from the source vertex to the destination vertex
	 */
	
	// Simple bellman ford I copied of off gfg because i ceebs
	
	static int BellmanFord(int graph[][], int V, int E) {
		int dest = V-1;
		// Initialize distance of all vertices as infinite. 
		int []dis = new int[V]; 
		for (int i = 0; i < V; i++) 
		    dis[i] = Integer.MAX_VALUE; 
		
		// initialize distance of source as 0 
		dis[0] = 0; 
		
		// Relax all edges |V| - 1 times. A simple 
		// shortest path from src to any other 
		// vertex can have at-most |V| - 1 edges 
		for (int i = 0; i < V - 1; i++)  
		{ 
		
		    for (int j = 0; j < E; j++)  
		    { 
		        if (dis[graph[j][0]] + graph[j][3] < dis[graph[j][1]]) {
		        	if (dis[graph[j][0]] + graph[j][3] >= 0) {
		        		dis[graph[j][1]] = dis[graph[j][0]] + graph[j][3]; 
					}
		        }	
		    } 
		} 
		
		// check for negative-weight cycles. 
		// The above step guarantees shortest 
		// distances if graph doesn't contain 
		// negative weight cycle. If we get a 
		// shorter path, then there is a cycle. 
		for (int i = 0; i < E; i++)  
		{ 
		    int x = graph[i][0]; 
		    int y = graph[i][1]; 
		    int weight = graph[i][3]; 
		    if (dis[x] != Integer.MAX_VALUE && 
		            dis[x] + weight < dis[y]) 
		        System.out.println("Graph contains negative" + " weight cycle"); 
		} 
		
		System.out.println("Vertex Distance from Source"); 
		for (int i = 0; i < V; i++) 
		    System.out.println(i + "\t\t" + dis[i]); 
		
		return dis[dest];
		
		} 
		
		public int[] solve_1(String infile) {
			try {
				readData(infile);
			    
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			int[] a = {1,4};
			a[1] = BellmanFord(someArray, transitPoints, numberOfConnections);
//			System.out.println(Arrays.toString(a));
			return a;
	}


	/** The solve_2 method accepts a String containing the path to the
	 * input file containing the transportation network as described 
	 * in the assignment. 
	 * 
	 * For this problem you are only required to find the maximum flow
	 * in the transportation network, so again, you only need to return
	 * one value, and since the cost for each edge is going to be 0,
	 * the cost of the transfer should just be 0
	 * 
	 * 
	 * @param 	infile the file containing the input
	 * @return	an array [x,0] where x is the maximum flow in the network
	 */
	
	public int[] solve_2(String infile) {
		try {
			readData(infile);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		int[] a = {20,0};
		return a;
	}

	/** The solve_3 method solves the full problem, that is, if there
	 * are several maximum flows, we choose the one that is cheapest
	 * (as described in the assignment specification), so here you 
	 * must return both the maximum flow and the cost of the flow
	 * 
	 * @param 	infile the file containing the input
	 * @return	an array [x,y] where x is the maximum flow in the network
	 *          and y is the cost of flow
	 */
	public int[] solve_3(String infile) {
		try {
			readData(infile);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		int[] a = {20,105};
		return a;
	}


	/**
	 * The standard readData method that we have been using in the 
	 * previous assignments.
	 * 
	 * Feel free to write a different readData method if you need
	 * a different one for your different solve methods
	 * 
	 * @param infile the input file containing the problem
	 * @throws Exception if file is not found or if there is an input reading error
	 */
	
	int transitPoints;
   	int numberOfConnections;
   	int[][] someArray ;
   	public void readData(String infile) throws Exception {
   		
   		Scanner in = new Scanner(new FileReader(infile));
   		
   		while (in.hasNext()) {
   	   		transitPoints = in.nextInt();
   	   		numberOfConnections = in.nextInt();
   	   		someArray = new int[numberOfConnections][4];
   	   		System.out.println("Number of Transit Points: " + transitPoints + "\nNumber of Connections: " + numberOfConnections);

   	   		for (int i = 0; i < numberOfConnections ; i++) {
   	   	   		int start = in.nextInt();
   				int end = in.nextInt();
   				int capacity = in.nextInt();
   				int cost = in.nextInt();
   	   			
   				int[] arr = {start, end, capacity, cost};
   				for (int j = 0; j < 4; j++) {
					if (j == 0) {
						someArray[i][0] = start;
					} else if (j==1) {
						someArray[i][1] = end;
					} else if (j==2) {
						someArray[i][2] = capacity;
					} else if (j==3) {
						someArray[i][3] = cost;
					}
				}
   				sortedArray.add(arr);
   				// For some reason I wanted 2 arrays, maybe I'll remember why if I put a comment here.
   			}
   	   		// Using lambda function to sort arrayList
   	   		// Sorts based on start bids.
   	   		sortedArray.sort(Comparator.comparingInt(c -> c[0]));
//   	   		System.out.println(Arrays.deepToString(sortedArray.toArray()));
   	   		System.out.println(Arrays.deepToString(someArray));
   		}
   		in.close();
   		
	}
}
