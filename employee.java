//Space - O(n)
// Time O(n)

class Solution {
    int imp=0;
    public int getImportance(List<Employee> employees, int id) {
        HashMap<Integer,Employee> hm = new HashMap();
        for(Employee e: employees){
            hm.put(e.id, e);
        }
        dfs(hm,id);
        return imp;
        }

public void dfs(HashMap<Integer,Employee> hm, int id){
    Employee e = hm.get(id);
    imp = imp + e.importance;
    for(int sub: e.subordinates){
        dfs(hm,sub);
    }
}
}
