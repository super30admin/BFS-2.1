// TC : O(n) 
// SC: O(n)

// Approach: Create a hashMap of idToEmployee. We create a queue of Employees.
// We add the given id to the queue. Iterating over the queue, we pop from the
// queue and store it as e. We iterate over the subordinates of this e and add them 
// to the queue. We keep updating a counter every time we remove an employee
// from the queue.

// LC- 690. Employee Importance

import java.util.*;

class Employee {
  public int id;
  public int importance;
  public List<Integer> subordinates;
};

public class EmployeeImportance {
  public int getImportance(List<Employee> employees, int id) {
    HashMap<Integer, Employee> map = new HashMap<>();

    for (Employee e : employees) {
      map.put(e.id, e);
    }

    Queue<Employee> queue = new LinkedList<>();
    int totalImp = 0;

    queue.add(map.get(id));

    while (!queue.isEmpty()) {
      Employee e = queue.remove();
      totalImp = totalImp + e.importance;

      for (int subId : e.subordinates) {
        queue.add(map.get(subId));
      }
    }

    return totalImp;
  }
}
