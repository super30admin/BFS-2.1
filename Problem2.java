// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english

// Your code here along with comments explaining your approach
/*
 * Store id and the employee object for that id into a map. 
 * For a specific ID, pull the object from map and retreive its importance and subordinates. 
 * Traverse and obtain its importance and add it to the result until all subordinates are covered recursively. */


public class Problem2 {
    int result; 
    HashMap<Integer, Employee> map;
    public int getImportance(List<Employee> employees, int id) {
        this.map = new HashMap<>();
        for(Employee e: employees){
            map.put(e.id, e);
        }
        dfs(id);
        return result;
    }
    private void dfs(int id){
       Employee e =  map.get(id);
        result += e.importance; 
        for(int subId: e.subordinates){
            dfs(subId);
        }
    }
}
