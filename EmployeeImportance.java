/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/
/**
This Java solution calculates the total importance of an employee and their subordinates:
Create a HashMap (map) to quickly access an employee by their ID.
Use a breadth-first search (BFS) approach with a queue (q) to traverse the hierarchy, adding the importance of each employee and enqueuing their subordinates.
Return the accumulated importance as the result.
Time, space complexity - O(N)
 */

 class Solution {
    public int getImportance(List<Employee> employees, int id) {
        HashMap<Integer, Employee> map = new HashMap<>();
        for(Employee e : employees){
            map.put(e.id, e);
        }
        
        Queue<Integer> q = new LinkedList<>();
        q.add(id);
        int res =0;
        while(!q.isEmpty()){
            int eid = q.poll();
            Employee e = map.get(eid);
            res += e.importance;
            for(int subid : e.subordinates){
                q.add(subid);

            }
        }
        return res;
    }
}