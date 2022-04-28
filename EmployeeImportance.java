/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/
//BFS approach
class Solution {

    //Time Complexity: 0(n) where n is the subordinates
    //Space Complexity : 0(n) where n is the subordinates
    //Did it successfully run on leetcode: Yes
    //Did you face any problem while implementing : No

    //In Short explain your approach : I first store all the id's and the objects in my hashmap for constant retirval. Then I
    //used a BFS approach and also declared a counter to counter the importance of each subbordinate. I added the id to be
    //searched in my queue and then removed the same and looked up its importance and subbordinates in my hashmap.Then I
    //added its importance to my counter and then iterated and repeated the same steps for all of its subbordinates.

    HashMap <Integer , Employee> map;
    public int getImportance(List<Employee> employees, int id) {
        if(employees == null || employees.size() == 0){
            return 0;
        }
        map = new HashMap<>();
        for(Employee e:employees){
            map.put(e.id , e);
        }
        Queue <Integer> q = new LinkedList<>();
        int count = 0;
        q.add(id);
        while(!q.isEmpty()){
            int current = q.poll();
            Employee emp = map.get(current);
            count = count + emp.importance;
            for(int junior : emp.subordinates){
                q.add(junior);
            }
        }
        return count;
    }
}

//DFS

/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
    HashMap <Integer, Employee> map;
    int total;
    public int getImportance(List<Employee> employees, int id) {
        map = new HashMap<>();
        total = 0;
        for(Employee e : employees){
            map.put(e.id, e);
        }
        helper(id);
        return total;
    }
    public void helper(int id){
        Employee emp = map.get(id);
        total = total + emp.importance;
        for(int junior : emp.subordinates){
            helper(junior);
        }
    }
}