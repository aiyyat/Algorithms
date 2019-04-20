##P & NP 
Non Deterministic Polynomial Time Problems
https://www.youtube.com/watch?v=e2cF8a5aAhE
https://www.youtube.com/watch?v=YX40hbAHx3s

## DFS or BFS? 
```
Depth-first Search
```
Depth-first searches are often used in simulations of games (and game-like situations in the real world). In a typical game you can choose one of several possible actions. Each choice leads to further choices, each of which leads to further choices, and so on into an ever-expanding tree-shaped graph of possibilities.
+ games like Chess, tic-tac-toe when you are deciding what move to make, you can mentally imagine a move, then your opponent’s possible responses, then your responses, and so on. You can decide what to do by seeing which move leads to the best outcome.
Only some paths in a game tree lead to your win. Some lead to a win by your opponent, when you reach such an ending, you must back up, or backtrack, to a previous node and try a different path. In this way you explore the tree until you find a path with a successful conclusion. Then you make the first move along this path.
+ Photoshops Magic wand: It builds a grid graph and builds a blob all that have same color.
```
Breadth-first search
```
The breadth-first search has an interesting property: It first finds all the vertices that are one edge away from the starting point, then all the vertices that are two edges away, and so on. This is useful if you’re trying to find the shortest path from the starting vertex to a given vertex. You start a BFS, and when you find the specified vertex, you know the path you’ve traced so far is the shortest path to the node. If there were a shorter path, the BFS would have found it already.
Breadth-first search can be used for finding the neighbour nodes in peer to peer networks like BitTorrent, GPS systems to find nearby locations, social networking sites to find people in the specified distance and things like that.
+ refer to CTCI: WordTransformer.
+ minimum number of hops in a communication network.
+ Shortest path to finding if friends.


## Graph Connected Components 
+ Pixel Detection: Identifying the movement of Pixels to understand how stars move.
+ Studying Sexually transmitted disease (graphs) in college.
#### Minimum Spanning Tree:
If the graphs are not connected you will get a minimum spanning forest.Spanning tree is a subgraph that are connected and has no cycles.
+ https://www.coursera.org/learn/algorithms-part2/lecture/lEPxc/introduction-to-msts

+ Implemented using: Kruskals Algorithm, Prims Algorithms
+ By-cycle routes in Seatle.
+ Cancer research arrangement of nuclei.
+ Image Processing: Dithering to remove fuzziness in medical images. https://en.wikipedia.org/wiki/Dither
+ Cluster Analysis
+ Max Bottleneck paths.
+ Real Time face verifiction.
+ Find road networks in satellite image.

#Union Find
The only purpose of this is to see if two nodes belongs to the same forest in other words if they are connected components.
######Note: let a be the array where for any index p value is the parent of p.
```
Quick Union: 
```
Union Operation:
```
1) get the root of first component and root of the second.
2) assign the root of the first to the root of the second.
```
isConnected Operation
```
Check and return if the root of the first and second are the same.
 ```
 Root Operation
 ```
 iterate through the root of p until p = root(p)
 
#Quick Find
```
Union Operation:
```
1) find the a[p], let it be pp. 
2) find the a[q], let if be qp
3) run a loop and change the values of pp to qp's.
```
isConnected Operation:
``` 
return a[p] == a[q]
```
Union Find:
```
Do the Quick Union but now based on the weights of the roots, add as child to the lesser weighted root.