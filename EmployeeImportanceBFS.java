import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

// TC - O(V+E) -> Here V=E since an employee reports to only one manager
// SC - O(V+E)

public class EmployeeImportanceBFS {
    // Definition for Employee.
    class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;
    };

    class Solution {
        public int getImportance(List<Employee> employees, int id) {
            Map<Integer, Employee> idToEmployeeMap = new HashMap<>();
            Queue<Integer> queue = new LinkedList<>();
            queue.add(id);
            int importance = 0;

            for (Employee emp : employees) {
                idToEmployeeMap.put(emp.id, emp);
            }

            while (!queue.isEmpty()) {
                int empId = queue.poll();
                Employee emp = idToEmployeeMap.get(empId);

                importance += emp.importance;
                for (int subordinate : emp.subordinates) {
                    queue.add(subordinate);
                }
            }

            return importance;
        }
    }
}
