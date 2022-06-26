/* Time Complexity : O(n) or O(V+E), n is no of Employee objects
 * Space Complexity : O(n), for HashMap
 * Did this code successfully run on Leetcode : Yes
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
    public int getImportance(List<Employee> employees, int id) {
        int result = 0;
        map = new HashMap<>();
        for(Employee e : employees){
            map.put(e.id, e);
        }
        Queue<Integer> q = new LinkedList<>();
        q.add(id);
        while(!q.isEmpty()){
            int eid = q.poll();
            Employee e = map.get(eid);
            result += e.importance;
            for(int subId: e.subordinates){
                q.add(subId);
            }
        }
        return result;
    }
}
