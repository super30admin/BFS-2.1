"""
Runtime Complexity:
O(n) - we perform a dfs on the queried id by fetching from the hashmap. We calculate the total importance of it by computing the
importance of subtrees. In the worst case, the requested id may be the root.
Space Complexity:
O(n) - We use a hashmap to store 'n' employees.
Yes, the code worked on leetcode.
"""
class Solution:
    
    def getImportance(self, employees: List['Employee'], id: int) -> int:
        if len(employees)==0:
            return 0
        self.emp_map = {emp.id: emp for emp in employees}
        self.total_importance  = 0
        self.dfs(id)
        return self.total_importance
    
    def dfs(self,id):
        emp = self.emp_map.__getitem__(id)
        if emp!=None:
            self.total_importance+=emp.importance
            for sub in emp.subordinates:
                self.dfs(sub)
        
        
        