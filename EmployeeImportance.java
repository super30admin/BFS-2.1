//https://leetcode.com/problems/employee-importance

/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
    int result;
    public int getImportance(List<Employee> employees, int id) {
        result = 0;
        Map<Integer,Employee> map = new HashMap<>();
        for(Employee e : employees){
            map.put(e.id,e);
        }
        dfs(id,map);
        return result;
    }
    private void dfs(int id, Map<Integer,Employee> map){
        
        //logic
        Employee e = map.get(id);
        result += e.importance;
        for(int i : e.subordinates){
            dfs(i,map);
        }
    }
}
-----------------------------------------------------------
/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
    public int getImportance(List<Employee> employees, int id) {
        int result = 0;
        Map<Integer,Employee> map = new HashMap<>();
        for(Employee e : employees){
            map.put(e.id,e);
        }
        Queue<Integer> q = new LinkedList<>();
        q.add(id);
        while(!q.isEmpty()){
            int cid = q.poll();
            Employee ce = map.get(cid);
            result += ce.importance;
            for(int i : ce.subordinates){
                q.add(i);
            }
        }
        return result;
    }
}
