// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Notes : Create a HashMap with key as Id and value as the Employee object. Start by adding the required Id's employee object in the queue, calculate the importance and then add the employee objects of all its subordinates by looking up in the HashMap until the queue is not empty. 

public class EmployeeImportance {
    public int getImportance(List<Employee> employees, int id) {
        if(employees == null) return -1;
        HashMap<Integer, Employee> map = new HashMap<>();
  
        for(int i = 0; i < employees.size(); i++){
            map.put(employees.get(i).id , employees.get(i));
        }
        
        Queue<Employee> q = new LinkedList<>();

        q.add(map.get(id));
        int totalImportance = 0;

        while(!q.isEmpty()){

            Employee curr = q.poll();
            totalImportance = totalImportance + curr.importance;

            if(curr.subordinates.size() != 0){
                for(int subordinate : curr.subordinates){
                     if(map.get(subordinate) != null)
                        q.add(map.get(subordinate));
                }
            } 
        }
        
        return totalImportance;
    }
}
