/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/


//Approach - HashMap(to store key(empId), value(empObj)) + BFS
//Time Complexity - worst case O(N) - might iterate through all the employees
//Space Complexity - O(N) - size of employees(i.e., no of unique employees)

class Solution {
  public int getImportance(List<Employee> employees, int id) {
    if(employees == null || employees.size() == 0){
      return 0;
    }

    Map<Integer, Employee> employeeDict = new HashMap<>();

    for(Employee emp: employees){
      employeeDict.put(emp.id, emp);
    }

    int totalImportance = 0;


    Queue<Integer> queue = new LinkedList<>();
    queue.add(id);

    while(!queue.isEmpty()){

      int size =queue.size();

      for(int i=0; i<size; i++){
        int empId = queue.poll();
        Employee empObj = employeeDict.get(empId);
        totalImportance = totalImportance+ empObj.importance;

        for(Integer subordinate: empObj.subordinates){
          queue.add(subordinate);
        }
      }
    }

    return  totalImportance;
  }
}