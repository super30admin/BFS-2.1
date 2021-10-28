'''
Time Complexity: O(n)
Space Complexity: HashMap O(n) + Queue O(n) = O(2n) ~ O(n)
'''
"""
# # Definition for Employee.
# class Employee:
#     def __init__(self, id: int, importance: int, subordinates: List[int]):
#         self.id = id
#         self.importance = importance
#         self.subordinates = subordinates
"""
class Solution:
    def getImportance(self, employees: List['Employee'], id: int) -> int:
        hashMap={}
        for i in range(len(employees)):
            if employees[i].id not in hashMap:
                hashMap[employees[i].id]=[i,employees[i].importance]
        que=deque()
        que.append(id)
        count=0
        while que:
            size=len(que)
            for i in range(size):
                current=que.popleft()
                count+=hashMap[current][1]
                if employees[hashMap[current][0]].subordinates:
                    for i in employees[hashMap[current][0]].subordinates:
                        que.append(i)
        return count
            