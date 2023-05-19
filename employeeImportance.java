// Time Complexity : O(n)
// Space Complexity : O(n) for the Queue and HashMap
// Did this code successfully run on Leetcode : Yes

/*
 * Approach:
 * We use a BFS approach to find the importance of employee with given ID.
 * To make the employee ID lookup efficient, we use a HashMap and store the
 * pertinent values in it.
 * While performing BFS, we search for all the subordinates at each level and
 * add them to the Queue until we exhaust all subordinates, all the while
 * summing up the importance. Then, we return the importance as the result.
 */

/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

import java.util.Queue;
import java.util.List;
import java.util.LinkedList;
import java.util.HashMap;

class Solution {
    public int getImportance(List<Employee> employees, int id) {
        if(employees == null || employees.size() == 0) {
            return 0;
        }

        HashMap<Integer, Employee> m = new HashMap<>();
        for(Employee e : employees) {
            m.put(e.id, e);
        }

        Queue<Integer> q = new LinkedList<>();
        int total = 0;
        q.add(id);

        while(!q.isEmpty()) {
            // no need to track size since we don't depend on level
            // order traversal
            int curr = q.poll();
            Employee e = m.get(curr);
            total += e.importance;
            List<Integer> subs = e.subordinates;
            if(subs == null) {
                continue;
            }
            for(int s : subs) {
                q.add(s);
            }
        }

        return total;
    }
}