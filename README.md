# TODOs
learn IndexPriorityQueue: https://www.coursera.org/learn/algorithms-part2/lecture/HoHKu/prims-algorithm

#Algorithms
```*Note: The test cases are written along with the solution for readablility sake & to minimize need to navigate.```

# DFS or BFS? 
```
Depth-first Search
```
Depth-first searches are often used in simulations of games (and game-like situations in the real world). Each choice leads to further choices, each of which leads to further choices, and so on into an ever-expanding tree-shaped graph of possibilities.
+ games like Chess, tic-tac-toe. Use BFS to see if the game can be won or not then backtrace to current move and make the move.
+ Photoshops Magic wand: It builds a grid graph and builds a blob all that have same color.
```
Breadth-first search
```
BFS finds all the vertices that are one edge away from the starting point, then all the vertices that are two edges away, and so on. This is useful for finding the shortest path from the starting vertex to a given vertex. You start a BFS, and when you find the specified vertex, you know the path you’ve traced so far is the shortest path to the node. If there were a shorter path, the BFS would have found it already.
Breadth-first search can be used for finding the neighbour nodes in peer to peer networks like BitTorrent, GPS systems to find nearby locations, social networking sites to find people in the specified distance and things like that.
+ refer to CTCI: WordTransformer.
+ minimum number of hops in a communication network.
+ Shortest path to finding if friends.
# Graphs
## DI Graph: 
+ Build dependencies using topological sort.
+ Doing courses in College. Do the 101s before the others using topological sort.
+ Cycle detection of DI Graph - dependency in Java class extension, excel cell calculation cycle detection.
## Graph Connected Components 
+ Pixel Detection: Identifying the movement of Pixels to understand how stars move.
+ Studying Communicable diseases (graphs) in areas of contamination.
## Minimum Spanning Tree:
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
## Maximum Flow And Minimum Cut
+ https://www.coursera.org/learn/algorithms-part2/lecture/HR7SA/maxflow-applications
+ Bipirate graph - a graph divided into two such that every node of one type connectes to one of the other. find perfect matching - students getting offers and companies (each with only one vacancy) offer multiple students-> each student gets one job
+ Sports elimination
## How difficult a graph problem?
https://www.coursera.org/learn/algorithms-part2/lecture/6kk3F/graph-challenges
1) Any Programmer can do it.
2) diligent algo student
3) Hire an Expert
4) Intractable
5) No one knows
6) Impossible.
+ Is a Graph Bipartite? ```diligent algo student``` - Use DFS to solve it.
+ Find a cycle - ```diligent algo student``` - DFS
+ Seven bridge of Koingsberg - given a graph is there a cycle such that each bridge can be visited exactly once? - ```diligent algo student``` - Eulers - a connected graph is Eulerean iff all vertices (excepting the start and ending ones) must have even degree.
+ Finding a cycle that visits every Vertex exactly once(Travelling salesman problem or Hamiltonian Cycle.) - ```Intractable``` - forms a Hamiltonion Cycle - Typical NP Complete Problem.
+ Given two graphs - are they identical except for the vertex names? ```No one knows``` We dont know how to classify the problem.
+ lay a graph in a plane such that there are no crossing edges - ```Hire an expert```- This is possible in linear time but too complicated to implement.
## Why Not?
Dijkstras cannot be solved by DFS since now there is no way to decide if a node can be marked Visisted or not.

# Union Find Problems
The only purpose of this is to see if two nodes belongs to the same forest in other words if they are connected components.
```Note: let a be the array where for any index p value is the parent of p.```
## Quick Union: 
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
 
## Quick Find
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

## Union Find:
Do the Quick Union but now based on the weights of the roots, add as child to the lesser weighted root.

# Short Circuit
The && and || operators "**short-circuit**", meaning they ***don't*** evaluate the **right hand side** if it isn't necessary. The & and | operators, when used as **logical operators**, always evaluate both sides.
# Tree & Graph
***Remember the implementation differences.*** Graph shouldn't be represented like a tree with multiple children as it can have loops. Instead Represent it as an Array of LinkedList and another array with visited or not, finally define a Dictionary of array index against the values.
# Must Redos.
* SearchInRotatedArray: see if you can fit in right>left
* LinkedList Palindrome: 
    * check for middle element is odd or even. 
    * Do not use Queue with recursion. only use it with iteration else you will end up with checking a node against itself.
* Matrix Rotation: layer Rotation. 
# Collections
* https://github.com/aiyyatti/JavaCollections
* JUnit Assertion samples
# P & NP 
+ **Polynomial Time (P) class problems** also called **Tractable Problems**: that can be solved and verified in polynomial times e.g. sorting and searching. can ```Solve``` and ```Verify``` in Polynomial Times, Shortest Path.
+ **Non Deterministic Polynomial Time (NP) class problems** also called **Intractable Problems**- can be verified in polynomial times (but probably not solvable in P times) e.g SUDOKU, prime factor, scheduling problem, Travelling sales man problem. In other words ```Hard to Solve``` but ```Easy to Verify``` takes ```Exponential Time``` are categorized in NP class.
```Hence P class Problems are a subset of NP Class Problems```
```
Prove that:
```
+ If P == NP then Information Security is easy to crack, but Transportation, Scheduling, understanding DNA etc will become easy to solve.
+ If P != NP then you can classify a class of problems as not solvable in Polynomial Times
```
Reduction:
```
This is a way of classifying problems such that if one is solved other can also be solved:
+ If A can be reduced to B and B can be solved in P then A can be solved in P
+ If A is not solvable in P then B is not Solvable in P
```
NP Complete:
```
A problem is NP Complete if
1) it is verifiable in P but not solvable in P
2) if all A's can be reduced B's that can be solved in P time.
**They are the Decision problems**
```
NP Hard:
```
1) Need to satisfy only the property 2 of NP Complete i.e. if all A's can be reduced B's that can be solved in P time.
**They are the Optimization problems**

```Note: In short NP Complete is a category of NP Hard Problems where the reduction will take P time```
```
Example
```
Knapsack Decision problem can be converted to Knapsack Optimization problem using dynamic programming.
# Key Index Sorting

# less Common Runtime Complexities
+ pseudo polynomial - where the runtime depends on the numeric value of the input rather than the number of input values https://www.geeksforgeeks.org/pseudo-polynomial-in-algorithms/
