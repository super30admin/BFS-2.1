"""
# Definition for Employee.
class Employee:
    def __init__(self, id: int, importance: int, subordinates: List[int]):
        self.id = id
        self.importance = importance
        self.subordinates = subordinates
"""

class Solution:
    def getImportance(self, employees: List['Employee'], id: int) -> int:
        dict1={}
        def dfs(id):
            e=dict1.get(id)
            ans=e.importance;
            for i in e.subordinates:
                ans+=dfs(i)
            return ans
        for i in employees:
            dict1[i.id]=i
        return dfs(id)
        