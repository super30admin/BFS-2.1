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
     HashMap<Integer, Employee> map1;
    int importance;
    public int getImportance(List<Employee> employees, int id) {
        
         map1 = new HashMap<>();
        
        for(int i = 0; i < employees.size(); i ++){
            
            Employee current = employees.get(i);
            int tempid = current.id;
            
            if(!map1.containsKey(employees)){
                
                map1.put(tempid,employees.get(i));
            }
        }
        
        //System.out.print(map1);
        //if(!map1.containsKey())
        importance = 0;
        
        dfs(map1.get(id));
        
        return importance;
    }
    
    private void dfs(Employee current1){
        
         importance = importance + current1.importance;
            //List<Integer> arr1 = new ArrayList<>();
            for(int i = 0; i < current1.subordinates.size(); i ++){
                
                dfs(map1.get(current1.subordinates.get(i)));
            }
    }
}