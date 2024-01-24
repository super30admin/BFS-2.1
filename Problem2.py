'''

Time Complexity : O(n)
Space Complexity : O(n)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No issues faced

Your code here along with comments explaining your approach:
Firstly look for the object in the list provided and append it into the queue the object which matches the id. Then subsequently add up the
importance using BFS 

'''

class Solution:
    def getImportance(self, employees: List['Employee'], id: int) -> int:
        q = collections.deque()

        for i in employees:
            if i.id == id:
                q.append(i)


        imp = 0
        while q:
            emp = q.popleft()
            imp += emp.importance

            for a in emp.subordinates:
                q.append(next(e for e in employees if e.id == a))

                # next returns the first element in the iteration

        return imp