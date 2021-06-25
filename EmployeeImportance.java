//time and space complexity:O(N)
class Solution {
    HashMap<Integer,Employee> map;
    int result;
    public int getImportance(List<Employee> employees, int id) {
        map=new HashMap<>();
        for(Employee e:employees)
        {
            map.put(e.id,e);//insert the id as key and 
            //object as value in hashmap 
        }
        dfs(id);//recursive call over id
        return result;
    }
    private void dfs(int id)
    {
        Employee e=map.get(id);//get the object of the id
        result+=e.importance;//add the importance
        for(int subid: e.subordinates)
        {
            dfs(subid);//recursive call over the subids
        }
    }
}
