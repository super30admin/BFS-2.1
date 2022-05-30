import java.util.*;

class Solution {
    // BFS Solution
    // Time complexity is O(V+E)
    // Space complexity is O(V+E)
    // This solution is submitted on leetcode with zero errors
    class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;
    };
    public int getImportance(List<Employee> employees, int id) {
        // Edge case
        if(employees.size()==0 || employees == null)
            return -1;
        // Creating adjacency list
        HashMap<Integer, Employee> map = new HashMap<>();
        for(Employee emp :employees){
            map.put(emp.id,emp);
        }
        Queue<Integer> q = new LinkedList<>();
        q.add(id);
        int imp = 0;
        while(!q.isEmpty()){
            int temp = q.poll();
            Employee emp = map.get(temp);
            imp += emp.importance;
            if(emp.subordinates.size()!=0){
                for(int sub: emp.subordinates){
                    q.add(sub);
                }
            }
        }
        return imp;
    }
}