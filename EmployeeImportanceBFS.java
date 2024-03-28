
// TC - O(V+E) -> Here V=E since an employee reports to only one manager
// SC - O(V+E)
// Working on Leetcode - Yes
// Any challenges while coding - No

// Approach BFS: Take Employee - Go level by level for subordinate and sum them up.


/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

//This is graph problem
class Solution {
    public int getImportance(List<Employee> employees, int id) {
        int result =0;
        if(employees == null) return 0;
        Map<Integer, Employee> map = new HashMap<Integer,Employee>();
        //        Queue<Employee> q = new LinkedList<>();
        Queue<Integer> q = new LinkedList<>();


        for(Employee el : employees){ //O(n) ==>  n = e = vertex = employee
            map.put(el.id, el);            
        }

        q.add(id);

        while(!q.isEmpty()){
            int curr_id = q.poll();
            Employee el = map.get(curr_id);
            result += el.importance;

            for(int i=0; i<el.subordinates.size(); i++){
                // Employee subordinate = map.get(el.subordinates.get(i));
                // result += subordinate.importance;
                q.add(el.subordinates.get(i));
            }
        }

        return result;
    }
}