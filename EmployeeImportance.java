// Time Complexity : O(n)  n is the no. of employees
// Space Complexity : O(n) for queue
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Create a map of ids and employees
// Create a queue and add the given id
// Unitll queue is not empty find the suordinates and add them to queue
// Simultaneously keep adding the importance values

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
        int ans = 0;
        Map<Integer, Employee> hm = new HashMap<>();
        Queue<Integer> q = new LinkedList<>();
        for(Employee emp: employees){
            hm.put(emp.id, emp);
        }
        q.add(id);
        while(!q.isEmpty()){
            int eid = q.poll();
            Employee emp = hm.get(eid);
            ans += emp.importance;
            for(int x: emp.subordinates){
                q.add(x);
            }
        }
        return ans;
    }
}