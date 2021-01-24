// Time Complexity : 0(n)
// Space Complexity : 0(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

class EmployeeImportance {
    int total = 0;
    Map<Integer, Employee> map;
    public int getImportance(List<Employee> employees, int id) {

        if(employees == null || employees.isEmpty())
            return total;

        //creating map for having mapping of id with employee
        //this avoids iterating through employees list everytime
        map = new HashMap<Integer, Employee>();

        for(Employee e : employees){
            map.put(e.id, e);
        }

        dfs(id);
        return total;
    }

    public void dfs(int id){
        //getting employee for id
        Employee emp = map.get(id);
        //adding their own importance
        total += emp.importance;

        //iterating through all subordinates
        for(int sub : emp.subordinates){
            dfs(sub);
        }
    }
}