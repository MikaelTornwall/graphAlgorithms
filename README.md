# Graph Algorithms

Small algorithm library for basic graph algorithms.

Includes the following implementations:
* Depth-First Search
* Breadth-First Search
* Bellman-Ford algorithm
* Dijkstra's algorithm
* Topological sort
* Kosaraju's algorithm
* Longest path in DAG
* Kruskal's algorithm
* Prim's algorithm
* Ford-Fulkerson algorithm (Edmonds-Karp)

## Graph Traversal

### Depth-First Search O(n + m)

DFS traverses the graph for as long as possible before backtracking.

### Breadth-First Search O(n + m)

BFS traverses the graph "layer by layer"

## Shortest Paths

### Bellman-Ford algorithm O(nm)

Algorithm finds shortest paths to every node from the starting node. 

Special features:
* Does not allow negative cycles

### Dijkstra's algorithm O(n + m log n)

Finds the shortest paths to every node from the starting node in O(n + m log n) time by selecting always the node with the shortest distance

Special features:
* Greedy algorithm
* Does not allow negative edge weights

## Directed Acyclic Graphs (DAG)

### Topological Sort O(n + m)

Special features:
* Takes advantage of depth-first search to find the topological order of the graph
* Works only in acyclic graphs

## Kosaraju' algorithm O(n + m)

Algorithm finds the connected components of the graph.

Steps:
1. Finds the order of appearance of the nodes using depth-first search
2. Creates a transpose matrix where every edge direction is reversed
3. Executes depth first search calls as long as there are unvisited nodes

## Longest Path in DAG

Finding the longest path in cyclic graphs is not meaningful, but in acyclic graphs this is a relevant proble.

Special features: 
* Algorithm takes advantage of topological sort in finding the longest path in a graph.

## Minimum Spanning Tree

### Kruskal's algorithm O(m log n)

Special features:
* Algorithm takes advantage of the Union-find datastructure in finding the minimum spanning tree of a graph
* Greedy algorithm

Steps:
1. Sort the edges by weight
2. Create component out of each node
3. Loop over the edge list
2. Always select the edge if it connects two different components

### Prim's algorithm O(m log n)

Algorithm has resemblense with Dijkstra's algorithm, with the difference that in Dijkstra's algorithm we always select the node with the
shortest distance, while with Prim'm algorithm we select a node that's distance from the tree is the shortest.

Special features:
* Greedy algorithm
* Takes advantage of minimum heap/priority queue

Steps:
1. Create empty sets for nodes, S, and edges, F
2. Select and arbitrary node and add it to set F
3. Repeat the following steps n - 1 times:
	
	a. Select an edge with minimum weight that connects the set S to a node outside of the set S
	
	b. Add the edge to F
	
	c. Add the node to S

## Maximum Flow

### Ford-Fulkerson algorithm O(nm^2)

Ford Fulkerson algorithm finds the maximum flow of the graph. This maximum flow equals to the minimum cut of the graph as well.

Special features:
* Takes advantage of breadth-first search, so this is actually an implementation of Edmonds-Karp algorithm
* A residual graph has to be maintained during the algorithm

Steps:
1. On every round create path from source node to sink node
2. After finding a path, we:
	
	a. Find an edge with the smallest capacity, lets denote that with p
	
	b. Decrease the weight of each edge along the path with p
	
	c. Increase the weight of each residual edge along the path with p
3. Continue until new paths can not be formed


