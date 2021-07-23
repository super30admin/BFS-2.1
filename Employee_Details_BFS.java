// Rotting Oranges - https://leetcode.com/problems/rotting-oranges
// Time Complexity - O(MN)
// Space Complexity - O(MN)
// Run on leetcode? : Yes
// Any Porblems? : No

/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
    public int getImportance(List<Employee> employees, int id) {
        if(employees == null || employees.size() == 0) return 0;
        
        // building hashmap
        Map<Integer, Employee> empMap = new HashMap<>();
        for(Employee emp: employees)
            empMap.put(emp.id, emp);
        
        Queue<Integer> queue = new LinkedList<>();
        queue.add(id);
        
        // importance of employee
        int result = 0;
        
        while(!queue.isEmpty()){
            int curr = queue.poll();
            
            Employee employee = empMap.get(curr);
            result += employee.importance;
            // adding subordinates to the queue for processing
            if(employee.subordinates != null){
                for(int subordinate: employee.subordinates)
                    queue.add(subordinate);
            }
        }
            return result;
    }
}