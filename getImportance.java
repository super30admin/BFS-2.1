// Time Complexity : o(n) n is no of edges
// Space Complexity :o(n) where n is the diameter of tree
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
    public int getImportance(List<Employee> employees, int id) {
        Queue<Integer> q = new LinkedList<>();
        HashMap<Integer, Employee> map = new HashMap<>();
        int res = 0;
        for(Employee curr: employees)
        {
            map.put(curr.id, curr);
        }
        q.add(id);
        while(!q.isEmpty())
        {
            int curr = q.poll();
            Employee emp = map.get(curr);
            res += emp.importance;
            for(int subs: emp.subordinates)
            {
                q.add(subs);
            }
        }
        return res;
    }
}