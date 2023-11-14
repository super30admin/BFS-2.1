// TC : O(n) // n = employees.length
// SC : O(n)

package S30_Codes.BFS_2_1;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};

class EmployeeImportance {
    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> empMap = new HashMap<>();
        for(Employee employee : employees){
            empMap.put(employee.id, employee);
        }
        return DFS(empMap, id);
    }

    private int DFS(Map<Integer, Employee> empMap, int idx){
        Employee employee = empMap.get(idx);
        int importance = employee.importance;
        List<Integer> subordinates = employee.subordinates;

        for(int i=0; i<subordinates.size(); i++){
            int subId = subordinates.get(i);
            importance += DFS(empMap, subId);
        }
        return importance;
    }
}