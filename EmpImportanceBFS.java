// Time Complexity : O(v+e) = o(n), where v is vertices and e is edges
// Space Complexity : O(n), size of HashMap
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :    No
package bfs21;

import java.util.*;

class Employee {

    public int id;
    public int importance;
    public List<Integer> subordinates;
};

public class EmpImportanceBFS {

    public int getImportance(List<Employee> employees, int id) {
        if (employees == null || employees.size() == 0) {
            return 0;
        }
        int res = 0;
        HashMap<Integer, Employee> map = new HashMap<>();
        Queue<Integer> q = new LinkedList<>();
        for (Employee e : employees) {
            map.put(e.id, e);
        }
        q.add(id);
        while (!q.isEmpty()) {
            int eId = q.poll();
            Employee e = map.get(eId);
            res += e.importance;
            for (int subId : e.subordinates) {
                q.add(subId);
            }

        }
        return res;
    }
}
