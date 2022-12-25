// Time Complexity :O(employees)
// Space Complexity :O(employees)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

/*
This is a graph problem which can be solved with DFS or BFS
We need to first create an adjacency list  and then use that to calculate the importacnce 

Time : O(employees)
Space : O(employees)
*/
class Solution {
    public int getImportance(List<Employee> employees, int id) {

        // employee id mapped to employee object (not the subordinates id)
        HashMap<Integer,Employee> map = new HashMap<Integer,Employee>(); // adjacency list
        for(Employee emp : employees){
            map.put(emp.id,emp);
        }

        // we will get the id of the employee and get the values of the subordinates
        
        int importance = 0;
        Queue<Employee> queue = new LinkedList<Employee>();
        queue.add(map.get(id)); // adding the parent employee
        while(!queue.isEmpty()){
            Employee curr = queue.poll();
            importance+=curr.importance;
            for(Integer subId : curr.subordinates){
                queue.add(map.get(subId));
            }
        }

        return importance;
    }
}