// Time Complexity : O(n), n is the no of employees
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach in three sentences only
/*
 * DFS solution
 * we need hashmap to store employee id with their employee object.
 * we iterate through a employee add its importance to result and then add a recursive call to add importance of the subordinates
*/

/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/
class Solution {
    HashMap<Integer, Employee> map;
    int result;

    public int getImportance(List<Employee> employees, int id) {
        map = new HashMap<>();
        for (Employee e : employees) {
            map.put(e.id, e);
        }

        dfs(id);

        return result;
    }

    private void dfs(int id) {
        // logic

        Employee e = map.get(id);

        result += e.importance;

        for (int subid : e.subordinates) {
            dfs(subid);
        }
    }
}

// Time Complexity : O(V+E)
// Space Complexity : O(V+E)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach in three
// sentences only
/*
 * BFS solution
 * we need hashmap to store employee id with their employee object.
 * Add id to the queue. Run till queue is not empty, we get employee from the
 * map for the id and add the importance to result
 * Add the subordinates id to the queue for that id
 */
class Solution {
    public int getImportance(List<Employee> employees, int id) {
        Queue<Integer> q = new LinkedList<>();
        HashMap<Integer, Employee> map = new HashMap<>();

        for (Employee e : employees) {
            map.put(e.id, e);
        }
        int result = 0;

        q.add(id);

        while (!q.isEmpty()) {
            int empId = q.poll();
            Employee e = map.get(empId);
            result += e.importance;

            for (int sub : e.subordinates) {
                q.add(sub);
            }
        }

        return result;
    }
}