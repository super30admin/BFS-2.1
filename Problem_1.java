/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

// Time Complexity : O(m*n)
// Space Complexity :O(m*n)
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english
// Make a HM of id and employee, then add the start id to the queue, then do the bfs on the queue, and calculate the sum, add all the subcorrdinate to the queue, while pop from the queue
// Your code here along with comments explaining your approach
class Solution {
    public int getImportance(List<Employee> employees, int id) {
        HashMap<Integer, Integer> hm1 = new HashMap<>();
        HashMap<Integer, List<Integer>> hm2 = new HashMap<>();
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < employees.size(); i++){
            int eid = employees.get(i).id;
            int imp = employees.get(i).importance;
            List<Integer> subList = employees.get(i).subordinates;
            hm1.put(eid, imp);
            hm2.put(eid, subList);
            if(eid == id){
                q.add(eid);
            }
        }
        int sum  = 0;
        while(!q.isEmpty()){
            int xId = q.poll();
            sum = sum + hm1.get(xId);
            List<Integer> ls = hm2.get(xId);
            if(ls.size() > 0){
                for(int i = 0; i < ls.size(); i++){
                   q.add(ls.get(i));
                }
            }
        }
        return sum;
    }
}
