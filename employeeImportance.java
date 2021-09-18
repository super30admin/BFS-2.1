// Time Complexity : O(v+e)
// Space Complexity : O(v)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

// BFS
/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

// BFS time complexity: O(v+e) space complexity: O(v)
class Solution {
    public int getImportance(List<Employee> employees, int id) {
        int result = 0;
        HashMap<Integer, Employee> map = new HashMap<>();
        for(Employee e: employees){
            map.put(e.id, e);
        }
        Queue<Integer> q = new LinkedList<>();
        q.add(id);
        while(!q.isEmpty()){
            int eid = q.poll();
            Employee e = map.get(eid);
            result += e.importance;
            for(int subid: e.subordinates){
                q.add(subid);
            }
        }
        return result;
    }
}

// ******************************************
// Time Complexity : O(v+e)
// Space Complexity : O(v)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

// DFS

/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

// DFS time complexity: O(v+e) space complexity: O(v)
class Solution {
    int result = 0;
    HashMap<Integer, Employee> map;
    public int getImportance(List<Employee> employees, int id) {
        map = new HashMap<>();
        for(Employee e: employees){
            map.put(e.id, e);
        }
        dfs(id);
        return result;
    } 
    private void dfs(int eid){
        // logic
        Employee e = map.get(eid);
        result += e.importance;
        for(int subid: e.subordinates){
            dfs(subid);
        }
    }
}