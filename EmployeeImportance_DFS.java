/* Time Complexity: O(n) or O(V+E), n is no of Employee objects
 * Space Complexity: O(n), for HashMap
 * Did this code successfully run on Leetcode : yes
 * Any problem you faced while coding this : No
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
        for(Employee e : employees){
            map.put(e.id, e);
        }
        dfs(id);
        return result;
    }
    private void dfs(int eid){
        //base - we dont need a base case as for() is taking care of it
        //logic
        Employee e = map.get(eid);
        result += e.importance;
        for(int subId: e.subordinates){
            dfs(subId);
        }
    }
}
