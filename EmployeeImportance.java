// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};

class Solution {
    Employee[] map;

    public int getImportance(List<Employee> employees, int id) {
        map = new Employee[2001];

        for (Employee emp : employees) {
            map[emp.id] = emp;
        }

        return helperDfs(map[id]);
        // return helperBfs(map[id]);
    }

    private int helperDfs(Employee employee) {
        if (employee == null) {
            return 0;
        }

        int result = 0;
        result += employee.importance;

        for (int i : employee.subordinates) {
            Employee emp = map[i];
            if (emp != null) {
                result += helperDfs(emp);
            }
        }

        return result;
    }

    private int helperBfs(Employee employee) {
        if (employee == null) {
            return 0;
        }

        Queue<Employee> q = new LinkedList<>();
        q.offer(employee);
        int result = 0;
        while (!q.isEmpty()) {
            Employee emp = q.poll();

            result += emp.importance;

            for (Integer i : emp.subordinates) {
                Employee emp1 = map[i];
                if (emp1 != null) {
                    q.offer(emp1);
                }
            }
        }
        return result;
    }
}