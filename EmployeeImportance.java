// Time Complexity : O(n)
// Space Complexity : O(n) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//Using BFS
class Solution {
        
        public int getImportance(List<Employee> employees, int id) {
            HashMap<Integer, Employee>  map = new HashMap<>(); // mapping id with employee object
            for(Employee e : employees){ // tc:o(n)
                map.put(e.id,e);
            }
            Queue<Employee> q = new LinkedList<>(); //Employee references
            q.add(map.get(id));
            int result=0;
            while(!q.isEmpty()){ //o(n)
                Employee e =q.poll(); //polling out from stack
                result += e.importance; //add its importances
                for (int subId : e.subordinates){ // adding its child/subordinates into the queue
                    q.add(map.get(subId));
                } 
            }
            return result;
        }
        
}

// Time Complexity : O(n)
// Space Complexity : O(n) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//Using DFS
class Solution {
        private HashMap<Integer, Employee> employeeMapping;
        int total=0;
        public int getImportance(List<Employee> employees, int id) {
            this.employeeMapping=new HashMap<>();
            for(Employee e : employees){
                employeeMapping.put(e.id,e);
            }
            dfs(id);
            return total;
        }
        private void dfs(int id){
            Employee e=employeeMapping.get(id);
            total+=e.importance;
            for(int subId: e.subordinates){
                dfs(subId);
            }
        }
}


