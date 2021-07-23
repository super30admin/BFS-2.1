"""
# Definition for Employee.
class Employee:
    def __init__(self, id: int, importance: int, subordinates: List[int]):
        self.id = id
        self.importance = importance
        self.subordinates = subordinates
"""
#space: O(n) for all nodes
#Time: O(n) for root node
from collections import defaultdict,deque
class Solution:
    def getImportance(self, employees: List['Employee'], id: int) -> int:
        adjacency_matrix = defaultdict(list)
        importance_list = defaultdict(int)
        for val in employees:
            # print(val.id,val.importance,val.subordinates)
            importance_list[val.id] = val.importance
            if len(val.subordinates):
                for children in val.subordinates:
                    # print(children)
                    adjacency_matrix[val.id].append(children)
        queue = deque()
        queue.append(id)
        importance = 0
        while(queue):
            val = queue.popleft()
            importance+=importance_list[val]
            if adjacency_matrix[val]:
                for children in adjacency_matrix[val]:
                    queue.append(children)
        return importance
                
        