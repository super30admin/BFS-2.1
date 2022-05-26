//Time Complexity: O(N) 
//Space Complexity: O(N) + O(N) (hashmap and queue)
//Leetcode: Yes
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
        int total_importance = 0;
        HashMap<Integer, Employee> map = new HashMap<Integer, Employee>();
        //create a maping for employee id  to entire empyoee data.  id 1 ---> employee 1 data
        for (Employee emp : employees) {
            map.put(emp.id, emp);
        }
        
        Queue<Employee> queue = new LinkedList<Employee>();
        //put the given empoyee in the queue
        queue.add(map.get(id));
        total_importance = map.get(id).importance;
        
        while (!queue.isEmpty()) {
            Employee e = queue.poll();
            for (Integer sub : e.subordinates) {
                total_importance += map.get(sub).importance;
                queue.add(map.get(sub));    
            }
        }
        return total_importance;
    }
}
