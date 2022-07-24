//Time Complexity:O(n)
//Space Complexity:O(n)
//using BFS:Employee infromation ID, importance,list_of_IDs, So Storing all elements in queue  by using the size variable storing all subordinates information .So there is n total number of employees in the hashset.
/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
    //add.list
    HashMap<Integer,Employee> map = new HashMap<>();
    int totalImportance;
    
    public int getImportance(List<Employee> employees, int id) {
        if(employees == null || employees.size() == 0) return 0;
        
       // map = new HashMap<>();
        for(Employee e : employees){
            map.put(e.id,e);
        }
       //we want to do BFS
        Queue<Integer> q = new LinkedList<>();
        q.add(id);
            
        while(!q.isEmpty()){
            int currEmployee = q.poll();
            Employee emp = map.get(currEmployee);
            totalImportance += emp.importance;
            if(emp.subordinates == null) continue;
            for(int sub: emp.subordinates){
                q.add(sub);
            }
        }
        return totalImportance;
    }
}