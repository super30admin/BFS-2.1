"""
# Definition for Employee.
class Employee:
    def __init__(self, id: int, importance: int, subordinates: List[int]):
        self.id = id
        self.importance = importance
        self.subordinates = subordinates
"""
from queue import Queue
class Solution:
    def getImportance(self, employees: List['Employee'], id: int) -> int:
        hashmap = dict()
        for e in employees:
            hashmap[e.id] = e
        q = Queue()
        q.put(id)
        result = 0
        while(q.empty()!=True):
            val = q.get()
            result = result + hashmap[val].importance
            for k in hashmap[val].subordinates:
                q.put(k)
        return result

            
