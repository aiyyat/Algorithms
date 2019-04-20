#Purpose of these algorithms
The only purpose of this is to see if two nodes belongs to the same forest in other words if they are connected components.
#### let a be the array where for any index p value is the parent of p.
##Quick Union: 
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
#Union Find:
Do the Quick Union but now based on the weights of the roots, add as child to the lesser weighted root.