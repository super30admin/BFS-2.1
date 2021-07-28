// Time Complexity : O(N) Where N is no of employees
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Iterative
class Solution {
    public int getImportance(List<Employee> employees, int id) {

        Map<Integer, Employee> map = new HashMap<>();

        for(Employee e: employees) {
            map.put(e.id, e);
        }

        int importance = 0;
        Queue<Employee> queue = new LinkedList<>();
        Employee temp = map.get(id);
        queue.add(temp);

        while(!queue.isEmpty()) {

            Employee emp = queue.poll();
            importance += emp.importance;
            for(int ids: emp.subordinates) {
                queue.add(map.get(ids));
            }

        }
        return importance;
    }
}

// Recursive
class Solution {
    Map<Integer, Employee> emap;
    public int getImportance(List<Employee> employees, int queryid) {
        emap = new HashMap();
        for (Employee e: employees) emap.put(e.id, e);
        return dfs(queryid);
    }
    public int dfs(int eid) {
        Employee employee = emap.get(eid);
        int ans = employee.importance;
        for (Integer subid: employee.subordinates)
            ans += dfs(subid);
        return ans;
    }
}