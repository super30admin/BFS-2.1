/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class EmployeeImportance {
    
    // Time Complexity: O(n)    (where n -> no. of employees)
    // Space Complexity: O(n)
    
    public int getImportance(List<Employee> employees, int id) {
        // Edge case checking
        if(employees == null || employees.size() == 0)
            return 0;
        
        int totaImportance = 0;
        Queue<Integer> q = new LinkedList<>();
        Map<Integer, Employee> map = new HashMap<>();
        
        // Populate the hashmap with employee and their subordinates
        for(Employee e : employees){
            map.put(e.id, e);
        }
        
        // Add to the qeueue - the importance of the employee we want
        q.offer(id);

        // Do a BFS - get the importance and subordinate and continue the process to calculate total importance
        while(!q.isEmpty()){
            int empId = q.poll();
            
            List<Integer> subordinates = map.get(empId).subordinates;
            int imp = map.get(empId).importance;
            totaImportance += imp;
            
            for(int i : subordinates)
                q.offer(i);
        }
        
        return totaImportance;
    }
}