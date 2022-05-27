# Rotting Oranges
# Time Complexity : O(mn)
# Space Complexity : O(min(m,n))
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    dirs = [(1, 0), (0, 1), (-1, 0), (0, -1)]
    def orangesRotting(self, grid: List[List[int]]) -> int:
        m, n = len(grid), len(grid[0])
        Q = []
        fresh = 0
        time = 0
        if grid == None or len(grid) == 0: return 0
        for i in range(m):
            for j in range(n):
                if grid[i][j] == 2:
                    Q.append((i, j))
                    
                elif grid[i][j] == 1:
                    fresh += 1
                    
        if fresh == 0: return 0
        
        while Q:
            size = len(Q)
            for i in range(size):
                pos = Q.pop(0)
                for dir in self.dirs:
                    pos
                    r = pos[0] + dir[0]
                    c = pos[1] + dir[1]
                    
                    if r >= 0 and r < m and c >= 0 and c < n and grid[r][c] == 1:
                        fresh -= 1
                        Q.append((r, c))
                        grid[r][c] = 2
                        
            time += 1
            
        
        if fresh > 0: return -1
        
        return time-1

# Employee Importance
# Time Complexity : O(n) | n is the number of nodes
# Space Complexity : O(n) | When n-1 employees are the subordinates of one employee
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def search(self, nums: List[int], target: int) -> int:
        low = 0
        high = len(nums) - 1
        
        while low <= high:
            mid = low + (high - low) // 2
            
            if nums[mid] == target:
                return mid
            
            if nums[low] <= nums[mid]:
                if target < nums[mid] and target >= nums[low]:
                    high = mid - 1
                    
                else:
                    low = mid + 1
                    
            elif nums[mid] <= nums[high]:
                if target > nums[mid] and target <= nums[high]:
                    low = mid + 1
                else:
                    high = mid - 1
                    
        return -1

# Time Complexity : O(logm + logn) ||  where m is the number of steps required for the target element to fall within range of the subarray. n is number of elements within the range
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Nope ... A bit confused about the time complexity

class Solution:
    def search(self, reader: 'ArrayReader', target: int) -> int:
        if reader.get(0) == target:
            return 0
        start = 0
        end = 1
        out_of_bound = 2**31 - 1
        while reader.get(end) < target:
            if reader.get(end) == out_of_bound:
                break
            start = end
            end <<= 1
               
        
        while start <= end:
            m = start + (end - start) // 2
            mid_ele = reader.get(m)
            if mid_ele == target:
                return m
            elif target < mid_ele:
                end = m - 1                
            else:
                start = m + 1                
        return -1