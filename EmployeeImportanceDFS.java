
import java.util.List;
import java.util.HashMap;

public class EmployeeImportanceDFS {

    //DFS - Recursion

    public int getImportance(List<Employee> employees, int id) {

        //map employee id(attribute) to employee object
        HashMap<Integer, Employee> map = new HashMap<>();

        // for each employee object running over a list in for loop
        for(Employee e: employees) {

            //make map
            map.put(e.id, e);
        }
        //run dfs
        return dfs(map, id);
    }
    int impTotal;
    private int dfs(HashMap<Integer, Employee> map, int id) {

        // add current importance
        impTotal = map.get(id).importance;

        // run over subordinates recursively in dfs way
        for(int sub: map.get(id).subordinates) {

            //increment importance
            impTotal += dfs(map, sub);
        }
        // output total importance
        return impTotal;
    }



}

/*
TIME COMPLEXITY = O(N)

N - number of employees
if top most employee id is given, we run over each employee - worst case

SPACE COMPLEXITY = O(N)
recursive stack space

*/