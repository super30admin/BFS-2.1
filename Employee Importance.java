/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/
//bfs
//Time Complexity : O(V+E). V is the number of employees and E is the number of subordinates for each employee. 
//Space Complexity : O(V+E)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
// Your code here along with comments explaining your approach
class Solution {
    public int getImportance(List<Employee> employees, int id) {
        if(employees==null||employees.size()==0){
            return 0;
        }
        //use a hashmap to store the employee id and their information
        //here, the key is emp id and value is the obj
        HashMap<Integer,Employee> map = new HashMap<>();
        for(Employee emp : employees){
            map.put(emp.id,emp);
        }
        //variable to hold the total importance value
        int total = 0;
        //queue to perform bfs
        Queue<Integer> q = new LinkedList<>();
        //start with employee given
        q.add(id);
        //bfs
        while(!q.isEmpty()){
            int cur = q.poll();
            //get the current employees information
            Employee emp = map.get(cur);
            total += emp.importance;
            //add the current employees subordinates to the queue
            for(int sub : emp.subordinates){
                q.add(sub);
            }
        }
        return total;
    }
}
//DFS
//Time Complexity :  O(N)
//Space Complexity : O(N)

class Solution {
    //variable to hold the total importance value
        int total = 0;
    HashMap<Integer,Employee> map;
    public int getImportance(List<Employee> employees, int id) {
        if(employees==null||employees.size()==0){
            return 0;
        }
        //use a hashmap to store the employee id and their information
        //here, the key is emp id and value is the obj
        map = new HashMap<>();
        for(Employee emp : employees){
            map.put(emp.id,emp);
        }
        //helper function to perform dfs
        dfs(id);
       return total;
}
    private void dfs(int id){
        //get the employee details
        Employee emp = map.get(id);
        //add its importance
        total += emp.importance;
        //visit this employee's subordinates
        for(int sub : emp.subordinates){
            dfs(sub);
        }
    }
}
