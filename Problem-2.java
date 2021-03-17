Time Complexity : O(n)
Space Complexity : O(n)

/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
    int result=0;
    Queue<Integer>queue =new LinkedList<>();
    public int getImportance(List<Employee> employees, int id) {
        queue.offer(id);
        while(!queue.isEmpty()){
            for(int i=0;i<queue.size();i++){
                int empid=queue.poll();
                getSubordinate(employees,empid);
            }
        }
        return result;
    }
    
    public void getSubordinate(List<Employee> employees, int id){
        for(Employee emp:employees){
            if(emp.id==id){
                result+= emp.importance;
                for(Integer i:emp.subordinates){
                    queue.offer(i);
                }
            }
        }
    }
}




/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
    Map<Integer, Employee> map = new HashMap<>();
    public int getImportance(List<Employee> employees, int id) {
        for(Employee emp : employees)
            map.put(emp.id, emp);
        return helper(id);
    }
    
    public int helper(int empid){
        Employee employee = map.get(empid);
        int result = employee.importance;
        for(Integer sid: employee.subordinates)
            result += helper(sid);
        return result;
    }
}