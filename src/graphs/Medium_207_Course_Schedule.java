package graphs;

import java.util.LinkedList;
import java.util.Queue;

/**
 https://leetcode.com/problems/course-schedule/

 There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.

 For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
 Return true if you can finish all courses. Otherwise, return false.



 Example 1:

 Input: numCourses = 2, prerequisites = [[1,0]]
 Output: true
 Explanation: There are a total of 2 courses to take.
 To take course 1 you should have finished course 0. So it is possible.
 Example 2:

 Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
 Output: false
 Explanation: There are a total of 2 courses to take.
 To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.


 Constraints:

 1 <= numCourses <= 2000
 0 <= prerequisites.length <= 5000
 prerequisites[i].length == 2
 0 <= ai, bi < numCourses
 All the pairs prerequisites[i] are unique.
 */
public class Medium_207_Course_Schedule {
    /*
    https://www.youtube.com/watch?v=eL-KzMXSXXI&t=183s&ab_channel=WilliamFiset
    https://www.youtube.com/watch?v=2l22FRtU45M&t=901s&ab_channel=FisherCoder
    https://www.youtube.com/watch?v=bvtm8fsiqN8&ab_channel=EricProgramming
    https://www.youtube.com/watch?v=tggiFvaxjrY&ab_channel=TECHDOSE
    https://leetcode.com/problems/course-schedule/discuss/2661402/dfs-topological-sort(short-solution)

    [[1,0],[2,0],[3,1],[3,2]]
    numCourses = 4 (numCourses courses you have to take, labeled from 0 to numCourses - 1)
        --> COURSEs ONLY is 0 .... n - 1 (0, 1, 2, 3)
    0 --> 1 --> 3
    |           ^
    V           |
    2-----------|

    --> indegree of a vertex is the number of edges going to (IN) it
            indegree of vertex (2) is 1
            indegree of vertex (3) is 1, 2
        outdegree of a vertex is the number of edges going from (OUT) it
            outdegree of vertex (0) are 1, 3

    IDEA: Use Topological Sort Algorithm (DAG = Directed Acyclic Grap) - Khan's Algorithm
        Step1: Use SET(or QUEUE) to store courses with NO indegree AND MAP to map a vertex with number of indegre
            + Use a MAP (or array) to store all indegress courses
                Map: {0: 0, 1: 1, 2: 1: 3: 2} // Example Map store indegree
                        i (index is course)
                Array: [0, 1, 1, 2]           // Example Array store indegree
                {
                vetex(0): numOfIndegree=0,
                vetex(1): numOfIndegree=1,
                vetex(2): numOfIndegree=1,
                vetex(3): numOfIndegree=2
                }
            + Loop through MAP to filter indegree with numOfIndegree=0 INSERT into SET
        Step2: If SET(QUEUE) is EMPTY --> return FALSE
        Step3: REMOVE each course from SET while it is NOT EMPTY and UPDATE MAP
            + Get course out of SET AND REMOVE it
            + Compare the course with courses from prerequisites
                if(the course == ) UPDATE MAP

        Step4: Loop for MAP. If there is ONE item has numOfIndegree != 0 --> return False. Else, return True
    */

    public boolean canFinish(int numCourses, int[][] pres) {
        // STEP1: Use SET(or QUEUE) to store courses with NO indegree AND MAP to map a vertex with number of indegre
        // Use Map to count number of indegree of a course (vertex)
        // <course, number of edges going to (IN) the course>
        // Map: {0: 0, 1: 1, 2: 1: 3: 2}
        // Imaging that, INDEX of array is course, array value is number of edges going to (IN) the course (IF we use array)
        int[] mapIndegree = new int[numCourses];
        for(int[] pre: pres){
            int course = pre[0]; // indegree course
            mapIndegree[course]++;
        }

        // Filter courses with numOfIndegree = 0 and PUT to QUEUE (or SET)
        // queue = <0>
        Queue<Integer> queue = new LinkedList<>();
        for(int course=0; course<mapIndegree.length; course++){
            if(mapIndegree[course] == 0) queue.offer(course);
        }

        // STEP2: If SET(QUEUE) is EMPTY --> return FALSE
        if(queue.isEmpty()) return false;

        // STEP3: REMOVE each course from SET while it is NOT EMPTY and UPDATE MAP
        // [[1,0],[2,0],[3,1],[3,2]]
        while(!queue.isEmpty()){
            int course = queue.poll(); // indegree course
            for(int[] pre: pres){
                // Update MAP and insert course to QUEUE if numOfIndegree=0
                if(course == pre[1]){
                    mapIndegree[pre[0]]--; // Update MAP by reduce numOfIndegree - 1
                    if(mapIndegree[pre[0]] == 0)
                        queue.offer(pre[0]); // Add course queue if numOfIndegree = 0 for that course
                }
            }
        }

        //STEP4: Loop for MAP. If there is ONE item has numOfIndegree != 0 --> return False. Else, return True
        for(int numOfIndegree: mapIndegree){
            if(numOfIndegree != 0) return false;
        }

        return true;
    }
}
