* VI.2
* VI.11

## Strings
### String search
* what is permutation of string of N characters -> N!?
    https://www.geeksforgeeks.org/anagram-substring-search-search-permutations/
* <b>KMP</b>  https://www.youtube.com/watch?v=GTJr8OvyEVQ&t=353s
* <b>Rabin Karp</b> https://www.youtube.com/watch?v=H4VrKHVG5qI 
* <b>Boyer Moore</b>
* <b>Z Algorithm</b>
### quesitons to ask:
Note: Below are applicable where the order doesn't matter
possible questions: 
1) Upper Lower, special characters???
2) alpha numeric?
### Bit Operation on Char freq Table:
* if the characaterset is a to z only? 
* if it is case insensitive.
* if the question involves finding the presence of a character - eg. if unique 
* if the above is true there are only 26 characters. if so you can use an integer to represent the characters 
* Question: can bit manipulation be done on long?
### Additional Data structure:
if the characterset is more than just a to z
if it involves 128 or even 256 ascii characterset use an array of 128/256 length.
### 
String compression - corner case.

## General Notes:
* log(N)/log(10) or log N to the base 10 is equal to the number of digits of N.
* The && and || operators "short-circuit", meaning they don't evaluate the right hand side if it isn't necessary. The & and | operators, when used as logical operators, always evaluate both sides.

```
Sorting
```
* topological sort.

###Questions:
* find the shortest substring containing all the characters of another string. 
    * what if all strings are unique (minimum window substring)
    * what if they are not unique?
* largest window with unique strings
* group such that strings on one group doesn't exist in the others.
* longest palindrome substring
* longest increasing subsequence.
* Kadane
* Is a tree balanced?
* build order - cyclic detection.

~~~
Sorting:
~~~ 
if no additional DS is allowed
you can resort to sorting the array(s) of characters and comparing by means of pointers.
