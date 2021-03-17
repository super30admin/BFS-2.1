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
        
        //checking edge cases
        if(employees == null || employees.size() == 0){
            return 0;
        }
        
        int totalImp = 0;
        
        Queue<Integer> queue = new LinkedList<>();
        
        HashMap<Integer, Employee> map = new HashMap<>();
        
        //iteraring through employee list and storing them in a hash map
        for(Employee e : employees){
            map.put(e.id, e);
        }
        
        // adding the id to the queue
        queue.add(id);
        
        //iteterate until queue is empty
        while(!queue.isEmpty()){
            //poll an element from queue
            int empId  = queue.poll();
            
            //add the subordinates of that id to a list
            List<Integer> sub = map.get(empId).subordinates;
            
            //update total importance
            int imp = map.get(empId).importance;
            totalImp += imp;
            
            // iterate through sub ordinate list and add them to the queue
            for(int subord : sub){
                queue.add(subord);
            }
        }
        
        // return total importance
        return totalImp;
    }
}
// n -> number of employees
// time Complexity :O(n)
// Space Complexity: O(n)