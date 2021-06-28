// Time Complexity : O(m*n)
// Space Complexity :  O(m+n) ?
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this - Needed help from Class notes

class Solution {
public:
    int orangesRotting(vector<vector<int>>& grid) {
        
        int m = grid.size();
        int n = grid[0].size();
        int time=0;
        int fresh = 0;
        
        queue<pair<int, int>> q;
        
        for(int i = 0; i < m; i++)
        {
            for(int j = 0; j < n; j++)
            {
                if(grid[i][j] == 2)
                {
                    q.push(pair(i, j));
                }
                
                if(grid[i][j] == 1)
                {
                    fresh++;
                }
            }
        }
        
        if(fresh == 0)
            return 0;
        
        vector<pair<int, int>> dir;
        dir.push_back(pair(1,0));
        dir.push_back(pair(-1,0));
        dir.push_back(pair(0,1));
        dir.push_back(pair(0,-1));
        
        while(!q.empty())
        {
            int size = q.size();
            
            for(int i = 0; i < size; i++)
            {
                pair<int, int> p = q.front();
                q.pop();
                
                for(int j = 0; j < dir.size(); j++)
                {
                    int r = p.first + dir[j].first;
                    int c = p.second + dir[j].second;
                    
                    if(r >= 0 && c >= 0 && r < m && c < n && grid[r][c] == 1)
                    {
                        grid[r][c] = 2;
                        q.push(pair(r,c));
                        fresh--;
                    }
                }
            }
            
            time++;
        }
        
        if(fresh != 0)
            return -1;
        
        return time-1;
    }
};