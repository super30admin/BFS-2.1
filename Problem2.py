# Time Complexity : O(N)
# Space Complexity : O(h)
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

#take key as id and value as employee because only pointer will the value so that
#no extra space is created

class Solution:
    def __init__(self):
        self.dict = {}
        self.result = 0
    def getImportance(self, employees: List['Employee'], id: int) -> int:
        
        for i in employees:
            self.dict[i.id] = i
        self.helper(id)
        return self.result
    
    def helper(self,id):
        self.result += self.dict[id].importance
        for i in self.dict[id].subordinates:
            self.helper(i)