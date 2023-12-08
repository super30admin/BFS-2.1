/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

// Time Complexity : DP: O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/**
 * Use DFS. Store all employees in a hashmap against their id. If this is not done, then we'll have to iterate List of employee each time to find
 * the employee object. Now call dfs and calculate the result.
 */

class Solution {

    HashMap<Integer, Employee> map;

    public int getImportance(List<Employee> employees, int id) {

        this.map = new HashMap<>();

        for(Employee e: employees)
            map.put(e.id, e);

        return dfs(id);
    }

    private int dfs(int id) {

        Employee e = map.get(id);
        int result = e.importance;

        for(Integer i: e.subordinates)
            result += dfs(i);

        return result;
    }
}