"""
# Definition for Employee.
class Employee:
    def __init__(self, id: int, importance: int, subordinates: List[int]):
        self.id = id
        self.importance = importance
        self.subordinates = subordinates
"""

# Time Complexity - O(n)
# Space Complexity - O(n)
# BFS

class Solution:
    def getImportance(self, employees: List['Employee'], id: int) -> int:
        dictionary = {}
        for each in employees: 
            dictionary[each.id] = each

        q = [id] 
        result = 0
        while q : 
            e = q.pop(0)
            sub = dictionary[e].subordinates 
            result += dictionary[e].importance 
           
            for each in sub: 
                q.append(each) 
        return result

# DFS 
# Time Complexity - O(n)
# Space Complexity - O(n)

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
        self.dictionary = {}
        for each in employees: 
            self.dictionary[each.id] = each
        self.result = 0
        self.dfs(id)
        return self.result

    def dfs(self,id):
            
            sub = self.dictionary[id].subordinates 
            self.result += self.dictionary[id].importance 
           
            for each in sub: 
                self.dfs(each) 
       



