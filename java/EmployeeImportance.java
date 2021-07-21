// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
used HashMap to store all Employee Ids as key and values as Emplpoyee object, so that we can get id's Employee in O(1) and then do dfs for each of its subordinates to calculate the importance
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
    Map<Integer, Employee> map;

    public int getImportance(List<Employee> employees, int id) {
        if (employees == null) return -1;
        map = new HashMap();
        for (Employee e : employees) {
            map.put(e.id, e);
        }
        return dfs(id);

    }

    private int dfs(int id) {
        Employee employee = map.get(id);
        int res = employee.importance;
        for (Integer subId : employee.subordinates) {
            res += dfs(subId);
        }
        return res;
    }

}