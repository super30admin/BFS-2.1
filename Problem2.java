// Time Complexity : O(n)
// Space Complexity : O(n) 
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :

import java.util.*;

class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
}

public class Problem2 {
    public int getImportance(List<Employee> employees, int id) {
        int result = 0;
        Queue<Integer> q = new LinkedList<>();
        Map<Integer, Employee> map = new HashMap<>();

        for (Employee e : employees) {
            map.put(e.id, e);
            if (e.id == id) {
                q.add(e.id);
            }
        }

        while (!q.isEmpty()) {
            int currId = q.poll();
            Employee curr = map.get(currId);
            result += curr.importance;
            List<Integer> subordinates = curr.subordinates;
            if (subordinates != null && subordinates.size() > 0) {
                for (Integer i : subordinates) {
                    q.add(i);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        // Example Usage
        List<Employee> employees = new ArrayList<>();

        // Create Employee objects and add them to the list
        Employee e1 = new Employee();
        e1.id = 1;
        e1.importance = 5;
        e1.subordinates = Arrays.asList(2, 3);

        Employee e2 = new Employee();
        e2.id = 2;
        e2.importance = 3;
        e2.subordinates = Collections.emptyList();

        Employee e3 = new Employee();
        e3.id = 3;
        e3.importance = 2;
        e3.subordinates = Collections.emptyList();

        employees.add(e1);
        employees.add(e2);
        employees.add(e3);

        Problem2 solution = new Problem2();
        int result = solution.getImportance(employees, 1);

        // Print the result
        System.out.println("Total Importance: " + result);
    }
}
