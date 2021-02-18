#TimeComplexity:O(N) 
#SpaceComplexity: O(N) for dictionary
#Did this code successfully run on Leetcode : Yes 
#Any problem you faced while coding this : No
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
        dict={}
        for i in employees:
            dict[i.id]=[i.id,i.importance,i.subordinates]
        count=dict[id][1]
        queue=dict[id][2]
        while queue:
            for i in [queue.pop(0)] :
                count+=dict[i][1]
                if dict[i][2]:
                    queue+=dict[i][2]
        return count
                
            
        
        