// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
//in this approach we add all the employee in a hashmap with id as the key. we add the id to the queue and if the queue is not empty we pop that id out anf process all the subordinates
//of the employee. We increment the result by importance of each. finally we return result.
//bfs
class Solution {
    public int getImportance(List<Employee> employees, int id) {
        HashMap<Integer,Employee> map = new HashMap<>();
        int result =0;
        Queue<Integer> q= new LinkedList<>();
        for(Employee e : employees){
            map.put(e.id, e);
        }
        q.add(id);
        while(!q.isEmpty()){
            int currId = q.poll();
            Employee e = map.get(currId);
            result+= e.importance;
            for(int subid: e.subordinates){
                q.add(subid);
            }
        }
        return result;


    }
}


//dfs
class Solution {
    HashMap<Integer,Employee> map;
    int result;
    public int getImportance(List<Employee> employees, int id) {
        map= new HashMap<>();
        for(Employee e : employees){
            map.put(e.id, e);
        }
        dfs(id);
        return result;
    }
    private void dfs(int id){
        Employee e = map.get(id);
        result+= e.importance;
        for(int subid: e.subordinates){
            dfs(subid);
        }
    }
}