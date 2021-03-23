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
        if(employees == null || employees.size() == 0)
            return result;
        
        HashMap<Integer ,Employee> map = new HashMap<>();
        for(Employee e : employees){
            map.put(e.id, e);
        }
        Queue<Integer> q = new LinkedList<>();
        q.add(id);
        while(!q.isEmpty()){
            int eid =q.poll();
            Employee e = map.get(eid);
            result += e.importance;
            for(int subId : e.subordinates){
                q.add(subId);
            }
        }
        return result;
    }
}