package BFS21;
// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes


import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class EmployeeImportance {
    HashMap<Integer, Employee> map;
    int total = 0;
    public int getImportance(List<Employee> employees, int id) {
        map = new HashMap<>();
        for(Employee emp : employees){
            map.put(emp.id, emp);
        }
        Queue<Integer> q = new LinkedList<>();
        q.add(id);
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0; i<size; i++){
                int e_id = q.poll();
                total += map.get(e_id).importance;
                List<Integer> subs = map.get(e_id).subordinates;
                if(subs != null){
                    for(int emp_id : subs){
                        q.add(emp_id);
                    }
                }
            }
        }
        return total;
    }
}

class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
