/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/
//BFS approach
// Time complexity: O(N), N- number of employees
// Space complexity: O(N)
class Solution {
    public int getImportance(List<Employee> employees, int id) {
        
        Map<Integer, Employee> idToEmp = new HashMap<>();
        
        for(Employee e: employees){
            idToEmp.put(e.id,e);
        }
        
        Queue<Employee> que = new LinkedList<>();
        que.add(idToEmp.get(id));
        int imp=0;
        while(!que.isEmpty()){
            Employee cur = que.remove();
            imp+=cur.importance;
            
            // for(Integer subid: cur.subordinates){
            //     que.add(idToEmp.get(subid));
            // }
            for(int i=0;i<cur.subordinates.size();i++){
                que.add(idToEmp.get(cur.subordinates.get(i)));
            }
            
        }
        return imp;
        
        
    }
}
//DFS approach
// Time complexity: O(N), N- number of employees
// Space complexity: O(N)
class Solution {
    private Map<Integer, Employee> idToEmp = new HashMap<>();
    public int getImportance(List<Employee> employees, int id) { 
        
        for(Employee e: employees)
            idToEmp.put(e.id,e);
        
        return dfs(id);
    }
    
    public int dfs(int id){
        Employee emp = idToEmp.get(id);
        int ans = emp.importance;
        
        for(Integer sub: emp.subordinates){
            ans+=dfs(sub);
        }
        return ans;
        
    }
}
