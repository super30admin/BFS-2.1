/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/
//DFS

// Time Complexity :O(n) --> no.of employees
// Space Complexity : O(n) --> recursiion stack and Hashmap
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :NO
class Solution {
    HashMap<Integer,Employee> map;
    int res=0;
    public int getImportance(List<Employee> employees, int id) {
        map= new HashMap<>();
        for(Employee e:employees){
            map.put(e.id, e);
        }
        helper(employees, id, map);
        return res;
    }

    public void helper(List<Employee> employees, int id, HashMap<Integer,Employee> map){
       Employee e = map.get(id);
       res+= e.importance;
       for(int i : e.subordinates){
               helper(employees,i,map);
     }

    }
}
// Time Complexity : O(n) --> no.of employees
// Space Complexity : O(n) --> Queue and Hashmap
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : NO

//BFS
    class Solution {
    HashMap<Integer,Employee> map;
    public int getImportance(List<Employee> employees, int id) {
        map= new HashMap<>();
        for(Employee e:employees){
            map.put(e.id, e);
        }
        Queue<Integer> queue = new LinkedList<>();

        queue.add(id);
         int res =0;
        while(!queue.isEmpty()){
            int curr = queue.poll();
            Employee e = map.get(curr);
            res+= e.importance;
            for(int i : e.subordinates){
                queue.add(i);
            }
        }
        return res;
    }
}
