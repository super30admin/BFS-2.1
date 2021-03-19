/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

// TC - O(n), SC - O(n)

class Solution {
    public int getImportance(List<Employee> employees, int id) {
        // sanity check
        if(employees == null || employees.size() == 0){
            return 0;
        }
        // Iniitalizing variable to store importance
        int totalImp = 0;
        // Initializing queue and hashmap
        Queue<Integer> q = new LinkedList<>();
        Map<Integer, Employee> map = new HashMap<>();
        // add id as key and employee as value in hashmap
        for(Employee emp : employees){
            map.put(emp.id, emp);
        }
        // add id into queue
        q.add(id);
        // Iterate while q is not empty, from map get value of employee, importance and subordinates, we will add subordinates to queue again 
        while(!q.isEmpty()){
            int empId = q.poll();
            
            List<Integer> subord = map.get(empId).subordinates;
            int importance = map.get(empId).importance;
            totalImp += importance;
            
            for(int sub : subord){
                q.add(sub);
            }
        }
        // return totalImp
        return totalImp;
    }
}