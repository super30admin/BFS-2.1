// Time complexity - O(n)
// Space complexity - O(n) 
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No

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
        
        HashMap<Integer, Employee> map1 = new HashMap<>();
        
        for(int i = 0; i < employees.size(); i ++){
            
            Employee current = employees.get(i);
            int tempid = current.id;
            
            if(!map1.containsKey(employees)){
                
                map1.put(tempid,employees.get(i));
            }
        }
        
        //System.out.print(map1);
        //if(!map1.containsKey())
        int importance = 0;
        Queue<Employee> q1 = new LinkedList<>();
        q1.add(map1.get(id));
        
        while(!q1.isEmpty()){
            
            Employee temp = q1.poll();
            importance = importance + temp.importance;
            //List<Integer> arr1 = new ArrayList<>();
            for(int i = 0; i < temp.subordinates.size(); i ++){
                
                q1.add(map1.get(temp.subordinates.get(i)));
            }
        }
        
        
        return importance;
    }
}