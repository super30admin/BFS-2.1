// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO


import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class EmployeeImportance {
    class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;
    }
    private HashMap<Integer, Employee> map;
    private int result;
    public int getImportance(List<Employee> employees, int id) {
        map = new HashMap<>();
        result = 0;
        if(employees == null) return result;
        for(Employee emp : employees){
            map.put(emp.id, emp);
        }
        Queue<Integer> q = new LinkedList<>();
        q.add(id);
        while(!q.isEmpty()){
            int empId = q.poll();
            Employee emp = map.get(empId);
            result += emp.importance;
            for(int subId : emp.subordinates){
                q.add(subId);
            }
        }
        return result;
    }
}