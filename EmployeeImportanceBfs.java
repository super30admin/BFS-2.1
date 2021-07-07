// Time Complexity : O(n)
// Space Complexity : O(n)

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
        if(employees == null || employees.size() == 0)
            return 0;
        int result = 0;
        Map<Integer,Employee> map = new HashMap<>();
        for(Employee emp:employees)
            map.put(emp.id, emp);
        Queue<Integer> q = new LinkedList<>();
        q.add(id);
        while(!q.isEmpty()){
            int eId = q.poll();
            result += map.get(eId).importance;
            for(int empId:map.get(eId).subordinates){
                q.add(empId);
            }
        }
        return result;
    }
}