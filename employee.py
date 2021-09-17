# // Time Complexity :O(n)
# // Space Complexity :O(h)
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :no


# // Your code here along with comments explaining your approach





"""
# Definition for Employee.





class Employee:
    def __init__(self, id: int, importance: int, subordinates: List[int]):
        self.id = id
        self.importance = importance
        self.subordinates = subordinates
"""

class Solution:
    def __init__(self):
        self.result=0
        self.dict={}
    def getImportance(self, employees: List['Employee'], id: int) -> int:
        for i in range(len(employees)):
            temp=employees[i]
            self.dict[temp.id]=temp
        
        self.dfs(id)
        return self.result
    def dfs(self,id):
        #base
        #logic
        emp=self.dict[id]
        self.result+=emp.importance
        for i in emp.subordinates:
            self.dfs(i)
        
        
        
        