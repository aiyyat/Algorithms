# DS Tips
~~~
Approach:
~~~
* Read the Question until you understand it + 1 time.
* Write the scenarios & corner Cases
* Corner cases: Two Types
    * Question Corner Cases. Define them soon after understanding question.
    * Implementation Corner Case. Define them while/after writing the code.
* "DO NOT" start CODE until the above steps are clear
* Write pseudo code/implementation.
* Reherse the scenarios/corner cases on implementation.

# Things to remember:
~~~
Short Circuit
~~~
* The && and || operators "**short-circuit**", meaning they ***don't*** evaluate the **right hand side** if it isn't necessary. The & and | operators, when used as **logical operators**, always evaluate both sides.
~~~
Tree & Graph
~~~
##### Remember the implementation differences. Graph shouldn't be represented like a tree with multiple children as it can have loops. Instead Represent it as an Array of LinkedList and another array with visited or not, finally define a Dictionary of array index against the values.
# Must Redos.
* SearchInRotatedArray: see if you can fit in right>left
* LinkedList Palindrome: 
    * check for middle element is odd or even. 
    * Do not use Queue with recursion. only use it with iteration else you will end up with checking a node against itself.
* Matrix Rotation: layer Rotation. 

~~~
DFS or BFS? When to use it?
~~~
Depth-first Search
Depth-first searches are often used in simulations of games (and game-like situations in the real world). In a typical game you can choose one of several possible actions. Each choice leads to further choices, each of which leads to further choices, and so on into an ever-expanding tree-shaped graph of possibilities.

enter image description here

For example in games like Chess, tic-tac-toe when you are deciding what move to make, you can mentally imagine a move, then your opponent’s possible responses, then your responses, and so on. You can decide what to do by seeing which move leads to the best outcome.

Only some paths in a game tree lead to your win. Some lead to a win by your opponent, when you reach such an ending, you must back up, or backtrack, to a previous node and try a different path. In this way you explore the tree until you find a path with a successful conclusion. Then you make the first move along this path.

Breadth-first search
The breadth-first search has an interesting property: It first finds all the vertices that are one edge away from the starting point, then all the vertices that are two edges away, and so on. This is useful if you’re trying to find the shortest path from the starting vertex to a given vertex. You start a BFS, and when you find the specified vertex, you know the path you’ve traced so far is the shortest path to the node. If there were a shorter path, the BFS would have found it already.

Breadth-first search can be used for finding the neighbour nodes in peer to peer networks like BitTorrent, GPS systems to find nearby locations, social networking sites to find people in the specified distance and things like that.

~~~
Collections
~~~
* https://github.com/aiyyatti/JavaCollections
  
# Prepare:
https://www.hackerrank.com/
https://leetcode.com/
https://www.techiedelight.com/
Cracking the coding interview edition 6
https://www.youtube.com/user/tusharroy2525
Algorithms, 4th Edition by Robert Sedgewick and Kevin Wayne
https://www.geeksforgeeks.org/must-do-coding-questions-for-companies-like-amazon-microsoft-adobe/

# See Also
## Glassdoor - Google Sydney
https://www.glassdoor.com.au/Interview/Google-Sydney-Interview-Questions-EI_IE9079.0,6_IL.7,13_IM962_IP2.htm?countryRedirect=true

