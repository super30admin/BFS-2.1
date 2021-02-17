################## Iterative solution
# Time complexity: O(n)
# Space complexity: O(n)
# Worked on leetcode: yes
# Iterative approach: This algorithm uses a BFS like approach. We first create a hashmap to store the id, subordinates and importance of each employee.
# We then start with the id subarray, and push it into a queue. Then till the queue is not empty, we pop the employee subarray from the queue, and keep pushing
# the subarray of its subordinates into the queue, and repeat this. During this, we keep on adding the importance to the global variable for each of the corresponding subordinate
# pushed into the stack. Finally, we return the importance.

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

        if len(employees) == 0: return 0

        hashmap = {}
        out_imp = 0
        queue = []

        for employee in employees:
            hashmap[employee.id] = employee

        print(hashmap)
        queue.append(hashmap[id])
        # out_imp = hashmap[id].importance
        out_imp = 0

        while len(queue) != 0:
            front = queue.pop(0)
            subor = hashmap[front.id].subordinates
            importance = hashmap[front.id].importance
            out_imp += importance
            for sub in subor:
                queue.append(hashmap[sub])

        return out_imp


