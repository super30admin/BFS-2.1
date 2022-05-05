//tc and sc --> o(n)

// there's a crucial observation that needs to be done
// that is if we remove the constraints this becomes a graph problem. Say that a employee reports to multiple managers
// like  4
//     /   \
//    5     6  
// or 5 can report to 6 in above case this can transition into a graph problem !
// where tc can be o( v + e) 
// in this case where there are constraints e is 1 so => o(v + 1) v is n so => o(n)

class Solution {
    HashMap<Integer, Employee> map;
    int total;
    public int getImportance(List<Employee> employees, int id) {
         map = new HashMap<>();
        
        for(Employee e : employees) {
            map.put(e.id, e);
        }
        
        dfs(id);
        return total;
    }
    private void dfs(int id) {
        //base

        //logic
        Employee emp = map.get(id);
        total += emp.importance;

        //here i didnt include base case cuz the for loop will take care of recursion
        for(int juniors : emp.subordinates) {
            dfs(juniors);
        }
    }
}