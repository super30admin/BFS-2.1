import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

//Time Complexity : O(N)
//Space Complexity : O(N)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : None

/**
 * Push all the employees to the map with id to employee object.
 * Then apply bfs on the given emp id. Push that emp to queue
 * While queue is not empty, pop the employee and add its importance to 
 * final output and then push its subordinates to the queue.
 * return final answer.
 *
 */
class Solution {
	public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> map = new HashMap<>();
        Queue<Employee> queue = new LinkedList<>();
        int sum = 0;
        for(Employee e : employees) 
            map.put(e.id, e);
        queue.add(map.get(id));
        while(!queue.isEmpty()) {
            Employee e = queue.poll();
            sum += e.importance;
            for(int emp : e.subordinates)
                queue.add(map.get(emp));
        }
        return sum;
    }
