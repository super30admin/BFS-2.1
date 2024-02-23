import java.util.HashMap;
import java.util.List;
import java.util.Map;

// TC - O(V+E) -> Here V=E since an employee reports to only one manager
// SC - O(V+E)

public class EmployeeImportanceDFS {
    // Definition for Employee.
    class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;
    };

    class Solution {
        private int importance;

        public int getImportance(List<Employee> employees, int id) {
            Map<Integer, Employee> idToEmployeeMap = new HashMap<>();
            for (Employee emp : employees) {
                idToEmployeeMap.put(emp.id, emp);
            }
            dfs(idToEmployeeMap, id);
            return importance;
        }

        private void dfs(Map<Integer, Employee> idToEmployeeMap, int empId) {
            Employee emp = idToEmployeeMap.get(empId);
            importance += emp.importance;

            for (int subordinate : emp.subordinates) {
                dfs(idToEmployeeMap, subordinate);
            }
        }
    }
}
