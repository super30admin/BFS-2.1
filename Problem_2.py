"""
go over all the ids and sum the importance
TC - O(n)
SC - O(n)
"""
class Solution:
    def getImportance(self, employees: List['Employee'], i: int) -> int:
        hp = dict()
        for emp in employees:
            hp[emp.id] = emp
        q = []
        total = 0
        q.append(i)
        while len(q) > 0:
            cur = q.pop(0)
            e = hp[cur]
            total += e.importance
            subs = e.subordinates
            if subs != None:
                for s in subs:
                    q.append(s)
        return total


