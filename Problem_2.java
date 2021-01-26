// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
/
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
        if(employees ==null) return 0;
        HashMap<Integer,Employee> hash=new HashMap<Integer,Employee>();
        for(Employee e:employees){
            hash.put(e.id,e);
        }
        Queue<Integer> qu=new LinkedList<Integer>();
        int totalImport=0;
        qu.add(id);
        while(!qu.isEmpty()){
            int size=qu.size();
            for(int i=0;i<size;i++){
                int node=qu.remove();
                totalImport=totalImport+hash.get(node).importance;
                for(Integer emp:hash.get(node).subordinates){
                    qu.add(emp);
                }
            }
        }
        return totalImport;
        
    }
}

//using the stack
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
        if(employees ==null) return 0;
        HashMap<Integer,Employee> hash=new HashMap<Integer,Employee>();
        for(Employee e:employees){
            hash.put(e.id,e);
        }
        Stack<Integer> st=new Stack<Integer>();
        int totalImport=0;
        st.push(id);
        while(!st.isEmpty()){
                int node=st.pop();
                totalImport=totalImport+hash.get(node).importance;
                for(Integer emp:hash.get(node).subordinates){
                    st.add(emp);
                }
        }
        return totalImport;
        
    }
}

//using DFS
/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
    private int totalImport;
     HashMap<Integer,Employee> hash;
    public int getImportance(List<Employee> employees, int id) {
        if(employees ==null) return 0;
        hash=new HashMap<Integer,Employee>();
        for(Employee e:employees){
            hash.put(e.id,e);
        }
        totalImport=0;
        dfs(id);
        return totalImport;
        
    }
    
    private void dfs(int id){
        //there will be node base condition in this
        //as it is already handled int the for loop.
        
        totalImport=totalImport+hash.get(id).importance;
        for(Integer emp:hash.get(id).subordinates){
            dfs(emp);
        }
    }
}