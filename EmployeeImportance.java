// Time Complexity :O(N) ---> we need check all employee suboordinates
// Space Complexity :O(N) 
// Did this code successfully run on GeeksforGeeksEditor : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class Solution {
    Map<Integer, Employee> empMap;
    public int getImportance(List<Employee> employees, int id) {
        empMap = new HashMap<>();
        for(Employee e : employees){
            empMap.put(e.id, e);
        }
        return dfsImp(id);
    }
        public int dfsImp(int id){
            Employee employee = empMap.get(id);
            int res = employee.importance;
            for(Integer subordid : employee.subordinates){
                res = res + dfsImp(subordid);
            }
            return res;
        }

}