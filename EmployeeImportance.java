/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

// Time Complexity : O(V+E) where V is no of employees and E is number of edges connected between them
// Space Complexity :  O(V+E) where V is no of employees and E is number of edges connected between them
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Couldn't think until discussed in class.


import java.util.*;

class Solution {
    HashMap<Integer, Employee> map;
    public int getImportance(List<Employee> employees, int id) {
        int result = 0;
        map = new HashMap<>();
        for(Employee e: employees){
            map.put(e.id, e);
        }
        Queue<Integer> q = new LinkedList<>();
        q.add(id);
        while(!q.isEmpty()){
            int eid = q.poll();
            Employee e = map.get(eid);
            result+=e.importance;
            for(int subid : e.subordinates){
                q.add(subid);
            }
        }
        return result;
    }
}

class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};