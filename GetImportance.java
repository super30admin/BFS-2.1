// Time Complexity : The time complexity is O(n) where n is the number of nodes
// Space Complexity : The space complexity is O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

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

        Map<Integer,Integer> imp = new HashMap<>();
        Map<Integer,List<Integer>> sub = new HashMap<>();

        for(Employee each:employees){
            imp.put(each.id,each.importance);
            sub.put(each.id,each.subordinates);
        }

        Queue<Integer> q = new LinkedList<>();
        q.offer(id);

        int output = 0;

        // Traverse to all the subordinates using bfs
        while(!q.isEmpty()){

            int emp = q.poll();
            output += imp.get(emp);

            if(sub.get(emp) != null){
                for(int each:sub.get(emp)){
                    q.offer(each);
                }
            }
        }

        return output;

    }
}