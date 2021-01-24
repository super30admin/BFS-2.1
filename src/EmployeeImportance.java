import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//Definition for Employee.
class Employee {
 public int id;
 public int importance;
 public List<Integer> subordinates;
};

public class EmployeeImportance {
	// Time Complexity : O(V)
	// Space Complexity : O(V)
	// Did this code successfully run on Leetcode : yes
	// Any problem you faced while coding this : No
	// Your code here along with comments explaining your approach
	/*
	 * This approach is by using BFS method where the traversal will happen level by level where level consists of the subordinates of its root employee.
	 * Here, we will store the Employee object, which consists of its id, its importance value and the list of subordinates in the hashmap.
	 * The overall importance of an employee is traversed from the queue and the total importance of the employee will be returned.
	 * 
	 */
	//BFS
    public int getImportanceBFS(List<Employee> employees, int id) {
        if(employees == null || employees.size() == 0) return 0;
        Queue<Integer> q = new LinkedList<>();
        int result = 0;
        HashMap<Integer, Employee> map = new HashMap<>();
        for(Employee e : employees){
            map.put(e.id, e);
        }
        q.add(id);
        while(!q.isEmpty()){
            int eid = q.poll();
            Employee e = map.get(eid);
            result += e.importance;
            for(int subId : e.subordinates){
                q.add(subId);
            }
        }
        return result;
    }
    
    // Time Complexity : O(V)
 	// Space Complexity : O(V)
 	// Did this code successfully run on Leetcode : yes
 	// Any problem you faced while coding this : No
 	// Your code here along with comments explaining your approach
 	/*
 	 * This approach is by using DFS method.
 	 * Here, we will store the Employee object, which consists of its id, its importance value and the list of subordinates in the hashmap.
 	 * The overall importance of an employee is traversed from the recursive stack under the hood and the total importance of the employee will be returned.
 	 * 
 	 */
    //DFS
    HashMap<Integer, Employee> map;
    int result;
    public int getImportanceDFS(List<Employee> employees, int id) {
        if(employees == null || employees.size() == 0) return 0;
        map = new HashMap<>();
        for(Employee e : employees){
            map.put(e.id, e);
        }
        dfs(id);
        return result;
    }
    
    private void dfs(int id){
        //base
        //logic
        Employee e = map.get(id);
        result += e.importance;
        for(int subId : e.subordinates){
            dfs(subId);
        }
    }
    
}
