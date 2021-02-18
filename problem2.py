// Time Complexity : O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
from collections import deque
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
        #O(n)
        #O(n)
        if not employees or len(employees)==0: #Check null conditions
            return 0
        
        hashmap={} 
        imp=0       #initialize total importance =0
        queue=deque()
        
        for emp in employees:      #create hashmap in which key is id and value is whole employee structure 
            hashmap[emp.id]=emp
        
        queue.append(id)
        
        while len(queue)!=0:      //pop each element from que and add the importance of element to the imp and add the subordinates to the queue
            front=queue.popleft()
            imp+=hashmap[front].importance
            for i in hashmap[front].subordinates:
                queue.append(i)
                
        return imp    //return total importance
