// Time Complexity : O(N) 
// Space Complexity : O(N) hashtable size
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/*
1. Add all the elements in hashtable to make adjacency list
2. When diven the id as parameter find the element in the hashtable and then 
3. Perform DFS on the node and child nodes and add the importance
*/


// Your code here along with comments explaining your approach
class Solution {
    int importance = 0;
    HashMap<Integer, Employee> map = new HashMap<>();
    public int getImportance(List<Employee> employees, int id) {
        
        for(Employee employee : employees) {
            map.put(employee.id, employee);
        }
        
        dfs(id);
        
        return importance;
    }
    
    public void dfs(int id) {
        Employee curr = map.get(id);
        
        importance += curr.importance;
        
        for(int subordinate: curr.subordinates) {
            dfs(subordinate);
        }
    }
}

