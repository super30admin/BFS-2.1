// Time Complexity : O(n)
// Space Complexity : O(n)
// Method used : DFS

class Solution {

    HashMap<Integer, Employee> map = new HashMap();
    int sum = 0;

    public int getImportance(List<Employee> employees, int id) {

        for(Employee e : employees) map.put(e.id, e);

        helper(id);

        return sum;
    }

    private void helper(int id)
    {
        Employee emp = map.get(id);
        sum += emp.importance;

        for(int x : emp.subordinates)
        {
            helper(x);
        }

    }
}