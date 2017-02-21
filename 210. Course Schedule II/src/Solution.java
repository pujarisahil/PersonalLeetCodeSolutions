import java.util.*;

/**
 * Created by sahilpujari on 10/30/16.
 */
public class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Set<Integer>> myList = new ArrayList<>();

        for(int i = 0; i < numCourses; i++) {
            myList.add(new HashSet<>());
        }

        //Index i of myList requires prerequisites there
        for(int i = 0; i < prerequisites.length; i++) {
            myList.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }

        //No of prerequisites for each course
        int[] degrees = new int[numCourses];

        for(int i = 0; i < numCourses; i++) {
            for(int x : myList.get(i))
                degrees[x]++;
        }

        Queue<Integer> myQueue = new LinkedList<>();

        for(int i = 0; i < numCourses; i++) {
            if(degrees[i] == 0) {
                myQueue.add(i);
            }
        }

        int[] result = new int[numCourses];

        int count = 0;

        while(!myQueue.isEmpty()) {
            int curr = myQueue.remove();
            for(int x : myList.get(curr)) {
                degrees[x]--;
                if(degrees[x] == 0)
                    myQueue.add(x);
            }
            result[count++] = curr;
        }

        if(count == numCourses) return result;
        return new int[0];
    }
}