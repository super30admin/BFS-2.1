// Time Complexity :  O(V)
// Space Complexity : O(V)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach:
// We are storing the given list of employees into a hashmap such that key is the id and entire employee is the value.So that
// we have access to the employees importance and also the id's of his sub ordinates. 
// now we can use a queue to traverse
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
    public int getImportance(List<Employee> employees, int id) {
        this.map = new HashMap<>();
        for(Employee e:employees)
        {
            map.put(e.id,e);
        }
        Queue<Integer> q= new LinkedList<>();
        q.add(id);
        int result=0;
        while(!q.isEmpty())
        {
            int currid= q.poll();
           // result+=currid.importance;
            Employee curremp= map.get(currid);
            result+=curremp.importance;
            for(int sub: curremp.subordinates)
            {
                q.add(sub);
            }
        }
        return result;
    }
}