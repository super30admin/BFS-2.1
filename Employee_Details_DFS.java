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
    Map<Integer, Employee> empMap;
    int result;
    public int getImportance(List<Employee> employees, int id) {
        if(employees == null || employees.size()==0) return 0;
        
        // building hashmap
        empMap = new HashMap<>();
        for (Employee emp : employees)
            empMap.put(emp.id, emp);
        
        helper(id);
        return result;
    }
    
    private void helper(int id){
        // base
        // logic
        Employee emp = empMap.get(id);
        result += emp.importance;
        for(int subordinate:emp.subordinates){
            helper(subordinate);
        }
    }
}