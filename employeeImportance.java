// https://leetcode.com/problems/employee-importance/

// Time Complexity: O(Row + Column)
// Space Complexity: O(n)
// Did this code successfully run on Leetcode: Yes
// Any problem you faced while coding this: Took reference from lecture

class Solution {
    public int getImportance(List<Employee> employees, int id) {
        int total = 0;
        Map<Integer, Employee> map = new HashMap<>();
        
        for (Employee employee : employees) {
            map.put(employee.id, employee);
        }
        
        Queue<Employee> queue = new LinkedList<>();
        
        queue.offer(map.get(id));
        
        while (!queue.isEmpty()) {
            Employee current = queue.poll();
            total += current.importance;
            for (int subordinate : current.subordinates) {
                queue.offer(map.get(subordinate));
            }
        }
        return total;
    }
}