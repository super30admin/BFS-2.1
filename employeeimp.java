// TC: O(n)
// SC: O(n)

/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/
class Solution {
    
    HashMap<Integer,Employee> map;
    int totalimportance;
    public int getImportance(List<Employee> employees, int id) {
        if(employees == null || employees.size() ==0) return 0;
        
        map = new HashMap<>();
        for(Employee e : employees){
            map.put(e.id, e);
        }
        
        //BFS
        Queue<Integer> q = new LinkedList<>();
        q.add(id);
        
        while(!q.isEmpty()){
            int curr = q.poll();
            Employee emp = map.get(curr);
            totalimportance += emp.importance;
            if(emp.subordinates == null) continue;
            for(int sub : emp.subordinates){
                q.add(sub);
            }
        }
        return totalimportance;
        
    }
}