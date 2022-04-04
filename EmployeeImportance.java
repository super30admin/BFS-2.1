/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class EmployeeImportance {
    public int getImportance(List<Employee> employees, int id) {
        HashMap<Integer,Employee> map = new HashMap<>();
        for(Employee e : employees){
            map.put(e.id,e);
        }
        Queue<Integer> q = new LinkedList<>();
        q.add(id);
        int total = 0;
        while(!q.isEmpty()){
            int currId = q.poll();
            Employee curr = map.get(currId);
            total+=curr.importance;
            for(int eid : curr.subordinates){
                q.add(eid);
            }
        }
        return total;
    }
}
