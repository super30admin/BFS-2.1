// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
import java.util.*;
class EmployeeImportanceSolution {
    // Definition for Employee.
    class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;
    };
    public int getImportance(List<Employee> employees, int id) {
        if(employees == null || employees.size()==0)
            return 0;
        int importance = 0;
        HashMap<Integer, Employee> map = new HashMap<>();
        for(Employee employee: employees) {
            map.put(employee.id, employee);
        }
        Queue<Employee> q = new LinkedList<>();
        q.add(map.get(id));
        while(!q.isEmpty()) {
            Employee employee = q.poll();
            importance = importance + employee.importance;
            for(Integer subordinate : employee.subordinates ) {
                q.add(map.get(subordinate));
            }
        }
        return importance;
    }
}