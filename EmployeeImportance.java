package DataStructure.BFS_DFS;

//BFS

// Time Complexity : O(V+E)
// Space Complexity : O(V+E)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};


class Solution {
    public int getImportance(List<Employee> employees, int id) {
        Queue<Integer> q = new LinkedList<>();
        //Start from the id we need to calculate importance
        q.add(id);

        //map id to the employees object
        HashMap<Integer, Employee> map = new HashMap<>();
        for(Employee e: employees){
            map.put(e.id, e);
        }

        int result = 0;

        while(!q.isEmpty()){
            int size = q.size();
            while(size>0){
                int eid = q.poll();
                size--;

                Employee temp = map.get(eid);
                result+=temp.importance; //add results (importance) from that employee

                for(int sub: temp.subordinates){ //add their subordinates to the queue
                    q.add(sub);
                }
            }
        }

        return result;
    }
}

