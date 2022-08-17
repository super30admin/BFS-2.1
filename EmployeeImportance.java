// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach

//690. Employee Importance (Medium) - https://leetcode.com/problems/employee-importance/
// Time Complexity : O(n), Space Complexity : O(n)
class Solution {
    public int getImportance(List<Employee> employees, int id) {
        HashMap<Integer, Employee> map = new HashMap<>();
        
        for (Employee employee : employees) {
            map.put(employee.id, employee);
        }
        
        int importance = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(id);
        
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            Employee emp = map.get(curr);
            importance += emp.importance;
            
            for (int subordinate : emp.subordinates) {
                queue.add(subordinate);
            }
        }
        
        return importance;
    }
}