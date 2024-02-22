// v = e as each vertex is connected to only one other
// Time complexity: O(n) where n = number of employees
// Space complexity: O(n)
//Approach: BFS starting from the given id and then traversing
// subordinates till there are no subordinates left

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};

class EmployeeImportance {
    public int getImportance(List<Employee> employees, int id) {
        // employees-id to employee object for O(1) retrieval
        Map<Integer, Employee> map = new HashMap();
        for (Employee e : employees) {
            map.put(e.id, e);
        }

        Queue<Integer> queue = new LinkedList();
        queue.add(id);

        int importance = 0;
        // add to importance and then process the subordinates
        while (!queue.isEmpty()) {
            Employee current = map.get(queue.poll());
            importance += current.importance;

            for (int sub : current.subordinates) {
                queue.add(sub);
            }
        }

        return importance;
    }
}