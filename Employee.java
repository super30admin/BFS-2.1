class Solution {
    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> inputMap = new HashMap<>();

        for (Employee e : employees) {
            inputMap.put(e.id, e);
        }
        return helper(inputMap, id);
    }

    private static int helper(Map<Integer, Employee> inputMap, int id) {

        int imp = inputMap.get(id).importance;

        for (int subId : inputMap.get(id).subordinates) {
            imp += helper(inputMap, subId);
        }

        return imp;
    }
}