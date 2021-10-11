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
        
        HashMap<Integer, Employee> map = new HashMap<>();
        
        int result=0;
        
        if(employees == null || employees.size() == 0) return 0;
        
        Queue<Integer> q = new LinkedList<>();
        for( Employee e: employees){
            map.put(e.id, e);
        }
        q.add(id);
        
        while(!q.isEmpty()){
            int eid = q.poll();
            Employee e = map.get(eid);
        
            result += e.importance;
        
            for(int subId: e.subordinates){
                q.add(subId);
            }
        
        }
        return result;
    
   
}
}

//TC O(N), SC O(N)
