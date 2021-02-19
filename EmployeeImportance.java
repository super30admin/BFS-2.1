//TC:O(n)
//Space complexity: O(maximum number of subordinates)
//Approach: We are doing BFS and adding the importance
//when we poll from the queue everytime and add its subordinates to queue
/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
    public int getImportance(List<Employee> employees, int id) {
        
        int outputImp = 0;
        HashMap<Integer,Employee> hashmap = new HashMap<>();
        for(Employee e:employees){
            hashmap.put(e.id,e);
        }
        
        Queue<Integer> queue = new LinkedList<>();
        queue.add(id);
        
        while(!queue.isEmpty()){
            int qid = queue.poll();
            
            outputImp+=hashmap.get(qid).importance;
            List<Integer> subords = hashmap.get(qid).subordinates;
            for(int i=0;i<subords.size();i++){
                queue.add(subords.get(i));
            }
        }
        
        return outputImp;
        
    }
}