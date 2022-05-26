// Time Complexity : O(N), N is the number of employees
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
public class EmployeeImportance {
    Map<Integer, Employee> emap;
    public int getImportance(List<Employee> employees, int id) {
        emap = new HashMap();
        for (Employee e: employees) emap.put(e.id, e);
        return dfs(id);
    }

    public int dfs(int eid) {
        Employee employee = emap.get(eid);
        int ans = employee.importance;
        for (Integer subid: employee.subordinates)
            ans += dfs(subid);
        return ans;
    }
}
