/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
    
    /**
     * The given employees are in list. 
     *
     *  Find if employee exisits time => O(n)
     *  Find suboridnates O(n)
     *
     *  We can reduce this complexity to O(1) by optimising search.
     *  Store all the employees in a hash map.
     *      
     * Time -> O(n)   
     * Space -> O(n) -> Worst case 
     *  
     * Can be solved using BFS as well
     *
     *
     ******/
    
    
    public int getImportance(List<Employee> employees, int id) {
     
        Map<Integer, Employee> empMap = new HashMap<>();
        
        for(Employee emp : employees) {
            empMap.put(emp.id, emp);
        }
        
        return helper(empMap, id);
    }
    
    private int helper(Map<Integer, Employee> empMap, int id) {
       
        Employee currEmp = empMap.get(id);
        int result = currEmp.importance;
        
        for(int subordinateId : currEmp.subordinates) { 
                //O(n) -> Worst case can have all employee ids except current.
                result += helper(empMap, subordinateId);
            }
        return result;
    }
    
    
}
