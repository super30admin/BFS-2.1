# https://leetcode.com/problems/employee-importance/
#Approach 1 - BFS
# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

"""
# Definition for Employee.
class Employee:
    def __init__(self, id: int, importance: int, subordinates: List[int]):
        self.id = id
        self.importance = importance
        self.subordinates = subordinates
"""

class Solution:
    def dfs(self, visited, graph, node):
        if node not in visited:
            visited.append(node)
            total = graph[node].importance
        else:
            return total
    
        for neighbour in graph[node].subordinates:
            total += self.dfs(visited, graph, neighbour)
            
        return total

    def getImportance(self, employees: List['Employee'], id: int) -> int:
        self.hashMap = collections.defaultdict(list)

        for emp in employees:
            self.hashMap[emp.id] = emp
        

        return self.dfs([],self.hashMap, id)
