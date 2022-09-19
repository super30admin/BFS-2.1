// Time Complexity : O(V+E) here since V=E, we can say O(n)
// Space Complexity : O(V+E)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
//DFS
/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
    HashMap<Integer, Employee> map;
    int result;
    public int getImportance(List<Employee> employees, int id) {

        map = new HashMap<>();

        for(Employee e: employees){
            map.put(e.id, e);
        }

        dfs(id);
        return result;
    }

    private void dfs(int id){
        Employee e = map.get(id);
        result += e.importance;

        for(int subId: e.subordinates){
            dfs(subId);
        }
    }
}

//Using Employee Object Queue  -BFS

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

        HashMap<Integer, Employee> map = new HashMap<>();

        for(Employee e: employees){
            map.put(e.id, e);
        }
        int result = 0;
        Queue<Employee> q = new LinkedList<>();
        q.add(map.get(id));

        while(!q.isEmpty()){
            Employee e = q.poll();
            result += e.importance;

            for(int subId : e.subordinates){
                Employee subEmp = map.get(subId);
                q.add(subEmp);
            }
        }
        return result;
    }
}

/*
//Using Integer Queue  -BFS
class EmployeeImportance {

// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};


    class Solution {
        public int getImportance(List<Employee> employees, int id) {

            HashMap<Integer, Employee> map = new HashMap<>();

            for(Employee e: employees){
                map.put(e.id, e);
            }
            int result = 0;
            Queue<Integer> q = new LinkedList<>();
            q.add(id);

            while(!q.isEmpty()){
                int eid = q.poll();
                Employee e = map.get(eid);

                result += e.importance;

                for(int subId : e.subordinates){
                    q.add(subId);
                }
            }
            return result;
        }
    }
}
*/