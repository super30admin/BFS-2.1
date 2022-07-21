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
     * Space -> O(n/2) -> Worst case max queue size  + O(n) Hashmap
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
        
        Queue<Integer> q = new LinkedList<>();
        q.add(id);
        
        int imp = 0;
        
        // BFS, no need to track level. So no size varaible.
        while(!q.isEmpty()) { 
            int empId = q.poll();
            Employee emp = empMap.get(empId);
            imp += emp.importance;
            for(int subordinateId : emp.subordinates)
                q.add(subordinateId);
        }
        
        return imp;
    }
    
}
