// Time Complexity : O(n) where n = number of nodes
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

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
        Queue<Integer> q = new LinkedList<>();
        // HashMap to map ID with their respective Employee object
        HashMap<Integer, Employee> map = new HashMap<>();
        for(Employee e : employees){
            map.put(e.id , e);
        }
        q.add(id);
        int result = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                // take first element out of the queue
                int eid = q.poll();
                // get the id of the current popped element
                Employee e = map.get(eid);
                // add current element's importance to the result
                result += e.importance;
                
                // add it's children to the queue 
                for(int subId : e.subordinates){
                    q.add(subId);
                }
            }
        }
        return result;
    }
}