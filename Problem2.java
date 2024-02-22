//## Problem 2

//Employee Impotance(https://leetcode.com/problems/employee-importance/)


/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
    //1. BFS
    // Time: O(V+E) --> O(V+V) as each emp has one manager --> O(V) --> O(N)
    // Space:O(V+E) --> O(V+V) as each emp has one manager --> O(V) --> O(N)
    private int bfsHelper(List<Employee> employees, int id){
        // Make an adj list of empId -> emp object
        Map<Integer, Employee> adjList = new HashMap<>();
        for(Employee e: employees){
            adjList.put(e.id, e);
        }

        Queue<Integer> q =new LinkedList<>();
        int result=0;
        q.add(id);

        while(!q.isEmpty()){
            int curr=q.poll();
            Employee currEmp=adjList.get(curr);

            // Add current importance
            result+=currEmp.importance;

            // Add all sub-ordinates to queue
            for(int sub: currEmp.subordinates){
                q.add(sub);
            }
        }
        return result;
    }

    private void dfs(Map<Integer, Employee> adjList, int id){
        Employee curr=adjList.get(id);
        // Add current imp
        result+=curr.importance;

        // DFS for all subordinates
        for(int sub: curr.subordinates){
            dfs(adjList, sub);
        }
    }

    //2. DFS
    // Time: O(V+E) --> O(V+V) as each emp has one manager --> O(V) --> O(N)
    // Space:O(V+E) --> O(V+V) as each emp has one manager --> O(V) --> O(N)
    private int result;
    private int dfsHelper(List<Employee> employees, int id){
        this.result=0;
        // Make an adj list of empId -> emp object
        Map<Integer, Employee> adjList = new HashMap<>();
        for(Employee e: employees){
            adjList.put(e.id, e);
        }

        dfs(adjList, id);
        return result;
    }

    public int getImportance(List<Employee> employees, int id) {
        //1. BFS
        //return bfsHelper(employees, id);

        //2. DFS
        return dfsHelper(employees, id);

    }
}