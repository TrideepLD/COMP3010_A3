package assg3;

public class SP {
	
	int minDistance( int dist[], Boolean b[]) {
		
		int min = Integer.MAX_VALUE, index = -1;
		for (int x = 0; x < 5; x++) {
			if (b[x] == false && dist[x] <= min) {
				min = dist[x];
				index = x;
			}
		}
		
		return index;
	}
	
	void printGraph(int dist[], int x) {
		System.out.println("Distance from source to Desitnation is ");
		for (int i = 0; i < 5; i++) {
			System.out.println(i + "----" + dist[i]);
		}
	}

	void dijkstra(int graph[][], int src) {
		int dist[] = new int[5];
		
		Boolean b[] = new Boolean[5];
		
		//initialize the value of the nodes as inf as we have not visited them yet
		for (int i = 0; i < 5; i++) {
			dist[i] = Integer.MAX_VALUE;
			b[i] = false;
		}
		
		//source vertex is 0
		dist[src] = 0;
		
		for (int count = 0; count < 5; count++) {
			int u = minDistance(dist, b);
			b[u] = true;
			for (int x = 0; x < 5; x++) {
				if (!b[x] && graph[u][x] != 0 && dist[u] != Integer.MAX_VALUE && dist[u] + graph[u][x] < dist[x] ) {
					dist[x] = dist[u] + graph[u][x];
				}
			}
			printGraph(dist, 5);
		}
		
	}
	

	
	public static void main(String[] args) {
		
		int graph[][] = new int[][] {
			{0,4,0,0,7},
			{4,0,1,2,0},
			{0,1,0,6,0},
			{0,2,6,0,0},
			{7,0,0,0,0},
		};
		
		SP p = new SP();
		p.dijkstra(graph, 0);
		
	}
	
}
