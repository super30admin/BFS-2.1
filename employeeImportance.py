# Time complexity -> O(n)
# Space complexity -> O(n)
class Solution:
    hashMap = {}
    
    def getImportance(self, employees: List['Employee'], id: int) -> int:
        if not employees:
            return 0
        
        for emp in employees:
            self.hashMap[emp.id] = emp
            
        total = 0
        queue = [id]
        
        while queue:
            curr = queue.pop(0)
            emp = self.hashMap[curr]
            
            total += emp.importance
            
            for juniors in emp.subordinates:
                queue += [juniors]
                
        
        return total
    

# # Time complexity -> O(n)
# # Space complexity -> O(n)
# class Solution:
#     hashMap = {}
#     total = 0
#     def getImportance(self, employees: List['Employee'], id: int) -> int:
#         if not employees:
#             return 0
        
#         for emp in employees:
#             self.hashMap[emp.id] = emp
        
#         self.dfs(id)
        
#         return self.total
    
#     def dfs(self,id):
#         emp = self.hashMap[id]
#         self.total += emp.importance
        
#         for junior in emp.subordinates:
#             self.dfs(junior)
    

                