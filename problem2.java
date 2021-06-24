
// Time - O(N)
//  Space - O(N)



class Solution {

    HashMap<Integer, Employee>  hmap;
    public int getImportance(List<Employee> employees, int id) {

        hmap= new HashMap<>();
        // put all employee details in the hashmap
        for(Employee e: employees)  {

            hmap.put(e.id, e);

        }

        return dfs(id);



    }

    public int dfs(int eid) {

        // fetch the  employee id from the hashmap
        Employee e = hmap.get(eid);

        // fetch the importance value
        int sum = e.importance;

        // iterate over subordinates importance value and add to the final sum

        for(Integer subId : e.subordinates) {

            sum += dfs(subId);

        }

        return sum;


    }


}