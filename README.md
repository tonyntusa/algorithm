# algorithm
Java Algorithm Problem and Solution

https://neetcode.io/practice

https://seanprashad.com/leetcode-patterns/

https://leetcode.com/explore/interview/card/top-interview-questions-easy/

https://leetcode.com/problem-list/top-interview-questions/

Iterate over a Map or Set
```
Map<String, Interger> map = new HashMap<>();
+ keySet()
for(String key: map.keySet()){}

+ values()
for(Integer val : map.values()){}

+ entrySet()
for(Map.Entry<String, Integer> entry : map.entrySet()){
    String key = entry.getKey();
    Interger value = entry.getValue();
}

Set<Interger> set = new HashSet<>();
for(Integer key : set){}
```

Java data structure
+ ArrayList and LinkedList (https://stackabuse.com/difference-between-arraylist-and-linkedlist-in-java-code-and-performance)
```
If elements are going to be fetched often, --> use ArrayList. 
If constant-time insertions are needed or if the total size is unknown beforehand --> LinkedList is preferred.

```
