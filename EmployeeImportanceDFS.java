// Time Complexity : O(v+e) = o(n), where v is vertices and e is edges
// Space Complexity : O(n), size of HashMap
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :    No
package bfs21;

import java.util.*;

public class EmployeeImportanceDFS {

    int res = 0;
    HashMap<Integer, Employee> map;

    public int getImportance(List<Employee> employees, int id) {
        if (employees == null || employees.size() == 0) {
            return 0;
        }
        map = new HashMap<>();
        for (Employee e : employees) {
            map.put(e.id, e);
        }
        dfs(id);
        return res;
    }

    private void dfs(int id) {
        Employee e = map.get(id);
        res += e.importance;
        for (int subId : e.subordinates) {
            dfs(subId);
        }

    }
}
