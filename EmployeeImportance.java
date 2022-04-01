//Time Complexity : O(n); where n= V+E. Here E=V
//Space Complexity : O(n)
public class EmployeeImportance {	
	public int getImportance(List<Employee> employees, int id) {
        if(employees==null || employees.size()==0) return 0;
        
        //Prepare adjacency list for employees for faster search
        Map<Integer, Employee> adjMap= new HashMap<>();        
        for(Employee e: employees){
            adjMap.put(e.id, e);                
        }
        
        //Start BFS
        Queue<Integer> q= new LinkedList<>();
        q.add(id);
        int totalImp= adjMap.get(id).importance;
        while(!q.isEmpty()) {
        	int mgrId= q.poll();
        	List<Integer> subIds = adjMap.get(mgrId).subordinates;
            for(Integer subid: subIds){
                totalImp+=adjMap.get(subid).importance;                
                q.add(subid);
            }
        }
        return totalImp;
    }
	
	// Driver code to test above 
	public static void main(String args[]) {
		EmployeeImportance ob = new EmployeeImportance();
		TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(4), null),	new TreeNode(3, new TreeNode(5), new TreeNode(6)));
		int x = 4;
		int y = 3;

		System.out.print("If " + x + " and " + y + " are cousins in given tree? " + ob.isCousins(root, x, y));
	}
}
