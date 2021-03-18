/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/
//TC: O(no.of employees)
//SC: O(n)i.e O(2n)
class Solution {
    public int getImportance(List<Employee> employees, int id) {
        if(employees == null || employees.size() == 0) return 0;
        
        int totalImp = 0;
        
        Queue<Integer> queue = new LinkedList<>();
        HashMap<Integer, Employee> map = new HashMap<>();
        
        for(Employee emp: employees){
            map.put(emp.id,emp);
        }
        queue.add(id);
        while(!queue.isEmpty()){
            int empId = queue.poll();
            List<Integer> subord = map.get(empId).subordinates;
            
            int imp = map.get(empId).importance;
            totalImp += imp;
            
            for(int sub:subord){
                queue.add(sub);
            }
        }
        return totalImp;
    }
}