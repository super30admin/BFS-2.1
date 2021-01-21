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
        # BFS
        '''
        Time Complexity: O(n)
        Space Complexity: O(n)
        '''
        '''
        q = deque([id])
        sum=0
        x={}
        for i in employees:
            x[i.id] = i
        
        while(len(q)>0):
            e = q.popleft()
            sum += x[e].importance
            q += x[e].subordinates
        return sum
        '''
        # DFS
        '''
        Time Complexity: O(n)
        Space Complexity: O(n)
        '''
        sum=0
        x={}
        for i in employees:
            x[i.id] = i
        
        def dfs(emp):
            nonlocal sum
            sum += x[emp].importance
            for i in x[emp].subordinates:
                dfs(i)
            return
        dfs(id)
        return sum
