Deep First Search (DFS) - https://youtu.be/PMMc4VsIacU?t=903
  + Recursive (Leetcode 94, 144, 145)
  + Stack (Leetcode 94, 144, 145)
    ```
    Stack<Integer> stack = new Stack<>();
    stack.push(1);  // Add object to stack
    
    int value = stack.pop();    // Get an object and REMOVE it frorm stack
    int value = stack.peek();   // Get an object BUT not REMOVE
    ```    
Breath First Search (BFS) - https://youtu.be/xlVX7dXLS64?t=225
  - Queue (Letcode 102)
    ```
    Queue<String> queue = new LinkedList<>();
    queue.offer("value"); // Add object to Queue  
    queue.add("value");   // Add object to Queue
    
    String value = queue.poll();         // Remove object to Queue  
    String value = queue.remove();       // Remove object to Queue
    ```
  
Binary Tree Traversal
  + PreOrder Traversal  (ROOT, LEFT, RIGHT) --> PreOrder it means ROOT PRE(FIRST)
  + InOrder             (LEFT, ROOT, RIGHT) --> InOrder it means ROOT IN MIDDLE
  + PostOrder           (LEFT, RIGHT, ROOT) --> PostOrder it means ROOT POST(LAST) 

https://www.youtube.com/watch?v=s2Yyk3qdy3o&ab_channel=Insidecode
