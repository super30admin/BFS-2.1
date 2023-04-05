/*
 * Time Complexity - O(N), where N is the number of employees.
 * Space Complexity - O(N)
 */
//bfs
class Solution {
    public int getImportance(List<Employee> employees, int id) {  
        Map<Integer, Employee> map = new HashMap<Integer, Employee>();
        for(Employee emp : employees) 
            map.put(emp.id, emp);
        
        if(!map.containsKey(id))
            return 0;

        int imp = 0;
        Queue<Employee> queue = new LinkedList<Employee>();
        queue.add(map.get(id));
        
        while(!queue.isEmpty()) {
            Employee emp = queue.poll();
            imp += emp.importance;
            for(Integer subId : emp.subordinates)
                queue.add(map.get(subId));
        }
        return imp;
    }
}
