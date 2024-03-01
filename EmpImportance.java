//BFS approach
// Time Complexity : O(v+e), v = e = n , no. of employees so O(n)
// Space Complexity : O(v+e), v = e = n , no. of employees so O(n) will be stored in hashmap
// Did this code successfully run on Leetcode : yes
// Three line explanation of solution in plain english : It is graph represented as a n-ary tree as an employee will not report to multiple
// managers. Maintain a hashmap to store fetch the employee in O(1) and do bfs adding importance of each employee in queue.

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
        Map<Integer,Employee> map = new HashMap<>();
        for(Employee emp : employees){
            map.put(emp.id, emp);
        }

        Employee e = map.get(id);
        Queue<Employee> q = new LinkedList<>();
        q.add(e);
        int imp = 0;

        while(!q.isEmpty()){
            e = q.poll();
            imp += e.importance;
            List<Integer> subordinates= e.subordinates;
            for(int sub : subordinates){
                q.add(map.get(sub));
            }
        }

        return imp;
    }
}

//DFS approach
// Time Complexity : O(v+e), v = e = n , no. of employees so O(n)
// Space Complexity : O(v+e), v = e = n , no. of employees so O(n) will be stored in hashmap
// Did this code successfully run on Leetcode : yes
// Three line explanation of solution in plain english : It is graph represented as a n-ary tree as an employee will not report to multiple
// managers. Maintain a hashmap to store fetch the employee in O(1) and do dfs adding importance of each subordinates.

/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
    Map<Integer, Employee> map;
    int imp = 0;

    public int getImportance(List<Employee> employees, int id) {
        this.map = new HashMap<>();
        for (Employee emp : employees) {
            map.put(emp.id, emp);
        }

        dfs(employees, id);
        return imp;
    }

    private void dfs(List<Employee> employees, int id) {
        //base - no need, for loop will only run for subordinates

        Employee e = map.get(id);
        imp += e.importance;
        List<Integer> subordinates = e.subordinates;

        for (int sid : subordinates) {
            dfs(employees, sid);
        }
    }
}
