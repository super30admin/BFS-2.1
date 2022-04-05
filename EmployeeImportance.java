// Time Complexity : TC(V+E) V=E here, we used adjacency list which means its a graph problem
// Space Complexity : TC(V+E) V=E here, we used adjacency list which means its a graph problem
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {

    //BFS

    public int getImportance(List<Employee> employees, int id) {

        HashMap<Integer, Employee> map = new HashMap();
        Queue<Integer> q = new LinkedList();

        //put in hashmap id against employee id, so that we don't have to iterate over list to find employee objects by their ids
        for(Employee e :  employees)
        {
            map.put(e.id, e);
        }

        q.add(id);

        int totalImportance = 0;

        while(!q.isEmpty())
        {
            //remove emp and add it's importance
            int eid = q.remove();
            Employee e = map.get(eid);
            totalImportance += e.importance;

            //iterate over it's subordinates and keep adding them and their children to queue
            for(int subId : e.subordinates)
            {
                q.add(subId);
            }
        }

        return totalImportance;
    }
}
