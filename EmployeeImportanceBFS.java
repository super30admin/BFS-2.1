// Time Complexity : O(N)
// Space Complexity : O(N) //queue will have only one level elements that is max n/2 at leaf level.
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

/**
 * 1. Create a map of employee and its subordinates.
 * 2. Find the given employee and run DFS or BFS and add importance to result.
 * 3. return result.
 */

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};


class EmployeeImportanceBFS {
    public int getImportance(List<Employee> employees, int id) {
        
        Map<Integer,Employee> map = new HashMap<>();
        for(Employee emp:employees){
            map.put(emp.id,emp);
        }
        int result=0;
        Queue<Integer> queue=new LinkedList<>();
        queue.add(id);
        
        while(!queue.isEmpty()) {
        	int empId=queue.poll();
        	result = result+ map.get(empId).importance;
        	for(Integer subId:map.get(empId).subordinates) {
        		queue.add(subId);
        	}
        }
        
        return result;
        
    }
}