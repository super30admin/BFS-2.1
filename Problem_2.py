# Employee Importance

# Time Complexity : O(N)
# Space Complexity : O(h), h is height of the tree
# Did this code successfully run on Leetcode : Yes, with Runtime: 156 ms and Memory Usage: 15.6 MB
# Any problem you faced while coding this : Initally yes, After class understanding no.
# Your code here along with comments explaining your approach
# Approach
"""
Using BFS approach, initializing a hashmap to store information. A queue
is maintained in which id's are used. Elements are checked 1 by 1 for its 
subordinates and we keep polling out the elements to find the result. 

"""

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
        e = {}  # Hashmap
        for i in employees:
            e[i.id] = i
        l = [id] # Queue(List) to store employee id's
        result = 0
        while l != []: 
            p = l.pop(0)
            l += e[p].subordinates
            result += e[p].importance
        return result