// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

import java.util.*;


class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};


class getImp {
    public int getImportance(List<Employee> employees, int id) {
        //base case to check if the list is empty
        if(employees == null || employees.size() == 0)
            return 0;
        
        //map to store the id and the employee object so it is easier to access subordinates
        Map<Integer, Employee> empMap = new HashMap<>();
        for(Employee emp: employees){
            empMap.put(emp.id, emp);
        }
        
        
        Queue<Integer> queue = new LinkedList<>();
        queue.add(id);
        
        int result = 0;
        
        while(!queue.isEmpty()){
            int curr = queue.poll();
            
            Employee employee = empMap.get(curr);
            
            result += employee.importance;
            
            for(int subordinate: employee.subordinates){
                queue.add(subordinate);
            }
        }
        
        return result;
    }
}