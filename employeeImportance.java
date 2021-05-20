/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

///// DFS Approach
class Solution {
    int result;
    HashMap<Integer, Employee> map;
    public int getImportance(List<Employee> employees, int id) {
        if(employees == null || employees.size() == 0) return 0;
        map = new HashMap<>();
        for(Employee e : employees){
            map.put(e.id, e);
        }
        dfs(id);
        return result;
    }
    
    private int dfs(int id ){
        
        Employee e = map.get(id);
        result += e.importance;
        for(int sub : e.subordinates){
            dfs(sub);
        }
        return result;
    }
    
}

------------------------------------------------------------------------
//BFS approach
  
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
        if(employees == null || employees.size() == 0) return 0;
        int result = 0;
        //create hashmap
        HashMap<Integer, Employee> map = new HashMap<>();;
        Queue<Integer> q = new LinkedList<>();
        //add employee id and employee in hashmap
        for(Employee e : employees){
            map.put(e.id, e);
        }
        //add the first id in the queue
        q.add(id);
        
        while(!q.isEmpty()){
            int eid = q.poll();
            Employee e = map.get(eid);
            result += e.importance;
            for(int sub : e.subordinates){
                q.add(sub);
            }
        }
        
        return result;
    }
    
}
