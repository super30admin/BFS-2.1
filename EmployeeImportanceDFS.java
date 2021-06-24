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
import java.util.List;
import java.util.Map;

// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};


class EmployeeImportanceDFS {
	int result=0;
	Map<Integer,Employee> map = new HashMap<>();
    public int getImportance(List<Employee> employees, int id) {
        
        for(Employee emp:employees){
            map.put(emp.id,emp);
        }
        dfs(id);
        
        return result;        
    }
    
    private void dfs(int id) {
    	result=result+map.get(id).importance;
    	for(int subId:map.get(id).subordinates) {
    		dfs(subId);
    	}
    }
    
}