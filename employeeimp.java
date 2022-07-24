// Time Complexity : o(n) 
// Space Complexity : o(h)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no




// Your code here along with comments explaining your approach

class Solution {
    HashMap<Integer,Employee> map;
    int timportance;
    public int getImportance(List<Employee> employees, int id) {
        map=new HashMap<>();
        timportance=0;
        for(Employee e:employees){
            map.put(e.id,e);
        }
        
        dfs(id);
        
    return timportance;
    }
    private void dfs(int id){
        
     
        
        Employee k=map.get(id);
        timportance += k.importance;
      
        if(k!=null){
            for(int ids: k.subordinates){
                dfs(ids);
            }
        }
    }
}