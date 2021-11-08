// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int getImportance(List<Employee> employees, int id) {
        int result=0;
        HashMap<Integer,Employee> map=new HashMap<>();
        for(int i=0;i<employees.size();i++){
            map.put(employees.get(i).id,employees.get(i));
        }
        
        Queue<Integer> queue=new LinkedList<>();
        queue.add(id);
        
        while(!queue.isEmpty()){
            int curr=queue.poll();
            Employee currEmployee=map.get(curr);
               result+=currEmployee.importance;
            for(int i:currEmployee.subordinates){
                queue.add(i);
            }
        }
        
        return result;
    }
}