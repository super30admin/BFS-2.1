import java.util.HashMap;
import java.util.List;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

//Time Complexity : O(N) where N is all employees
//Space Complexity :O(N)   
//Did this code successfully run on Leetcode :Yes
//Any problem you faced while coding this :


// its a BFS problem, just use queue and start from the employee whose id is given and in every iteration
//sum up the importance in the result variable. Also have a hashmap to save id->Employee object so that when we get
//subordinate id's we get employee object to further fetch importance value 

class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};

class EmployeeImportance {
    
	   int totalImportance = 0;
	    
	    public int getImportance(List<Employee> employees, int id) {
	      
	        Map<Integer,Employee> map = new HashMap<>();
	        
	        for(Employee emp:employees){
	            map.put(emp.id,emp);
	        }
	        Queue<Employee> queue = new LinkedList<>();
	        
	        queue.add(map.get(id));
	        
	        while(!queue.isEmpty()){
	            Employee emp = queue.poll();
	                
	            totalImportance += emp.importance;
	            
	            List<Integer> subordinates = emp.subordinates;
	            for(int i:subordinates){
	                queue.add(map.get(i));
	            }
	        }
	        
	        return totalImportance;
	        
	    }
}