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


class Solution {
    
    Map<Integer, Employee> empMap;
    int total;
    public int getImportance(List<Employee> employees, int id) {
        if(employees == null || employees.size() == 0)
            return 0;
        
        empMap = new HashMap<>();
        for(Employee emp: employees){
            empMap.put(emp.id, emp);
        }
        
        
        helper(id);
        return total;
    }
    
    private void helper(int id){
        
        Employee emp = empMap.get(id);
        total += emp.importance;

        //call helper method for each subordinate
        for(int sub: emp.subordinates){
            helper(sub);
        }
    }
}