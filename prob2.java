// Time Complexity : O(N) or O(V+E) same for bfs, dfs
// Space Complexity : O(V) same for bfs, dfs
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : used length on arraylist instead of size

// Explain your approach:
// in both approaches, keep a map of emp id: employee object
// bfs - push given id into queue, while q is not empty, get employee e from get, add its importance to result
// and push the subordinates of e into q

// dfs - similar to bfs, but add employee e's importance to result and, then iterate over e's subordinates, 
// add the result of dfs calls to result and return result

import java.util.*;

class Solution {
    class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
}
    public int getImportance(List<Employee> employees, int id) {
        if(employees == null || employees.size() == 0) return 0;
        Map<Integer, Employee> map = new HashMap<>();
        Queue<Integer> q = new LinkedList<>();
        for(Employee e: employees){
            map.put(e.id, e);
        }
        q.add(id);
        int result = 0;
        while(!q.isEmpty()){
            int curr = q.poll();
            Employee e =  map.get(curr);
            result += e.importance;
            for(int sub: e.subordinates){
                q.add(sub);
            }
        }
        return result;

        
    }
}

/*
 DFS Solution

 class Solution {
    int result;
    Map<Integer, Employee> map;
    public int getImportance(List<Employee> employees, int id) {
        if(employees == null || employees.size() == 0) return 0;
        map = new HashMap<>();
        for(Employee e: employees){
            map.put(e.id, e);
        }
        dfs(id);
        return result;
    }

    private void dfs(int id){
        // base
        if(id == 0) return;

        //logic
        Employee e = map.get(id);
        result += e.importance;
        for(int sub: e.subordinates){
            dfs(sub);
        }
    }
}
 */
