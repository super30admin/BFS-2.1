Time Complexity: O(n)
Space Complexity: O(n)


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
        //base case
        if(employees == null || employees.size() == 0){
            return 0;
        }
        int imp=0;
        Queue<Integer> queue = new LinkedList<>();
        HashMap<Integer, Employee> hashMap = new HashMap<>();
        
        for(Employee e:employees){
            hashMap.put(e.id,e);
        }
        queue.add(id);
        
        while(!queue.isEmpty()){
            int i = queue.poll();
            List<Integer> sub = hashMap.get(i).subordinates;
            int impor = hashMap.get(i).importance;
            imp +=impor;
            
            for(int s: sub){
                queue.add(s);
            }
        }
        
        return imp;
    }
}
/*
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
        //base case
        if(employees == null || employees.size() == 0){
            return 0;
        }
        int imp=0;
        Queue<Integer> queue = new LinkedList<>();
        
        //build queue 
        for(Employee e: employees){
            if(e.id == id){
                imp= e.importance;
                for(int i : e.subordinates){
                    queue.add(i);
                }
            }
        }
        
        while(!queue.isEmpty()){
            int i = queue.poll();
            for(Employee e: employees){
                if(e.id == i){
                    imp+=e.importance;
                    for(int a : e.subordinates){
                        queue.add(a);
                    }
                }
            }
        }
        
        return imp;
    }
}
*/