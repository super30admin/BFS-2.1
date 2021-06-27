// Time Complexity : O(N) 
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : yes

// Three line explanation of solution in plain english
// Add all employee nodes to a hashmap based on their ID as they are unique
// Add the employee whos importance you are looking for in the queue then find all the importance of all the subordinates
 
class Solution {
    public int getImportance(List<Employee> employees, int id) {
        if(employees == null || employees.size() == 0) return 0;
        
        int result = 0;
        HashMap<Integer, Employee> map = new HashMap<>();
        for(Employee e : employees){
            map.put(e.id, e);
        }
        Queue<Integer> q = new LinkedList<>();
        q.add(id);
        while(!q.isEmpty()){
            int eid = q.poll();
            Employee e = map.get(eid);
            result += e.importance;
            for(int subid : e.subordinates){//add subordinates to queue so queue doesn't get empty until no subordinates left
                q.add(subid);
            }
        }        
        return result;
    }
}